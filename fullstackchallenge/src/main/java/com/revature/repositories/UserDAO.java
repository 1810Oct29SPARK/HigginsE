package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Users;


@Repository
public interface UserDAO extends JpaRepository<Users, Integer>{

	public Users getUsersByUsername(String username);
	public void addUsers(Users user);
	public List<Users> findAll();
	
}