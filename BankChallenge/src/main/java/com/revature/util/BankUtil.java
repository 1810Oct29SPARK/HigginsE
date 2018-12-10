package com.revature.util;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil {
	
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
