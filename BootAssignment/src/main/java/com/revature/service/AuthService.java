package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.beans.Members;
import com.revature.repositories.MembersDAO;

public class AuthService {

	private MembersDAO ud;
	
	public void setMembersDAO(MembersDAO ud) {
		this.ud = ud;
	}
	
	public Members isValid(String username, String password) {
		
		Members user = ud.getUsersByUsername(username);
		if(user != null) {
			if(user.getPassword() == password) {
				return user;
			}
		}
		return null;
	}
}
