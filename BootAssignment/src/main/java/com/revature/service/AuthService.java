package com.revature.service;

import com.revature.beans.Users;
import com.revature.repositories.UserDAO;

public class AuthService {

	private UserDAO ud;
	
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public Users isValid(String username, String password) {
		
		Users user = ud.getUsersByUsername(username);
		if(user != null) {
			if(user.getPassword() == password) {
				return user;
			}
		}
		return null;
	}
}
