package com.example.mcrm.repositories;

import com.example.mcrm.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {
}
