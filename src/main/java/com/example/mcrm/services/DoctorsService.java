package com.example.mcrm.services;

import com.example.mcrm.models.Doctor;
import com.example.mcrm.models.TimeSlot;
import com.example.mcrm.repositories.DoctorsRepository;
import com.example.mcrm.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DoctorsService {

	@Autowired
	private DoctorsRepository doctorsRepository;

	@Autowired
	private TimeSlotRepository timeSlotRepository;

	public List<Doctor> findAll(){
		return doctorsRepository.findAll();
	}


	public Doctor findById(Long id) {
		return doctorsRepository.getOne(id);
	}

	public Doctor create(Doctor doctor) {
		return doctorsRepository.saveAndFlush(doctor);
	}

	public Doctor update(Long id, Doctor doctor) {
		Doctor fromDb = doctorsRepository.getOne(id);
		fromDb.setName(doctor.getName());
		fromDb.setSpecialization(doctor.getSpecialization());
		return doctorsRepository.saveAndFlush(fromDb);
	}

	public void schedule(Long doctorId, TimeSlot timeSlot) {
		Doctor fromDb = doctorsRepository.getOne(doctorId);
		timeSlot.setDoctor(fromDb);
		timeSlotRepository.saveAndFlush(timeSlot);
	}
}
