package com.DOP.dayOffProj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DOP.dayOffProj.beans.User;
import com.DOP.dayOffProj.beans.UserRole;
import com.DOP.dayOffProj.repositories.UserDAO;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private UserDAO ud;

	@Autowired
	public UserController(UserDAO ud) {
		super();
		this.ud = ud;
	}

	public UserController() {
		super();
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(ud.findAll(), HttpStatus.OK);
	}

	@GetMapping("/role/{id}")
	public ResponseEntity<List<User>> getAllUsersByUserRole(@PathVariable int id) {
		return new ResponseEntity<>(ud.getByUserRole(new UserRole(id, null)),HttpStatus.OK);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<List<User>> getUserByEmail(@PathVariable String email){
		return new ResponseEntity<>(ud.getByEmail(email),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User user){
		ResponseEntity<String> resp = null;
		
		try {
			ud.save(user);
			resp = new ResponseEntity<>("Got It Boss!",HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Negative Boss!", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}

}
