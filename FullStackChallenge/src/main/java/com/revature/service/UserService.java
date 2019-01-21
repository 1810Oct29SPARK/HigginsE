package com.revature.service;

import com.revature.beans.User;
import com.revature.repository.UserDAO;

public class UserService {
	
	private UserDAO ud;

	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public User getUser(User user) {
		User u = null;
		u = ud.getOne(user.getId());
		return u;
	}
	
	public User getUserByUsername(String username) {
		User u = ud.getUserByUsername(username);
		return u;
	}
	
	public void createUser(User user) {
		ud.save(user);
	}
}