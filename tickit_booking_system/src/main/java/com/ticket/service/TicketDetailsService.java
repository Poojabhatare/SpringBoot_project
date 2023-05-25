 package com.ticket.service;

import com.ticket.Entities.TicketDetails;

public interface TicketDetailsService {

	TicketDetails bookTicket(int trainNo, int user,TicketDetails ticketDetails);
	String cancelBooking(int ticketId);
}
