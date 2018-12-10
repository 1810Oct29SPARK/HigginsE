package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	//define necessary CRUD methods and build an implementing class in this package
	public void insertUser(int id, String firstName, String lastName);

}
