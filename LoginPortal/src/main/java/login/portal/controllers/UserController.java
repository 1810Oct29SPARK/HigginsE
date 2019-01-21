package login.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import login.portal.model.User;
import login.portal.repositories.UserDAO;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private UserDAO dao;
	
	@Autowired
	public void setUserDAO(UserDAO dao) {
		this.dao = dao;
	}
	
	//GET method for getting a user by their username
	@GetMapping("/getUser/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
		return new ResponseEntity<>(dao.getUserByUsername(new User(username)), HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		
		ResponseEntity<String> resp = null;
		try {
			dao.save(user);
			resp = new ResponseEntity<>("NEW USER SUCCESSFULLY CREATED", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE NEW USER...", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

}
