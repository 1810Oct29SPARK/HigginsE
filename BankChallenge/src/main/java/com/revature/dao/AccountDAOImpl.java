package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			
			String sql = "SELECT * FROM ACCOUNTINFO INNER JOIN BANKUSER ON ACCOUNTID = 1 AND BANKUSER.USERID = ACCOUNTINFO.USERID";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int userId = rs.getInt("USERID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				long accountNum = rs.getLong("ACCOUNTNUMBER");
				String accountName = rs.getString("ACCOUNTNAME");
				double balance = rs.getDouble("BALANCE");
				
				account = new Account(userId, accountNum, new User(userId, firstName, lastName), accountName, balance);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return account;
	}

}
