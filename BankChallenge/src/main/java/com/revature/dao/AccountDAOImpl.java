package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;

public class AccountDAOImpl implements AccountDAO {
	
	private Connection conn;

	public AccountDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Account> getAccountsByUserId(int userId) throws SQLException {
		
		List<Account> accList = new ArrayList<>();
		
		String sqlStmt = "SELECT ACCOUNTID AS AID, ACCOUNTNUMBER AS ANUM, ACCOUNTNAME AS AN, BALANCE AS BAL, FIRSTNAME AS FN, LASTNAME AS LN\r\n" + 
				"FROM ACCOUNT A\r\n" + 
				"INNER JOIN BANKUSER B ON A.USERID = B.USERID \r\n" + 
				"WHERE A.USERID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		
		pstmt.setInt(1,userId); 
		
		ResultSet rs = pstmt.executeQuery(); 
		
		while(rs.next()) {
			User u = new User(userId, rs.getString("FN"), rs.getString("LN"));
			Account a = new Account(rs.getInt("AID"), rs.getShort("ANUM"),u, rs.getString("AN"), rs.getDouble("BAL"));
			
			accList.add(a);
		}

		return accList; 
	}

	@Override
	public int addAccount(Account account) throws SQLException {
		
		String sqlStmt = "INSERT INTO ACCOUNT\r\n" + 
				"VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(1, account.getId());
		pstmt.setShort(2, account.getAccountNumber());
		pstmt.setInt(3, account.getUser().getId());
		pstmt.setString(4, account.getAccountName());
		pstmt.setDouble(5, account.getBalance());
		
		return pstmt.executeUpdate();
		
	}

	@Override
	public int updateAccount(int accountId, String accountName) throws SQLException {
		
		String sqlStmt = "UPDATE ACCOUNT\r\n" + 
				"SET ACCOUNTNAME = ?\r\n" + 
				"WHERE ACCOUNTID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setString(1, accountName);
		pstmt.setInt(2, accountId);
		
		return pstmt.executeUpdate();
		
	}

	@Override
	public int deleteAccount(int accountId) throws SQLException {
		
		String sqlStmt = "DELETE FROM ACCOUNT\r\n" + 
				"WHERE ACCOUNTID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(1, accountId);
		
		return pstmt.executeUpdate();
		
	}

	@Override
	public double deposit(int accountId, double amount) throws SQLException {
		
		String sqlStmt = "UPDATE ACCOUNT\r\n" + 
				"SET BALANCE = ?\r\n" + 
				"WHERE ACCOUNTID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		
		if (amount > 0) {
			double newBal = this.getAccountBalanceById(accountId) + amount;
			pstmt.setDouble(1, newBal);
			pstmt.setInt(2, accountId);
			if (pstmt.executeUpdate() == 1) {
				return newBal;
			}
		}
		
		return -1.0;
		
	}

	@Override
	public double withdraw(int accountId, double amount) throws SQLException {
	
		String sqlStmt = "UPDATE ACCOUNT\r\n" + 
				"SET BALANCE = ?\r\n" + 
				"WHERE ACCOUNTID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		
		if (amount > 0) {
			double newBal = this.getAccountBalanceById(accountId) - amount;
			
			if (newBal>=0) {
				pstmt.setDouble(1, newBal);
				pstmt.setInt(2, accountId);
				if (pstmt.executeUpdate() == 1) {
					return newBal;
				}
			}
		}
		
		return -1.0;
		
	}

	@Override
	public double getAccountBalanceById(int accountId) throws SQLException {
		
		String sqlStmt = "SELECT BALANCE FROM ACCOUNT\r\n" + 
				"WHERE ACCOUNTID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(1, accountId);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			return rs.getDouble("BALANCE");
		}
		else {
			return 0.0;
		}
		
	}

}
