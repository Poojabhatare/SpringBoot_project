package com.ticket.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.Entities.OtherPassenger;
import com.ticket.Entities.TicketDetails;
import com.ticket.Entities.Train;
import com.ticket.Entities.Users;
import com.ticket.exception.ResourceNotFoundException;
import com.ticket.repositories.PassengerRepository;
import com.ticket.repositories.TicketDetailsRepositories;
import com.ticket.repositories.TrainRepository;
import com.ticket.repositories.UsersRepository;
import com.ticket.service.TicketDetailsService;

@Service
public class TicketDetailsServiceImpl implements TicketDetailsService{

	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private TicketDetailsRepositories ticketDetailsRepositories;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public TicketDetails bookTicket(int trainNo, int user, TicketDetails ticketDetails) {
		Train train = trainRepository.findById(trainNo).get();
		Users users = usersRepository.findById(user).get();
		
		//we are deducting available seat with no of passenger
		
		int total_seat= (train.getAvailableSeat()-ticketDetails.getNoOfPassenger())-1;
		train.setAvailableSeat(total_seat);// updating seat after deduction
		
		//update total fare in ticket table
		
		ticketDetails.setTotalFare(train.getFare()*(ticketDetails.getNoOfPassenger()));
		ticketDetails.setUsers(users);
		ticketDetails.setTrain(train);
		ticketDetails.setNoOfPassenger(ticketDetails.getNoOfPassenger());
		List<OtherPassenger> passengerList=ticketDetails.getPassengers();
		ticketDetails.setPassengers(passengerList);
		
		
		OtherPassenger passenger=null;
		if(!passengerList.isEmpty()) {
			for(OtherPassenger p:passengerList) {
				
				passenger=p;
				if(p!=null) {
					passenger.setTicketDetails(ticketDetails);
					passenger.setStatus("Confirmed");
				}
				passengerRepository.save(passenger);
			}
		}
		ticketDetails.setStatus("Booked");
		TicketDetails bookedTicket= ticketDetailsRepositories.save(ticketDetails);
		
		return bookedTicket;
	}

	@Override
	public String cancelBooking(int ticketId) {
		String message=null;
		Optional<TicketDetails> opTicket=ticketDetailsRepositories.findById(ticketId);
		if(opTicket.isPresent()) {
			//update the available seat
			int nop=opTicket.get().getNoOfPassenger();
			TicketDetails tdetails=opTicket.get();
			tdetails.getTrain().setAvailableSeat( tdetails.getTrain().getAvailableSeat()+nop);  //98+2
			tdetails.setStatus("cancelled");
			
			List<OtherPassenger> passengerList=tdetails.getPassengers();
			for(OtherPassenger p:passengerList) {
				passengerRepository.delete(p);
			}
			ticketDetailsRepositories.save(tdetails);
			message="Your booking has cancelled";
		}
		else
			throw new ResourceNotFoundException("Ticket", "id", ticketId);
		return message;
	}

}
