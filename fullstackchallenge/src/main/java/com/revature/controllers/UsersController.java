package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Users;
import com.revature.service.AuthService;
import com.revature.service.UserService;

@RestController
public class UsersController {

	private UserService us;
	private AuthService as;
	
	@Autowired
	public void setAuthService(AuthService as) {
		this.as = as;
	}
	
	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody Users user) {

		ResponseEntity<String> resp = null;
		try {
			us.saveUser(user);
			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public String loginPublisher(@RequestParam(name="username") String username, @RequestParam(name="password") String password, Model m) {

		Users user = as.isValid(username, password);
		if(user == null) {
		return "Not a valid user";
		} else {
			return ("{\"username\":\"" + user.getUsername()
			+ "\",\"firstName\":\"" + user.getFirstName()
			+ "\",\"lastName\":\"" + user.getLastName()
			+ "\",\"role\":\"" + user.getUserRole().getRole());
		}
	}
}