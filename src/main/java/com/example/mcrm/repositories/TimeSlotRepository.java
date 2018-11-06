package com.example.mcrm.repositories;

import com.example.mcrm.models.TimeSlot;
import com.example.mcrm.models.TimeSlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, TimeSlotId> {
}
