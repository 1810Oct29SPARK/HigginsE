package com.revature.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.dao.AccountDAO;
import com.revature.dao.UserDAO;

public class BankUtil implements AccountDAO, UserDAO {

	// include DAOs as instance variables
	private AccountDAO ad;
	private UserDAO ud;

	public List<Account> viewAccountsByUser(int u) {
		try (Connection con = ConnectionUtil.getConnection()) {
			System.out.println(con);
			String sql = "SELECT A.ACCOUNT_ID, A.ACCOUNT_NUM, A.USER_ID, A.ACCOUNT_NAME, A.BALANCE " + "FROM ACCOUNT A "
					+ "INNER JOIN CUSTOMER "+"ON A.USER_ID=CUSTOMER.USER_ID ";
			
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Double withdrawMoney(Account account, double amount) {
		return 0.0;
	}

	public Double depositMoney(Account account, double amount) {
		return 0.0;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(int id, String lastName, String firstName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> getAccountss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(int id) {
		Account a = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			System.out.println(con);
			String sql = "SELECT A.ACCOUNT_ID, A.ACCOUNT_NUM, A.USER_ID, A.ACCOUNT_NAME, A.BALANCE " + "FROM ACCOUNT A "
					+ "WHERE A.ACCOUNT_ID = ? ";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				short accountNum = rs.getShort("ACCOUNT_NUM");
				int userId = rs.getInt("USER_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				double accountBalance = rs.getDouble("BALANCE");
				a = new Account(accountId, accountNum, userId, accountName, accountBalance);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(a.toString());
		return a;
	}

	@Override
	public void insertAccount(int id, short accountNumber, User user, String accountName, Double balance) {
		// TODO Auto-generated method stub

	}

}
