package com.assignment.controllers;

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

import com.assignment.beans.Role;
import com.assignment.beans.User;
import com.assignments.repositories.UserDAO;

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	private UserDAO ud;
	
	@Autowired
	public void setFlashcardDAO(UserDAO ud) {
		this.ud = ud;
	}
	
//	@GetMapping("/all")
//	public ResponseEntity<List<User>> getAllUsers(){
//		return new ResponseEntity<>(ud.findAll(), HttpStatus.OK);
//	}
	
	@GetMapping("/byRole/{roleId}")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable int roleId){
		return new ResponseEntity<>(ud.getByRole(new Role(roleId, null)),HttpStatus.OK);
	}
	
//	@PostMapping("/addUser")
//	public ResponseEntity<String> addUser(@RequestBody User user){
//		ResponseEntity<String> resp = null;
//		try {
//			ud.save(user);
//			resp = new ResponseEntity<>("User successfully added", HttpStatus.OK);
//		} catch (Exception e){
//			resp = new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}

}
