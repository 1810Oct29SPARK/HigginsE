package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO{

	private static final String filename = "connection.properties";

	@Override
	public void insertAccount(int accountId, int userId, String userName, String accountName, double balance) {

		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO ACCOUNTS VALUES (?, ?, ?, ?, ?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, accountId);
			p.setInt(2, userId);
			p.setString(3, userName);
			p.setString(4, accountName);
			p.setDouble(5, balance);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
