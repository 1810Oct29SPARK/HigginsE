package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.repository.UsersDAO;

public class AuthenticationService {
	
	private UsersDAO ud;

	@Autowired
	public void setUserDAO(UsersDAO ud) {
		this.ud = ud;
	}
	
	public Users authenticateUser(Credentials credentials) {
		Users u = null;
		u = ud.getUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
		return u;
	}

}
