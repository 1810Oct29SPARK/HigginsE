package com.revature.dao;

import java.util.List;
import com.revature.beans.Account;

public interface AccountDAO {

	//define necessary CRUD methods and build an implementing class in this package
	public List<Account> getAccount();
	public Account getAccountByID(int id);
	public double deposit(int user, double amount);
	public double withdraw(int user, double amount);
	
}
