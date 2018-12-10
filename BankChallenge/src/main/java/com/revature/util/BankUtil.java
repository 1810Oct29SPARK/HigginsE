package com.revature.util;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil {
	
	//include DAOs as instance variables 
	private AccountDAO ad;
	private UserDAO ud;

	public BankUtil(AccountDAO ad, UserDAO ud) {
		super();
		this.ad = ad;
		this.ud = ud;
	}

	public AccountDAO getAd() {
		return ad;
	}

	public UserDAO getUd() {
		return ud;
	}

	public List<Account> viewAccountsByUser(int userId) throws SQLException {
		return ad.getAccountsByUserId(userId);
	}
	
	public double withdrawMoney(int accountId, double amount) throws SQLException {
		return ad.withdraw(accountId, amount);
	}
	
	public double depositMoney(int accountId, double amount) throws SQLException {
		return ad.deposit(accountId, amount);
	}
	
}
