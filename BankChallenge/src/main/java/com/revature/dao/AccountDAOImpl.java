package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.revature.util.ConnectionUtil;
import com.revature.beans.Account;
import com.revature.beans.User;

public class AccountDAOImpl implements AccountDAO {

	private static final String filename = "connection.properties";

	@Override
	public List<Account> getAccount(int userID) {
		List<Account> bl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {

			String sql = "SELECT ACCOUNT_ID, ACCOUNT_NAME, ACCOUNT_NUMBER, ACCOUNT_BALANCE, USER_ID, FIRSTNAME, LASTNAME \r\n"
					+ "FROM ACCOUNT \r\n" + "INNER JOIN USERS\r\n" + "    ON ACCOUNT.USER_ID = USERS.USER_ID\r\n" + "WHERE ACCOUNT.USER_ID = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,userID);
			 
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int accountId = rs.getInt("ACCOUNT_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				short accountNumber = rs.getShort("ACCOUNT_NUMBER");
				double accountBalance = rs.getDouble("ACCOUNT_BALANCE");
				int userId = rs.getInt("USER_ID");
				String userFirstName = rs.getString("FIRSTNAME");
				String userLastName = rs.getString("LASTNAME");
				bl.add(new Account(accountId, accountNumber, new User(userId, userFirstName, userLastName), accountName,
						accountBalance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(bl);
		return bl;
	}

	String sql = "SELECT ACCOUNT.ACCOUNT_NUMBER, ACCOUNT.USER_ID, ACCOUNT.ACCOUNT_NAME, ACCOUNT.ACCOUNT_BALANCE + FROM ACCOUNTS";

	@Override
	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
