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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

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
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(us.getUsers(), HttpStatus.OK);
	}
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		ResponseEntity<String> resp = null;
		try {
			us.saveUser(user);
			resp = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public String loginPublisher(@RequestParam(name="login") String login, @RequestParam(name="pass") String pass, Model m) {

		User user = as.isValid(login, pass);
		if(user == null) {
		return "Not a valid user";
		} else {
			return ("{\"login\":\"" + user.getLogin()
			+ "\",\"role\":\"" + user.getUserRole().getUserRole());
		}
	}
}