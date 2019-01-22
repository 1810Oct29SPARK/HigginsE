package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Users;
import com.revature.repository.UsersDAO;

public class UsersService {
	
	private UsersDAO ud;

	@Autowired
	public void setUserDAO(UsersDAO ud) {
		this.ud = ud;
	}
	
	public Users getUser(Users user) {
		Users u = null;
		u = ud.getOne(user.getId());
		return u;
	}
	
	public Users getUserByUsername(String username) {
		Users u = ud.getUserByUsername(username);
		return u;
	}
	
	public void createUser(Users user) {
		ud.save(user);
	}

}
