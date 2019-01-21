package com.revature.services;

import com.revature.beans.User;
import com.revature.daos.UserDAO;

public class AuthService {

	private UserDAO ud;
	
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public User isValid(String login, String pass) {
		
		User user = ud.getUserByLogin(login);
		if(user != null) {
			if(user.getPass() == pass) {
				return user;
			}
		}
		return null;
	}
}