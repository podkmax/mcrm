package com.example.mcrm.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class TimeSlotId implements Serializable {

	@NotNull
	@Column(name = "day")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate day;

	@NotNull
	@Column(name = "start_period")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime startTimeSlot;

	@NotNull
	@Column(name = "end_period")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	private LocalTime endTimeSlot;


	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public LocalTime getStartTimeSlot() {
		return startTimeSlot;
	}

	public void setStartTimeSlot(LocalTime startTimeSlot) {
		this.startTimeSlot = startTimeSlot;
	}

	public LocalTime getEndTimeSlot() {
		return endTimeSlot;
	}

	public void setEndTimeSlot(LocalTime endTimeSlot) {
		this.endTimeSlot = endTimeSlot;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TimeSlotId)) return false;
		TimeSlotId that = (TimeSlotId) o;
		return Objects.equals(day, that.day) &&
				Objects.equals(startTimeSlot, that.startTimeSlot) &&
				Objects.equals(endTimeSlot, that.endTimeSlot);
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, startTimeSlot, endTimeSlot);
	}
}
