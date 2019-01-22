package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	
	public User getUserByUsername(User user);
//	public void addUser(User user);
	

}
