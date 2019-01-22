package com.swop.revature.fullstackchallenge.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swop.revature.fullstackchallenge.beans.User;


@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	
	public User getUserByName(String name);
	public User getUserByNameAndPassword(String name, String password);
	
}

