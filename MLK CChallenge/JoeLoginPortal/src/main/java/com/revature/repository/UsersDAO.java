package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {
	
	public Users getUserByUsername(String username);
	public Users getUserByUsernameAndPassword(String username, String password);

}
