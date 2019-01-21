package com.revature.challenge.FullStackChallenge.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.challenge.FullStackChallenge.beans.User;
import com.revature.challenge.FullStackChallenge.repositories.UserDAO;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	private UserDAO ud;
	
	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	@PostMapping(value="/getUserByUsername")
	public ResponseEntity<User> getUserByUsername(@RequestBody String username) {
		ResponseEntity<User> resp = null;
		JSONObject js = new JSONObject(username);
		String usern = js.getString("username");
		User u = ud.getUserByUsername(usern);
		if (u != null) {
			resp = new ResponseEntity<User>(u, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<User>(u, HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<User> loginWithUsernameAndPassword(@RequestBody String username, String password) {
		ResponseEntity<User> resp = null;
		JSONObject js = new JSONObject(username);
		String usern = js.getString("username");
		String userp = js.getString("password");
		User u = ud.getUserByUsername(usern);
		if (u != null) {
			if (usern.equals(u.getUsername()) && userp.equals(u.getPassword())) {
				resp = new ResponseEntity<>(u, HttpStatus.I_AM_A_TEAPOT);
			}
			else {
				resp = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		else { 
			resp = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
