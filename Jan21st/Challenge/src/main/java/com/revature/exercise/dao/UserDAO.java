package com.revature.exercise.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.exercise.database.User;
import com.revature.exercise.database.UserRole;

public interface UserDAO extends JpaRepository<User, Integer> {
	
//	What does the second Argument in the JpaRepository do?
	
	public List<User> getByUserRole(UserRole ur);
	public User getByName(String name);
//	public User addUser(User user);

}
