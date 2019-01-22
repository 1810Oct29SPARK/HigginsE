package com.swop.revature.fullstackchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swop.revature.fullstackchallenge.beans.User;
import com.swop.revature.fullstackchallenge.repositories.UserDAO;

@Service
public class UserService {
	
	private UserDAO ud;

	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}
	
	public User getUser(User user) {
		User u = null;
		u = ud.getOne(user.getId());
		return u;
	}
	
	public User getUserByName(String username) {
		User u = ud.getUserByName(username);
		return u;
	}
	

	public void createUser(User user) {
		ud.save(user);
	}
	

}