package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
//import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.util.BankUtil;
import com.revature.util.ConnectionUtil;

public class GoToTheBank {

	public static void main(String[] args) {
	
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method.
		Connection conn = null;
		try {
			conn = ConnectionUtil.getConnection("connection.properties");
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		UserDAO ud = new UserDAOImpl(conn);
		AccountDAO ad = new AccountDAOImpl(conn);
		BankUtil bu = new BankUtil(ad, ud);
		
		// BankUtil testing cases
		try {
			
			List<Account> accountList = bu.viewAccountsByUser(2);
			for (Account a: accountList) {
				System.out.println(a);
			}
			
//			double newBal = bu.depositMoney(1, -500.0);
//			double newBal = bu.withdrawMoney(1, 500.0);
//			if (newBal != -1.0) {
//				System.out.println("your new balance: " + newBal);
//			}
//			else {
//				System.out.println("transaction failed");
//			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		// Testing individual dao implementations
		
//		User user1 = new User(1, "Eddy", "Soma");
//		User user2 = new User(2, "Danny", "Trevino");
//		User user3 = new User(3, "Dummy", "Demo");
		
//		Account acc1 = new Account(6, (short)1006, new User(1), "esa3", 1500.0);
//		Account acc2 = new Account(7, (short)1007, new User(2), "dta2", 1500.0);
//		Account acc3 = new Account(8, (short)1008, new User(2), "dta4", 2500.0);
		
//		try {
//			System.out.println(ud.addUser(user3) + " rows inserted");
//			System.out.println(ud.getUserById(2));
//			System.out.println(ud.updateUser(3, "Demo", "Dummy") + " rows updated");
//			System.out.println(ud.deleteUser(3) + " rows deleted");
//			
//			List<User> userList = ud.getAllUsers();
//			for (User u: userList) {
//				System.out.println(u);
//			}
//			
//			System.out.println(ad.addAccount(acc3) + " account added");
//			System.out.println(ad.updateAccount(4, "dta3") + " account updated");
//			System.out.println(ad.deleteAccount(5) + " account deleted");
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}

	}
	
}
