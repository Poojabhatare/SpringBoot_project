package com.ticket.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.repositories.UsersRepository;
import com.ticket.Entities.Users;
import com.ticket.exception.ResourceNotFoundException;

import com.ticket.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired 
	private UsersRepository usersRepository;
	
	@Override
	public Users createUsers(Users users) {
		return usersRepository.save(users);
	}
	
	@Override
	public String deleteUsers(int id) {
		String message=null;
		
		Optional<Users> users = usersRepository.findById(id);
		if(users.isPresent()) {
			usersRepository.deleteById(id);
			message=new String("Passenger record deleted successfully!!");
		}
		else {
			throw new ResourceNotFoundException("Passenger","id",id);
		}
		return message;
	}

	@Override
	public Users updateUsers(int id, Users users) {
		//orElseThrow() it means if object is present then it will return 
		// we are checking where the passenger with given id is exist or not in DB
		Users existingUsers = usersRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Users", "id", id));
		
		//we are getting data from client an set in existing passenger
		existingUsers.setUsersName(users.getUsersName());
		existingUsers.setEmail(users.getEmail());
		existingUsers.setAge(users.getAge());
		existingUsers.setGender(users.getGender());
		existingUsers.setPhno(users.getPhno());
		
		usersRepository.save(existingUsers);
		return existingUsers;
		
	}

	@Override
	public Users getUsersById(int id) {
		Users users = usersRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Users", "id", id));
		
		return users;
	}

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = usersRepository.findAll();
		return users;
	}

	@Override
	public Users findByUsersNameAndEmail(String usersName, String email) {
		Users users=usersRepository.findByUsersNameAndEmail(usersName, email);
		return users;
	}

	@Override
	public List<Users> getUsersByName(String usersName) {
		List<Users>users= usersRepository.getUsersByName(usersName);
		return users;
	}

	@Override
	public Users getUsersByEmail(String email) {
		
		return usersRepository.getUsersByEmail(email);
	}
	
	
}
