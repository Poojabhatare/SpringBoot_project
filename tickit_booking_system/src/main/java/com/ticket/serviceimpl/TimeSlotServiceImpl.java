package com.ticket.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.Entities.TimeSlot;
import com.ticket.exception.ResourceNotFoundException;
import com.ticket.repositories.TimeSlotRepository;
import com.ticket.service.TimeSlotService;

@Service
public class TimeSlotServiceImpl implements TimeSlotService{

	@Autowired
	private TimeSlotRepository timeSlotRepository;
	
	@Override
	public TimeSlot createTimeSlot(TimeSlot timeSlot) {
		return timeSlotRepository.save(timeSlot);
	}

	@Override
	public TimeSlot getTimeSlotById(int id) {
		TimeSlot timeSlot = timeSlotRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TimeSlot", "id", id));
		
		return timeSlot;
	}

	@Override
	public List<TimeSlot> getAllTimeSlot() {
		List<TimeSlot> timeSlot = timeSlotRepository.findAll();
		return timeSlot;
	}

	@Override
	public String deleteTimeSlot(int id) {
		String message=null;
		
		Optional<TimeSlot> timeSlot = timeSlotRepository.findById(id);
		if(timeSlot.isPresent()) {
			timeSlotRepository.deleteById(id);
			message=new String("Time Slot deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("TimeSlot","id",id);
		}
		return message;
	}

	@Override
	public TimeSlot updateTimeSlot(int id, TimeSlot timeSlot) {
		TimeSlot existingTimeSlot = timeSlotRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("TimeSlot", "id", id));
		
		existingTimeSlot.setDepartureTime(timeSlot.getDepartureTime());
		existingTimeSlot.setArrivalTime(timeSlot.getArrivalTime());
		
		
		timeSlotRepository.save(existingTimeSlot);
		return existingTimeSlot;
	}
}
