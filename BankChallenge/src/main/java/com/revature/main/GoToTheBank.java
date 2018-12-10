package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
		UserDAO uDAO = new UserDAOImpl();
		System.out.println(uDAO.getAccounts(2));
//		UserDAO depDAO = new UserDAOImpl();
//		depDAO.withdrawalDeposit(101, 10.01);
	}
	// construct tables in an RDS to support these operations!
	// implement BankUtil methods and demonstrate their use in this main method.

}