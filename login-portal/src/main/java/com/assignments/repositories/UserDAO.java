package com.assignments.repositories;

import org.springframework.stereotype.Repository;

import com.assignment.beans.Role;
import com.assignment.beans.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDAO extends JpaRepository<Role, Integer>{

	
	public List<User> getByRole(Role r);
}
