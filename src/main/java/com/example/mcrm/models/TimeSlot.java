package com.example.mcrm.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "time_slots")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeSlot {

    @Valid
    @NotNull
    @EmbeddedId
    @JsonUnwrapped
    private TimeSlotId id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TimeSlotStatus status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public TimeSlotId getId() {
        return id;
    }

    public void setId(TimeSlotId id) {
        this.id = id;
    }

    public TimeSlotStatus getStatus() {
        return status;
    }

    public void setStatus(TimeSlotStatus status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
