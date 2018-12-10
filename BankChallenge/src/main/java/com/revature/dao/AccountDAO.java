package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	//define necessary CRUD methods and build an implementing class in this package
	
	public List<Account> getAccount();
	public Account getAccountByNumber(int acc_id);
	public double withdrawFunds(int user_id, int acc_id, double balance);
	public double depositFunds (int user_id, int acc_id, double balance);
	public Account CreateUserAccount(String uname);
	
}
