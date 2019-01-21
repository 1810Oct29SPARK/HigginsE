package com.revature.services;

import java.util.List;

import com.revature.beans.User;
import com.revature.daos.UserDAO;

public class UserService {

	private UserDAO ud;
	
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public User saveUser(User user) {
		User u = null;
		return u;
	}
	
	public List<User> getUsers(){
		return ud.findAll();
	}
}