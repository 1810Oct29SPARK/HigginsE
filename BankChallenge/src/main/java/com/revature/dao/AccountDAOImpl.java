package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {
	public static final String filename = "connections.properties";

	@Override
	public List<Account> getAccount() {
		List<Account> al = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE, USER_ID" +
				"FROM ACCOUNT" +
					"INNER JOIN USERID" +
				"ON USER_ID" ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Account getAccountByNumber(int acc_id) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT ACCOUNT_NUMBER " +  
		"FROM ACCOUNTS " + "WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, acc_id);
			ResultSet rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				int accountNumber = rs.getInt("ACCOUNT_NUMBER");
				System.out.println(accountNumber);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double withdrawFunds(int user_id, int acc_id, double balance) {
		
		return 0;
	}

	@Override
	public double depositFunds(int user_id, int acc_id, double balance) {
		String query = "SELECT * FROM ACCOUNT";
		Connection con;
		try {
		con = ConnectionUtil.getConnection(filename);
		Statement stmt;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		PreparedStatement depfunds;
	
			depfunds = con.prepareStatement("insert into account values(?,?,?)");
		  
		
		depfunds.setInt(1, acc_id);
		depfunds.setDouble(2, balance);
		depfunds.setInt(3, user_id);
		depfunds.executeUpdate();
		} finally {
		return 0.0;
		}
	}

	@Override
	public Account CreateUserAccount(String uname) {
		System.out.println("not yet");
		Account a=null;
		return a;
		}
		
		
	
	
}

	
	

