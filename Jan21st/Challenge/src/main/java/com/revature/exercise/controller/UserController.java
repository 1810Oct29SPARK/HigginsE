package com.revature.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.revature.exercise.dao.UserDAO;
import com.revature.exercise.database.User;
import com.revature.exercise.database.UserRole;

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	private UserDAO ud;
	
	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(ud.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/byUserRole/{userRoleNum}")
	public ResponseEntity<List<User>> getAllUsersByUserRole(@PathVariable int userRoleNum){
		return new ResponseEntity<>(ud.getByUserRole(new UserRole(userRoleNum)), HttpStatus.OK);
	}
	
	@GetMapping("/byName/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable String name) {
		return new ResponseEntity<>(ud.getByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		ResponseEntity<String> resp = null;
		try {
			ud.save(user);
			resp = new ResponseEntity<>("User created!", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Failed to create new User!", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
