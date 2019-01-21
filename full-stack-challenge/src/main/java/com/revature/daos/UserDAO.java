package com.revature.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	public User getUserByLogin(String login);
	public void addUser(User user);
	public List<User> findAll();

}
