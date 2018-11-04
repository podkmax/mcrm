package com.example.mcrm.Controller;

import com.example.mcrm.DataObject.Doctor;
import com.example.mcrm.Model.MainModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/edit")
public class EditDoctors {

    @GetMapping
    private ArrayList<Doctor> getDoctors() {
        ArrayList<Doctor> listDoctor = MainModel.getAllDoctors();
        return listDoctor;
    }
}
