package com.ticket.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.Entities.Train;

public interface TrainRepository extends JpaRepository<Train, Integer>{

}
