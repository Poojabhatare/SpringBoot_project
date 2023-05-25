package com.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.Entities.TicketDetails;
import com.ticket.service.TicketDetailsService;

@RestController
public class TicketDetailsController {

	@Autowired
	TicketDetailsService ticketDetailsService;
	
	@PostMapping("/bookTicket/{trainNo}/{passengerId}")
	public ResponseEntity<TicketDetails> bookTicket(@PathVariable("trainNo")int trainNo, 
			@PathVariable("passengerId") int user,@RequestBody TicketDetails ticketDetails) {
		
		return new ResponseEntity<TicketDetails>
		(ticketDetailsService.bookTicket(trainNo,user,ticketDetails),
				HttpStatus.CREATED);
	}
	
	@PostMapping("/cancelTicket/{ticketId}")
	public String cancelBooking(@PathVariable("ticketId") int ticketId) {
		return ticketDetailsService.cancelBooking(ticketId);
	}
	
}

