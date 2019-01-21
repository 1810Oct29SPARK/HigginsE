package com.revature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	public User getByUsername(String username);
	public void addUsers(User user);
	public List<User> findAll();

}