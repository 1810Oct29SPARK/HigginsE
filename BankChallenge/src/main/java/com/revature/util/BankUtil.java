package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil implements AccountDAO, UserDAO {
	
	//include DAOs as instance variables 
	private AccountDAO ad;
	private UserDAO ud;
	private static final String filename = "connection.properties";

	public List<Account> viewAccountsByUser(User u){
		List<Account> thisAccount = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "SELECT * FROM BANK_ACCOUNTS " + 
					"INNER JOIN BANK_USER ON BANK_USER.USER_ID = BANK_ACCOUNTS.USER_ID " + 
					"WHERE BANK_USER.USER_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, u.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				short accountNum = rs.getShort("ACCOUNT_NUM");
				String accountName = rs.getString("ACCOUNT_NAME");
				int userId = rs.getInt("USER_ID");
				double balance = rs.getDouble("BALANCE");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				thisAccount.add(new Account(accountId, accountNum, new User(userId, firstName, lastName), accountName, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return thisAccount;
	}
	
	public Double withdrawMoney(Account account, double amount) {
		double balance = account.getBalance() - amount;
		account.setBalance(balance);
		
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "UPDATE BANK_ACCOUNTS " + 
			"SET BALANCE = ? " +
			"WHERE ACCOUNT_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getId());
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return balance;
	}
	
	public Double depositMoney(Account account, double amount) {
		double balance = account.getBalance() + amount;
		account.setBalance(balance);
		
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "UPDATE BANK_ACCOUNTS " + 
			"SET BALANCE = ? " +
			"WHERE ACCOUNT_ID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getId());
			stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return balance;
	}
	
	
}
