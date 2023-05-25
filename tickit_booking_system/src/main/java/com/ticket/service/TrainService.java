package com.ticket.service;

import java.util.List;

import com.ticket.Entities.Train;

public interface TrainService {
	
	Train createTrain(Train train);
	String assignTrainToTimeslot(int trainNo,int timeslotId);
	String deleteTrain(int trainNo);
	
	Train updateTrain(int trainNo,Train train);
	Train getTrainById(int trainNo);
	List<Train> getAllTrain();
	List<Train> searchTrain(String source , String destination);
	
}
