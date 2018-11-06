package com.example.mcrm.controllers;

import com.example.mcrm.models.Doctor;
import com.example.mcrm.models.TimeSlot;
import com.example.mcrm.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/doctors",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping
    private ResponseEntity<List<Doctor>> getDoctors() {
        return ResponseEntity.ok(doctorsService.findAll());
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@Valid @RequestBody Doctor doctor) {
        Doctor created = doctorsService.create(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> get(@PathVariable("doctorId") Long doctorId) {
        return ResponseEntity.ok(doctorsService.findById(doctorId));
    }



    @PostMapping("{doctorId}/schedule")
    public ResponseEntity<?> addTimeSlot(@PathVariable("doctorId") Long doctorId,
                                         @Valid @RequestBody TimeSlot timeSlot) {

        doctorsService.schedule(doctorId, timeSlot);
        return ResponseEntity.ok().build();
    }

}
