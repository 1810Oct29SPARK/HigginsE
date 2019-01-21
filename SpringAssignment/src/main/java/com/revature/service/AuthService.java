package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.beans.Users;
import com.revature.repositories.UsersDAO;

@Service
public class AuthService {

	private UsersDAO ud;
	
	public void setUsersDAO(UsersDAO ud) {
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