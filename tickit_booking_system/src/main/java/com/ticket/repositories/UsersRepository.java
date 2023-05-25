package com.ticket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ticket.Entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	//custom finder method
	Users findByUsersNameAndEmail(String usersName,String email);
	
	@Query("select u from Users u where u.usersName=?1")
	List<Users> getUsersByName(String usersName);
	
	@Query("select u from Users u where u.email=:email")
	Users getUsersByEmail(@Param("email") String email);

		

}
