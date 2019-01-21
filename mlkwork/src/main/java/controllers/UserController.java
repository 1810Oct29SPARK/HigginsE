package controllers;

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

import beans.User;
import beans.UserRole;
import repositories.UserDAO;

@RestController
@RequestMapping(value="/api")
public class UserController {
	private UserDAO ud;

	
	@Autowired
	public void setUd(UserDAO ud) {
		this.ud = ud;
	}
	
	@GetMapping("/byUser/{user}")
	public ResponseEntity<User> getUserByUsername(@PathVariable User user){
		return new ResponseEntity<>(ud.GetByUsername(user.getUsername()), HttpStatus.OK);
	}
	
	
	@PostMapping("/addUser")
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
