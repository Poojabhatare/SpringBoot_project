package com.ticket.Entities;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	
	@OneToMany(mappedBy = "timeSlot")
	@JsonIgnoreProperties("timeSlot")
	private List<Train> trains;
}
