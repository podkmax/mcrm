package com.example.mcrm.DataObject;

import java.util.ArrayList;

public class Doctor {
    private String id;
    private String name;
    private String specName;
    private ArrayList<DoctorSchedule> schedule;
    private ArrayList<TimeSlots> timeSlots;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public void setTimeSlots(ArrayList<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public ArrayList<DoctorSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<DoctorSchedule> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(String day, String start, String end) {
        this.timeSlots = new ArrayList<>();
        TimeSlots timeSlot = new TimeSlots();
        timeSlot.setDay(day);
        timeSlot.setStartTimeSlot(start);
        timeSlot.setEndTimeSlot(end);
        this.timeSlots.add(timeSlot);
    }

//    public Gson timeSlots() {
//        ArrayList<String> json = new ArrayList<>();
//        Gson gson = new Gson();
//        String jsonString = gson.toJson();
//    }
}
