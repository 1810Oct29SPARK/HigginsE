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
import com.revature.beans.Customer;
import com.revature.dao.AccountDAO;
import com.revature.dao.CustomerDAO;

public class BankUtil implements AccountDAO, CustomerDAO {

	private static final String filename = "connection.properties";
	
	public List<Account> viewAccountsByUser(Customer u){
		List<Account> c1 = new ArrayList<>();
		// try-with-resources.. con will be closed at the end of the block
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			// write a join which unifies Bear, Cave, and BearType into a ResultSet
			// map the ResultSet's entries onto a list of Bear objects
			String sql = "SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, A.ACCOUNTID, A.ACCNUMBER, A.ACCNAME, A.BALANCE " + 
					"FROM CUSTOMER C " + 
					"INNER JOIN ACCOUNT A " + 
					"ON C.CUSTOMERID = A.CUSTOMERID";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int accId = rs.getInt("ACCOUNTID");
				short accNum = rs.getShort("ACCNUMBER");
				String accName = rs.getString("ACCNAME");
				double balance = rs.getDouble("BALANCE");
				int cusId = rs.getInt("CUSTOMERID");
				String cusFirstName = rs.getString("FIRSTNAME");
				String cusLastName = rs.getString("LASTNAME");
				c1.add(new Account(accId, accNum, new Customer(cusId, cusFirstName, cusLastName), accName, balance));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c1;
	}
	
	public Double withdrawMoney(Account account, double amount) {
		
		return 0.0;
	}
	
	public Double depositMoney(Account account, double amount) {
		return 0.0;
	}

	@Override
	public Account getAccountById(int id) {
		Account a = null;
		
		try(Connection con = ConnectionUtil.getConnection(filename)){
		
			String sql = "SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, A.ACCOUNTID, A.ACCNUMBER, A.ACCNAME, A.BALANCE\r\n" + 
					"FROM CUSTOMER C\r\n" + 
					"inner JOIN ACCOUNT A\r\n" + 
					"ON C.CUSTOMERID = A.CUSTOMERID " +
					"WHERE ACCOUNTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int accId = rs.getInt("ACCOUNTID");
//				short accNum = rs.getShort("ACCNUMBER");
				String accName = rs.getString("ACCNAME");
				double balance = rs.getDouble("BALANCE");
				int cusId = rs.getInt("CUSTOMERID");
				String cusFirstName = rs.getString("FIRSTNAME");
				String cusLastName = rs.getString("LASTNAME");
				a = new Account(accId, (short)10011, new Customer(cusId, cusFirstName, cusLastName), accName, balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer u = null;
		try(Connection con = ConnectionUtil.getConnection(filename)){
			
			String sql = "SELECT * FROM CUSTOMER " +
					"WHERE CUSTOMERID = ? " +
					"ORDER BY CUSTOMERID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int cusId = rs.getInt("CUSTOMERID");
				String cusFirstName = rs.getString("FIRSTNAME");
				String cusLastName = rs.getString("LASTNAME");
				u = new Customer(cusId, cusFirstName, cusLastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;
	}

//	@Override
//	public List<Customer> getCustomer(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Account> getAccount() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Account getAccount(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

//	@Override
//	public double feedBear(int bearId, int hiveId, double amt) {
//		double amtFed = 0;
//		CallableStatement cs = null;
//		
//		try(Connection con = ConnectionUtil.getConnection(filename)){
//			
//			String sql = "{call SP_FEED_BEAR(?,?,?,?)}";
//			cs = con.prepareCall(sql);
//			cs.setInt(1, bearId);
//			cs.setInt(2, hiveId);
//			cs.setDouble(3, amt);
//			cs.registerOutParameter(4,java.sql.Types.DECIMAL);
//			cs.execute();
//			amtFed = cs.getDouble(4);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return amtFed;
//	}

	
}
