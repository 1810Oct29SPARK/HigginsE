package com.DOP.dayOffProj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DOP.dayOffProj.beans.User;
import com.DOP.dayOffProj.beans.UserRole;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	public List<User> getByUserRole(UserRole u);
	public List<User> getByEmail(String email);
}
