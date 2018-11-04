package com.example.mcrm.Controller;

import com.example.mcrm.DataObject.Doctor;
import com.example.mcrm.Model.MainModel;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/addtimeslot")
@CrossOrigin
public class AddTimeSlot {
    @PostMapping
    public String getFreeTimeSlots(@RequestBody String date) {
        ArrayList<Doctor> doctors = MainModel.getTimeSlots("2018-11-02");
        Gson gson = new Gson();
        String jsonString = gson.toJson(doctors);
        System.out.println(jsonString);
        return jsonString;
    }
}


