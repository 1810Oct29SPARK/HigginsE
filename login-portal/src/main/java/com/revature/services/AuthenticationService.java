package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.repository.UserDAO;

@Service("authenticationService")
public class AuthenticationService {
	
	private UserDAO ud;
	
	public AuthenticationService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationService(UserDAO ud) {
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
	
	public User isValidUser(String username, String password) {
		
		User user = ud.getByUsername(username); 
		
		if (user!= null && user.getPassword().equals(password)) {
			return user; 
		}
		
		return null; 
	}
	
}
