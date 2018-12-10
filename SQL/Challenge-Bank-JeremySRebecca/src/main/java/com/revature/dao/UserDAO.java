package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.BankUtil;

public interface UserDAO {
	
	//define necessary CRUD methods and build an implementing class in this package
	public void insertUser(int id, String first, String last) ;
	public void getUser(int id, String first, String last) ;

	public void deleteUser(String first);

	


}