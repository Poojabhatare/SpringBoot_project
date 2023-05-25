package com.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.Entities.TicketDetails;

public interface TicketDetailsRepositories extends JpaRepository<TicketDetails, Integer> {

}
