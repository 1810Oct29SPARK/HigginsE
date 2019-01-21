package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.service.AuthService;
import com.revature.service.UsersService;

@RestController
public class UsersController {

	private UsersService us;
	private AuthService as;
	
	@Autowired
	public void setAuthService(AuthService as) {
		this.as = as;
	}
	
	@Autowired
	public void setUserService(UsersService us) {
		this.us = us;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUsers(@RequestBody Users users) {

		ResponseEntity<String> response = null;
		try {
			us.saveUsers(users);
			response = new ResponseEntity<>("SUCCESSFULLY CREATED USER", HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}