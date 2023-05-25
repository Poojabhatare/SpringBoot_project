package com.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.Entities.TimeSlot;


public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer>{

	
}
