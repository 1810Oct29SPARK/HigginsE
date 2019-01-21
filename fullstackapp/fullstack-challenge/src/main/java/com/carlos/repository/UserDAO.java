package com.carlos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	

	
	
}
