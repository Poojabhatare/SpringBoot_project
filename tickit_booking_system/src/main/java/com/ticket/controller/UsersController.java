package com.ticket.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ticket.Entities.Users;
import com.ticket.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:55091")
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	// Handler method to handle createPassenger request
	@PostMapping("/createUsers")
	ResponseEntity<Users> createUsers(@RequestBody Users users){
		
		return new ResponseEntity<Users>(usersService.
				createUsers(users),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteUsers/{id}")
	public String deleteUsers(@PathVariable("id") int id) {
		
		return usersService.deleteUsers(id);
	}
	
	@PutMapping("updateUsers/{id}")
	public ResponseEntity<Users> updaUsers(@PathVariable int id,
			@RequestBody Users users){
		
		return new ResponseEntity<Users>(usersService.
				updateUsers(id, users),HttpStatus.OK);
	}
	
	@GetMapping("/getUsersById/{id}")
	public Users getUsersById(@PathVariable int id) {
		
		return usersService.getUsersById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		
		return usersService.getAllUsers();
	}
	
	@GetMapping("/getUsers/{uname}/{email}")
	public ResponseEntity<Users> findByUsersNameAndEmail(@PathVariable("uname") String usersName,
		@PathVariable("email") String email){
		
		return new ResponseEntity<Users>(usersService.findByUsersNameAndEmail(usersName, email),HttpStatus.OK);
	}
	
	@GetMapping("/getUsersByName/{name}")
	List<Users> getUsersByName(@PathVariable("name") String usersName){
		
		return usersService.getUsersByName(usersName);
	}
	
	@GetMapping("/getUsersByEmail/{email}")
	Users getUsersByEmail(@PathVariable("email") String email) {
		
		return usersService.getUsersByEmail(email);
	}
	
}
