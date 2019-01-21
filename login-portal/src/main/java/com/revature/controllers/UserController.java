package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.beans.UserRole;
import com.revature.repository.UserDAO;
import com.revature.services.AuthenticationService;
import com.revature.services.UserService;

@RestController
public class UserController {

	private UserService us;
	private AuthenticationService as;
	
	@Autowired
	public void setAuthService(AuthenticationService as) {
		this.as = as;
	}
	
	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(us.getAllUsers(), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		ResponseEntity<String> resp = null;
		
		UserRole role = user.getUserRole(); 
		
		try {
			us.registerUser(user.getUsername(), user.getEmail(), user.getPassword(), role.getRole()); 
			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public String loginPublisher(@RequestParam(name="username") String username, @RequestParam(name="password") String password, Model m) {

		User user = as.isValidUser(username, password);
		if(user == null) {
		return "Not a valid user";
		} else {
			return ("{\"username\":\"" + user.getUsername()
			+ "\",\"email\":\"" + user.getEmail()
			+ "\",\"role\":\"" + user.getUserRole().getRole());
		}
	}
}