package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Login;
import com.revature.beans.User;
import com.revature.service.AuthService;
import com.revature.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private UserService us;
	private AuthService as;
	
	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}
	
	@Autowired
	public void setAuthService(AuthService as) {
		this.as = as;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody Login login) {
		ResponseEntity<User> resp = null;
		User u = as.authenticateUser(login);
		if (u != null) {
			resp = new ResponseEntity<User>(u, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<User>(u, HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		ResponseEntity<String> resp = null;
		try {
			us.createUser(user);
			resp = new ResponseEntity<String>("SUCCESSFULLY CREATED", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("FAILURE! ERROR: " + e, HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value = "/getByUsername")
	public ResponseEntity<User> getUserByUsername(@RequestBody String username) {
		ResponseEntity<User> resp = null;
		try {
			resp = new ResponseEntity<User>(us.getUserByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value = "/getUser")
	public ResponseEntity<User> getUser(@RequestBody User user) {
		ResponseEntity<User> resp = null;
		try {
			resp = new ResponseEntity<User>(us.getUser(user), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
