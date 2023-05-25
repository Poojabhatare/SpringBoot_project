package com.ticket.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "OtherPassenger")
public class OtherPassenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	private String name;
	
	private int age;
	
	@Column(length = 20)
	private String gender;
	
	@Column(length=50)
	private String status;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("passengers")
	TicketDetails ticketDetails;
}
