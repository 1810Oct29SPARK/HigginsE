package com.revature.service;

import java.util.List;

import com.revature.beans.Users;
import com.revature.repositories.UserDAO;

public class UserService {

	private UserDAO ud;
	
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public Users saveUser(Users user) {
		Users u = null;
		return u;
	}
	
	public List<Users> getUsers(){
		return ud.findAll();
	}
}
