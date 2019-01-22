package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.repositories.UserDAO;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private UserDAO ud;
	
	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	

	@GetMapping("/byUsername")
	public ResponseEntity<User> getUserByUsername(@PathVariable User user) {
		return new ResponseEntity<User>(ud.getUserByUsername(user), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		ResponseEntity<String> resp = null;
		try {
			ud.save(user);
			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
