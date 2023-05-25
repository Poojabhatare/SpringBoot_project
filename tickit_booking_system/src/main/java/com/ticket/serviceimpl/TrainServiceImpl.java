package com.ticket.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.Entities.TimeSlot;
import com.ticket.Entities.Train;
import com.ticket.exception.ResourceNotFoundException;
import com.ticket.repositories.TimeSlotRepository;
import com.ticket.repositories.TrainRepository;
import com.ticket.service.TrainService;

@Service
public  class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private TimeSlotRepository timeSlotRepository;
	
	@Override
	public Train createTrain(Train train) {
		
		return trainRepository.save(train);
	}

	@Override
	public String assignTrainToTimeslot(int trainNo, int timeslotId) {
		Train train = trainRepository.findById(trainNo).get();
		TimeSlot timeslot = timeSlotRepository.findById(timeslotId).get();
		
		List<Train> trains=new ArrayList<>();
		trains.add(train);
		timeslot.setTrains(trains);
		
		train.setTimeSlot(timeslot);
		trainRepository.save(train);
		return "TimeSlot added successfully!!";
	}


	@Override
	public String deleteTrain(int trainNo) {
		String message=null;
		Optional<Train> train = trainRepository.findById(trainNo);
		if(train.isPresent()) {
			trainRepository.deleteById(trainNo);
			message=new String("Train record deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("Train","id",trainNo);
		}
		return message;
	}

	@Override
	public Train updateTrain(int trainNo, Train train) {
		Train existingTrain = trainRepository.findById(trainNo).orElseThrow(()->
		new ResourceNotFoundException("Users", "id", trainNo));
		
		existingTrain.setTrainName(train.getTrainName());
		existingTrain.setDestination(train.getDestination());
		existingTrain.setSource(train.getSource());
		existingTrain.setAvailableSeat(train.getAvailableSeat());
		
		trainRepository.save(existingTrain);
		return existingTrain;
	}

	@Override
	public Train getTrainById(int trainNo) {
		Train train = trainRepository.findById(trainNo).orElseThrow(()->
		new ResourceNotFoundException("Users", "id", trainNo));
		
		return train;
	}

	@Override
	public List<Train> getAllTrain() {
		List<Train> train = trainRepository.findAll();
		return train;
	}

	@Override
	public List<Train> searchTrain(String source , String destination) {
		List<Train> trains = trainRepository.findAll();
		List<Train> trn = new ArrayList<>();
		for(Train t:trains) 
		{
			if((t.getSource().equalsIgnoreCase(source))&&(t.getDestination().equalsIgnoreCase(destination)))
			{
				trn.add(t);
			}
		}
		return trn;
	}

}
