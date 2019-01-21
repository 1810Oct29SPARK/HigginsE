package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Login;
import com.revature.beans.User;
import com.revature.repositories.UserDAO;

@Service
public class AuthService {

	private UserDAO ud;

	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public User authenticateUser(Login login) {
		User u = null;
		u = ud.getUserByNameAndPassword(login.getName(), login.getPassword());
		return u;
	}
	
}