
package com.swop.revature.fullstackchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swop.revature.fullstackchallenge.beans.Login;
import com.swop.revature.fullstackchallenge.beans.User;
import com.swop.revature.fullstackchallenge.repositories.UserDAO;

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