package com.ticket.service;

import java.util.List;
import com.ticket.Entities.Users;

public interface UsersService {
	Users createUsers(Users passenger);
	String deleteUsers(int id);
	Users updateUsers(int id,Users users);
	Users getUsersById(int id);
	List<Users> getAllUsers();
	Users findByUsersNameAndEmail(String usersName,String email);
	List<Users> getUsersByName(String usersName);
	Users getUsersByEmail(String email);
}
