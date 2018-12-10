package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	//define necessary CRUD methods and build an implementing class in this package
	List<User> getAllUsers() throws SQLException;
	User getUserById(int userId) throws SQLException;
	int addUser(User user) throws SQLException;
	int updateUser(int userId, String firstName, String lastName) throws SQLException;
	int deleteUser(int userId) throws SQLException;

}
