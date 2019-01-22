package com.revature.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.service.AuthenticationService;
import com.revature.service.UsersService;

public class UsersController {
	
	@CrossOrigin
	@RestController
	@RequestMapping(value = "/user")
	public class UserController {
		
		private UsersService us;
		private AuthenticationService as;
		
		@Autowired
		public void setUserService(UsersService us) {
			this.us = us;
		}
		
		@Autowired
		public void setAuthService(AuthenticationService as) {
			this.as = as;
		}
		
		@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
		@PostMapping(value = "/login")
		public ResponseEntity<Users> login(@RequestBody Credentials credentials) {
			ResponseEntity<Users> resp = null;
			Users u = as.authenticateUser(credentials);
			if (u != null) {
				resp = new ResponseEntity<Users>(u, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Users>(u, HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
		
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping(value = "/create")
		public ResponseEntity<Users> createUser(@RequestBody Users user) {
			ResponseEntity<Users> resp = null;
			try {
				us.createUser(user);
				resp = new ResponseEntity<Users>(us.getUser(user), HttpStatus.OK);
			} catch (Exception e) {
				resp = new ResponseEntity<Users>(us.getUser(user), HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
		
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping(value = "/getByUsername")
		public ResponseEntity<Users> getUserByUsername(@RequestBody String username) {
			ResponseEntity<Users> resp = null;
			JSONObject js = new JSONObject(username);
			String user = js.getString("username");
			Users u = us.getUserByUsername(user);		
			if (u != null) {
				resp = new ResponseEntity<Users>(u, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Users>(u, HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
		
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping(value = "/getUser")
		public ResponseEntity<Users> getUser(@RequestBody Users user) {
			ResponseEntity<Users> resp = null;
			try {
				resp = new ResponseEntity<Users>(us.getUser(user), HttpStatus.OK);
			} catch (Exception e) {
				resp = new ResponseEntity<Users>(new Users(), HttpStatus.BAD_REQUEST);
			}
			return resp;
		}
	}
}
