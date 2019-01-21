package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Members;


@Repository
public interface MembersDAO extends JpaRepository<Members, Integer>{

	public Members getUsersByUsername(String username);
	public List<Members> findAll();
	public Members getById(int id);
	
}
