package com.DOP.dayOffProj.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DOP.dayOffProj.beans.Credential;
import com.DOP.dayOffProj.beans.User;
import com.DOP.dayOffProj.repositories.UserDAO;

@Service
public class UserService {

	private UserDAO userDao;
	
	public UserService(UserDAO ud) {
		super();
		this.userDao = ud;
	}
	
	public User isValidUser(Credential credential) {
		User user = null;
		System.out.println(credential);
		user = authenticateUser(credential);
		return user;
	}
	
	public User authenticateUser(Credential credential) {
		
		List<User> list = null;
		User u = null;
		
		try {
			list = userDao.getByEmail(credential.getEmail());
			System.out.println(list);
			for(User u2 : list) {
				if(u2.getEmail().equals(credential.getEmail()) && u2.getPassword().equals(credential.getPassword())) {
					
					u = u2;
					return u;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Log-In Credentials");
		}
		return u;
	}
}
