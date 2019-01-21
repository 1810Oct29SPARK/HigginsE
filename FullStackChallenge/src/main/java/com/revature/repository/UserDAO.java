package com.revature.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	public User getUserByUsername(String username);
	public User getUserByUsernameAndPassword(String username, String password);

}