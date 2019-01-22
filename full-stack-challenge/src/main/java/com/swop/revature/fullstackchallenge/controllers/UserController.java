package com.swop.revature.fullstackchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swop.revature.fullstackchallenge.beans.Login;
import com.swop.revature.fullstackchallenge.beans.User;
import com.swop.revature.fullstackchallenge.repositories.UserDAO;
import com.swop.revature.fullstackchallenge.service.AuthService;
import com.swop.revature.fullstackchallenge.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserService us;
	private AuthService as;
	private UserDAO ud;
	
	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}
	
	@Autowired
	public void setAuthService(AuthService as) {
		this.as = as;
	}
	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
		}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
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
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		ResponseEntity<User> resp = null;
		User u = null;
		try {
			us.createUser(user);
			u = us.getUser(user);
			resp = new ResponseEntity<User>(u,  HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<User>(u, HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{name}")
	public ResponseEntity <User> getUserByName( @PathVariable String name) {
		return new ResponseEntity<>(ud.getUserByName(name), HttpStatus.OK);
				
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/all")
	public ResponseEntity <List<User>> getAllUsers() {
		return new ResponseEntity<>(ud.findAll(), HttpStatus.OK);
				
	}
	
}