package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil {
	
	//include DAOs as instance variables 
	private AccountDAO ad;
	private UserDAO ud;
	
	private static final String filename = "connection.properties";


	public Double withdrawMoney(Account account, double amount) { 
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			
			String sql = "UPDATE ACCOUNTINFO SET BALANCE = " + (account.getBalance() - amount) + " WHERE ACCOUNTID = " + account.getId();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return account.getBalance() +- amount;
	}
	
	public Double depositMoney(Account account, double amount) {
try (Connection con = ConnectionUtil.getConnection(filename)) {
			
			String sql = "UPDATE ACCOUNTINFO SET BALANCE = " + (account.getBalance() + amount) + " WHERE ACCOUNTID = " + account.getId();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return account.getBalance() + amount;
	}

	public List<Account> viewAccountsByUser(User u) {
		List<Account> al = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * " +
					"FROM ACCOUNTINFO " +
					"INNER JOIN BANKUSER " +
					"ON ACCOUNTINFO.USERID = " + u.getId() +" AND BANKUSER.USERID = " + u.getId();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNTID");
				long accountNumber = rs.getLong("ACCOUNTNUMBER");
				String accountName  = rs.getString("ACCOUNTNAME");
				double balance = rs.getDouble("BALANCE");
				int userId  = rs.getInt("USERID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				al.add(new Account(accountId, accountNumber, new User(userId, firstName, lastName), accountName, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	
}
