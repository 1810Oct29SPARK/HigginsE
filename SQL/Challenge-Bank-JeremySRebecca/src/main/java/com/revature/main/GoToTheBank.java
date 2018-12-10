package com.revature.main;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;

public class GoToTheBank {

	public static void main(String[] args) {
	
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method. 
		//UserDAO user = new UserDAOImpl();
		//user.insertUser(100, "Walter", "Disney");
		//user.insertUser(101, "Jeremy", "Shropshire");
		//user.insertUser(102, "Rebecca", "Ruiz");
		//user.deleteUser("Walter");
		//user.deleteUser("Rebecca");
		//user.deleteUser("Jeremy");
		
		AccountDAO account = new AccountDAOImpl();
		//account.insertAccount(200, 1234567, "Disney Corp", "Walter", 100);
		account.insertAccount(100, 123456789, "Pixar Animations", "Walter", 100, 100);
		
		
	}
}