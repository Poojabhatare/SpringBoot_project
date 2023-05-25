package com.ticket.service;

import java.util.List;

import com.ticket.Entities.TimeSlot;

public interface TimeSlotService {

	TimeSlot createTimeSlot(TimeSlot timeSlot);
	TimeSlot getTimeSlotById(int id);
	List<TimeSlot> getAllTimeSlot();
	String deleteTimeSlot(int id);
	TimeSlot updateTimeSlot(int id,TimeSlot timeSlot);
}
