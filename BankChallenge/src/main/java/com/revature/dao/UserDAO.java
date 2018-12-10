package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	public List<User> getUser();
    public User getUserById(int id);
}
