package com.revature.challenge.FullStackChallenge.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.challenge.FullStackChallenge.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	public User getUserByUsername(String username);


}
