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

public class UserDAOImpl implements UserDAO {

	public static final String filename = "connection.properties";
	
	public List<Account> getAccounts(int USERID) {
		List<Account> al = new ArrayList<Account>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT A.ACCOUNTNAME, A.ACCOUNTNUMBER, A.BALANCE FROM ACCOUNTS A LEFT JOIN USERS U ON A.USERID = U.USERID WHERE U.USERID = 1";
			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, USERID);
			ResultSet rs = pstmt.executeQuery();
			//System.out.println(rs);
			
			if(rs.next()) {
				int accountNumber = rs.getInt("ACCOUNTNUMBER");
				String accountName = rs.getString("ACCOUNTNAME");
				double balance = rs.getDouble("BALANCE");
				System.out.println(balance);
				al.add(new Account(accountNumber, accountName, balance));
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(al);
		return al;
	}
	
	@Override
	public void withdrawalDeposit(int accountNumber, double ammount) {
//		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			String sql = "UPDATE ACCOUNTS A SET BALANCE = BALANCE + ? WHERE A.ACCOUNTNUMBER = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt(2, accountNumber);
//			pstmt.setDouble(1, ammount);
//			pstmt.executeUpdate();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT BALANCE FROM ACCOUNTS A WHERE A.ACCOUNTNUMBER = 101";
			Statement pstmt = con.createStatement();
//			sql.setInt(1, accountNumber);
			ResultSet currentBalance = pstmt.executeQuery(sql);
			while(currentBalance.next()) {
				double value = currentBalance.getDouble("BALANCE");
			System.out.println(value);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
