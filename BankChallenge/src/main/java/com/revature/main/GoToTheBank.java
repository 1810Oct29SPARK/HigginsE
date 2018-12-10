package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.CustomerDAO;
import com.revature.util.BankUtil;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
		//init();
		//implement BankUtil methods and demonstrate their use in this main method. 
		AccountDAO accDao = new BankUtil();
		CustomerDAO cusDao = new BankUtil();
		BankUtil bu = new BankUtil();
//		System.out.println(cusDao.getCustomerById(1));
		
		
//		System.out.println(accDao.getAccountById(11));
//		System.out.println(bu.getAccountById(11));
		
		System.out.println(bu.viewAccountsByUser(cusDao.getCustomerById(1)));
	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}