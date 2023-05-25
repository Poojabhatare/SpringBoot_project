package com.ticket.Entities;



import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="train_details")
public class Train {

	@Id
	@GenericGenerator(name = "train_no", strategy = "com.ticket.Entities.TrainNoGeneration")
	@GeneratedValue(generator ="train_no")
	private int trainNo;
	@Column(length =50)
	private String trainName;
	@Column(length =50)
	private String source;
	@Column(length =50)
	private String destination;
	private double fare;
	private int availableSeat;
	
	@ManyToOne
	@JoinColumn(name = "time_slot")
	@JsonIgnoreProperties("trains")
	private TimeSlot timeSlot;
	
	


}
