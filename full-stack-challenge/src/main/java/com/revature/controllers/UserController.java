package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.repositories.UserDAO;

@RestController
@RequestMapping(value="/api")
public class UserController {

	private UserDAO ud; 
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Users>> getAllUsers() {
		return new ResponseEntity<>(ud.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping(value="/addUser")
	public ResponseEntity<String> addNewUser(@RequestBody Users user) {
		
		ResponseEntity<String> resp = null; 
		try {
			ud.save(user);
			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
		
	}
}
