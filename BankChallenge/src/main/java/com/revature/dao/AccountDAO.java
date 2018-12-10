package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public interface AccountDAO {

	public List<Account> viewAccountsByUser(User u);
	
	public Double withdrawMoney(Account account, double amount);
	public Double depositMoney(Account account, double amount);
	
}
