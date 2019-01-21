package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Users;
import com.revature.repositories.UsersDAO;

@Service
public class UsersService {

	private UsersDAO ud;
	
	public void setUsersDAO(UsersDAO ud) {
		this.ud = ud;
	}
	
	public Users saveUsers(Users users) {
		Users u = null;
		return u;
	}
	
	public List<Users> getUsers(){
		return ud.findAll();
	}
	
}
