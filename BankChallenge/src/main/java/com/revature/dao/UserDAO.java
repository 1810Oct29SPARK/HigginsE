package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	//define necessary CRUD methods and build an implementing class in this package
	public List<User> getUserInfo();
	public User getUserbyId(int user_id);
	
}
