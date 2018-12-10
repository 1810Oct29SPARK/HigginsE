package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil {
	
	public static Connection getConnection(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//include DAOs as instance variables 
	private AccountDAO ad;
	private UserDAO ud;

	public List<Account> viewAccountsByUser(User u){
		return null;
	}
	
	public Double withdrawMoney(Account account, double amount) {
		return 0.0;
	}
	
	public Double depositMoney(Account account, double amount) {
		return 0.0;
	}
	
	
}