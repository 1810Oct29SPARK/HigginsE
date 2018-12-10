package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	    public List<User> getUsers();
	    public User getUserById(int id);
	    public void insertUser(int id, String lastName, String firstName );
}
