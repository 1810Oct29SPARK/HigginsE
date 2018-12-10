package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;

public interface AccountDAO {

	List<Account> getAccountsByUserId(int userId) throws SQLException;
	double getAccountBalanceById(int accountId) throws SQLException;
	int addAccount(Account account) throws SQLException;
	int updateAccount(int accountId, String accountName) throws SQLException;
	int deleteAccount(int accountId) throws SQLException;
	double deposit(int accountId, double amount) throws SQLException;
	double withdraw(int accountId, double amount) throws SQLException;
	
}
