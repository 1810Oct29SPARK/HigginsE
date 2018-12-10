package com.revature.dao;

import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	//define necessary CRUD methods and build an implementing class in this package
	public void insertAccount(int accountId, int userId, String userName, String accountName, double balance);
}
