package com.ticket.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Users")
public class Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usersId;
	
	@Column(name = "name", length = 30)
	private String usersName;
	
	private int age;
	
	@Column(length = 20)
	private String gender;
	
	@Column(length = 60, unique = true)
	private String email;
	
	@Column(length = 10, unique = true)
	private String phno;

	
}
