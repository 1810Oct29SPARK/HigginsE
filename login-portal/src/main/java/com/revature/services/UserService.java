package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.beans.UserRole;
import com.revature.repository.UserDAO;

@Service("userService")
public class UserService {

	UserDAO ud;

	public UserService() {
		super();
	}

	public UserService(UserDAO ud) {
		super();
		this.ud = ud;
	}

	public UserDAO getUd() {
		return ud;
	}

	@Autowired
	@Qualifier("UserDAO")
	public void setUd(UserDAO ud) {
		this.ud = ud;
	}

	public User registerUser(String username, String email, String password, String userRole) {

		UserRole role = new UserRole(userRole);

		User user = new User(username, email, password, role);

		return ud.save(user);
	}
	
	public List<User> getAllUsers() {

		return ud.findAll(); 
	}

	public User getUserbyId(int id) {

		return ud.getOne(id);
	}
	
	public User getUserbyUsername(String username) {

		return ud.getByUsername(username); 
	}

}
