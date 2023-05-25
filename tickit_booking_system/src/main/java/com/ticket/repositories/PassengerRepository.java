package com.ticket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.Entities.OtherPassenger;

public interface PassengerRepository extends JpaRepository<OtherPassenger, Integer>{

}
