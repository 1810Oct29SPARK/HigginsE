package com.revature.main;

import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.util.BankUtil;

public class GoToTheBank {

	public static void main(String[] args) {
	
		//construct tables in an RDS to support these operations! 
		//implement BankUtil methods and demonstrate their use in this main method. 
		UserDAO ud = new UserDAOImpl();
		AccountDAO ad = new AccountDAOImpl();
		System.out.println(ud.getUserById(1));
		BankUtil util = new BankUtil();
		System.out.println(util.viewAccountsByUser(ud.getUserById(1)));
		System.out.println(ad.getAccountById(1));
		System.out.println(util.withdrawMoney(ad.getAccountById(1), 500));
		System.out.println(util.depositMoney(ad.getAccountById(1), 500));
	}
}