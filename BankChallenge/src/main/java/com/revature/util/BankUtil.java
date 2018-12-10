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

public class BankUtil {
	
	//include DAOs as instance variables 
	private AccountDAO ad;
	private UserDAO ud;
	
	private static final String filename = "connection.properties";

	public static List<Account> viewAccountsByUser(User u){
		List<Account> va = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT BALANCE, ACCOUNT_NAME" + 
					"FROM ACCOUNTS" + 
					"WHERE USER_NAME = '?'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String accountName = rs.getString("ACCOUNT_NAME");
				double balance = rs.getDouble("BALANCE");
				va.add(new Account(accountId, userId, userName, accountName, balance));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return va;
	}
	
	public Double withdrawMoney(Account account, double amount) {
		double newBalance = 0.0;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE ACCOUNTS SET BALANCE = BALANCE-?" + 
					"WHERE ACCOUNTS_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setDouble(2, amount);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				newBalance = rs.getDouble("BALANCE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newBalance;
	}
	
	public Double depositMoney(Account account, double amount) {
		double newBalance = 0.0;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE ACCOUNTS SET BALANCE = BALANCE+?" + 
					"WHERE ACCOUNTS_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setDouble(2, amount);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				newBalance = rs.getDouble("BALANCE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newBalance;
	}
	
	
}
