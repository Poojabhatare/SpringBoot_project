package com.ticket.Entities;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDetails {
	@Id
	@GenericGenerator(name = "ticket_no", strategy = "com.ticket.Entities.TicketIdGeneration")
	@GeneratedValue(generator ="ticket_no")
	private int ticketId;
	
	@Column(name="total_passenger",length =9)
	private int noOfPassenger;
	
	@Column(length =200)
	private double totalFare;
	
	@Column(name="booking_date")
	private LocalDate bookingDate=LocalDate.now();
	
	@Column(name="travel_date")
	private LocalDate travelDate;
	
	@Column(length =100)
	private String source;
	
	@Column(length =100)
	private String destination;
	
	@Column(length =50)
	private String classType;
	
	@Column(length =50)
	private String quota;
	
	@OneToMany(mappedBy = "ticketDetails",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("ticketDetails")
	private List<OtherPassenger> passengers;
	
	@OneToOne
	private Users users;
	
	@OneToOne
	private Train train;
	
	@Column(length=50)
	private String status;
	
	
}
