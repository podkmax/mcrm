package com.example.mcrm.Controller;

import com.example.mcrm.DataObject.Doctor;
import com.example.mcrm.Model.MainModel;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/controller")
public class MainController {
//    private Map<String, String> doctors = new HashMap<>();

    @GetMapping
    String getDoctorsList() {
//         doctors = MainModel.getAllDoctors();
        ArrayList<Doctor> doctors = MainModel.getTimeSlots("2018-11-02");
        Gson gson = new Gson();
        String jsonString = gson.toJson(doctors);
        System.out.println(jsonString);
        return jsonString;
    }
//    Map<String, String> getDoctorsList() {
//        doctors.put("1","doctor1");
//        doctors.put("2","doctor2");
//        doctors.put("3","doctor3");
//        doctors.put("4","doctor4");
//        return doctors;
//    }

//    @GetMapping("{id}")
//    public String getOne(@PathVariable String id) {
//        return doctors.get(id);
//    }
}
