package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ticket.Entities.Train;
import com.ticket.service.TrainService;

@RestController
public class TrainController {

	@Autowired
	TrainService trainService;
	
	@PostMapping("/createTrain")
	ResponseEntity<Train> createTrain(@RequestBody Train train){
		
		return new ResponseEntity<Train>(trainService.createTrain(train),HttpStatus.CREATED);
	}
	
	@PostMapping("/assignTimeSlot/{trainNo}/{timeslotId}")
	public String assignTrainToTimeslot(@PathVariable("trainNo") int trainNo,@PathVariable("timeslotId") int timeslotId) {
		return trainService.assignTrainToTimeslot(trainNo, timeslotId);
	}
	
	@DeleteMapping("/deleteTrain/{trainNo}")
	public String deleteTrain(@PathVariable("trainNo") int trainNo) {
		
		return trainService.deleteTrain(trainNo);
	}
	
	@PutMapping("updateTrain/{trainNo}")
	public ResponseEntity<Train> updaTrain(@PathVariable int trainNo,
			@RequestBody Train train){
		
		return new ResponseEntity<Train>(trainService.
				updateTrain(trainNo, train),HttpStatus.OK);
	}
	
	@GetMapping("/getTrainById/{trainNo}")
	public Train getTrainById(@PathVariable int trainNo) {
		
		return trainService.getTrainById(trainNo);
	}
	
	@GetMapping("/getAllTrain")
	public List<Train> getAllTrain(){
		
		return trainService.getAllTrain();
	}
	
	@GetMapping("/searchTrain/{source}/{destination}")
	public List<Train> searchTrain(@PathVariable("source") String source, @PathVariable("destination") String destination)
	{
		return trainService.searchTrain(source, destination);
	}
}
