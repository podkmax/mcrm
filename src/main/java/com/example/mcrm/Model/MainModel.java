package com.example.mcrm.Model;

import com.example.mcrm.DataObject.Doctor;
import com.example.mcrm.DataObject.DoctorSchedule;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class MainModel {

    static private String username;
    static private String password;
    static private String connectionURL;

    private static void getProperties() {
        Properties props = null;
        try {
            FileInputStream pFile = new FileInputStream("C:\\podkmax\\mcrm\\src\\main\\resources\\application.properties");
            props = new Properties();
            props.load(pFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = (String) props.get ("spring.datasource.username");
        password = (String) props.get ("spring.datasource.password");
        connectionURL = (String) props.get ("spring.datasource.url");

    }
    private static Connection connect() {
        getProperties();
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static Statement getStatment() {
        Connection connection = connect();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private static PreparedStatement getPreparedStatment(String sql) {
        Connection connection = connect();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static ArrayList<Doctor> getAvailableDoctors(String date) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        String sql = "select * from doc_time_avail NATURAL JOIN doctors WHERE date = ? ORDER BY doctors.doctor_id;";
        PreparedStatement statement = getPreparedStatment(sql);
        try {
            statement.setString(1, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                DoctorSchedule schedule = new DoctorSchedule();
                ArrayList<DoctorSchedule> schedules = new ArrayList<>();
                doctor.setId(resultSet.getString("doctor_id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSpecName(resultSet.getString("position"));
                schedule.setDay(date);
                schedule.setStart(resultSet.getString("start_time"));
                schedule.setEnd(resultSet.getString("end_time"));
                schedules.add(schedule);
                doctor.setSchedule(schedules);
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static ArrayList<Doctor> getTimeSlots(String date) {
        ArrayList<Doctor> doctors = getAvailableDoctors(date);
        String sql = "select * from appointments where day_time = ?";
        PreparedStatement statement = getPreparedStatment(sql);
        try {
            statement.setString(1, date);
            ResultSet resultSet = statement.executeQuery();
            for (Doctor doctor : doctors) {
                for (int i = 0; resultSet.next(); i++ ){
                    String id = resultSet.getString("doctor_id");
                    if (doctor.getId().equals(id)){
                        doctor.setTimeSlots(date, resultSet.getString("start_time"), resultSet.getString("end_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public static ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> listDoc = new ArrayList<>();
        Connection connection = connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM doctors");
            while (resultSet.next()) {
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getString(1));
                doctor.setName(resultSet.getString(2));
                doctor.setSpecName(resultSet.getString(3));
                listDoc.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return listDoc;
    }

    public static void generateTimeSlot(String date, String name) {
        //insert timeSlot into DB;
    }

//    public static void addDoctor(Doctor doctor) {
//        Connection connection = connect();
//        String sql = "INSERT INTO doctors(name,position) VALUES (?,?)";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, doctor.getName());
//            statement.setString(2, doctor.setSpecName(););
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
