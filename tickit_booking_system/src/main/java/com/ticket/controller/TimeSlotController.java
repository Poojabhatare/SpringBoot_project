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

import com.ticket.Entities.TimeSlot;
import com.ticket.service.TimeSlotService;

@RestController
public class TimeSlotController {

	@Autowired
	private TimeSlotService timeSlotService;
	
	@PostMapping("/createTimeslot")
	ResponseEntity<TimeSlot> createTimeSlot(@RequestBody TimeSlot timeSlot){
		
		return new ResponseEntity<TimeSlot>(timeSlotService.createTimeSlot(timeSlot),HttpStatus.CREATED);
	}
	
	@GetMapping("/getTimeSlotById/{id}")
	public TimeSlot getTimeSlotById(@PathVariable int id) {
		
		return timeSlotService.getTimeSlotById(id);
	}
	
	@GetMapping("/getAllTimeSlot")
	public List<TimeSlot> getAllTimeSlot(){
		
		return timeSlotService.getAllTimeSlot();
	}
	
	@DeleteMapping("/deleteTimeSlot/{id}")
	public String deleteTimeSlot(@PathVariable("id") int id) {
		
		return timeSlotService.deleteTimeSlot(id);
	}
	
	@PutMapping("updateTimeSlot/{id}")
	public ResponseEntity<TimeSlot> updateTimeSlot(@PathVariable int id,
			@RequestBody TimeSlot timeSlot){
		
		return new ResponseEntity<TimeSlot>(timeSlotService.
				updateTimeSlot(id, timeSlot),HttpStatus.OK);
	}
}
