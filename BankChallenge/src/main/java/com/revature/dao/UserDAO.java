package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;

public interface UserDAO {
	//we want to list out all accounts each user has
	public List<Account> getAccounts(int userid);
	//we want to create a new user
//	public void createUser();
	//define necessary CRUD methods and build an implementing class in this package
	public void withdrawalDeposit(int accountNumber, double ammount);
}
