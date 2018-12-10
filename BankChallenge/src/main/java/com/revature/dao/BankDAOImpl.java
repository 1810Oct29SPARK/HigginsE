package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class BankDAOImpl implements AccountDAO, UserDAO {

	private static final String filename = "connection.properties";

	public BankDAOImpl() {

	}

	public List<User> getUser() {
		List<User> u1 = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {

			String sql = "SELECT * FROM USERS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("USER_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				u1.add(new User(id, firstname, lastname));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u1;
	}

	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		User u = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int userid = rs.getInt("USER_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				u = new User(userid, firstname, lastname);
				System.out.println(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return u;

	}

	public List<Account> getAccount() {
		List<Account> a1 = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {

			String sql = "SELECT * FROM ACCOUNT";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ACCOUNT_ID");
				short accountNumber = rs.getShort("ACCOUNT_NUMBER");
				int userid = rs.getInt("USER_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				double balance = rs.getInt("BALANCE");
				a1.add(new Account(id, accountNumber, userid, accountName, balance));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a1;
	}

	public Account getAccountByID(int id) {
		Account a = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM ACCOUNT WHERE ? = USER_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int accountid = rs.getInt("ACCOUNT_ID");
				short accountNumber = rs.getShort("ACCOUNT_NUMBER");
				int userid = rs.getInt("USER_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				double balance = rs.getInt("BALANCE");
				a = new Account(accountid, accountNumber, userid, accountName, balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public double deposit(int user, double amount) {
		double amtDep = 0;
		CallableStatement cs = null;
		
		try (Connection con = ConnectionUtil.getConnection(filename)){
            String sql = "SELECT BALANCE FROM ACCOUNT WHERE USER_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);        
            pstmt.setInt(1, user);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				double balance = rs.getInt("BALANCE");
				balance += amount;
				String q2 = "UPDATE ACCOUNT SET BALANCE = ? WHERE USER_ID = ?";
				PreparedStatement pstmt2 = con.prepareStatement(sql);        
	            pstmt2.setDouble(1, balance);
	            pstmt2.setInt(2, user);
	            int x = pstmt2.executeUpdate(q2);
        }} catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amtDep;
	}

	public double withdraw(int user, double amount) {
		double amtWith = 0;
		CallableStatement cs = null;
		
		try (Connection con = ConnectionUtil.getConnection(filename)){
            String sql = "SELECT BALANCE FROM ACCOUNT WHERE USER_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);        
            pstmt.setInt(1, user);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
				double balance = rs.getInt("BALANCE");
				balance -= amount;
				String q2 = "UPDATE ACCOUNT SET BALANCE = ? WHERE USER_ID = ?";
				PreparedStatement pstmt2 = con.prepareStatement(sql);        
	            pstmt2.setDouble(1, balance);
	            int x = pstmt2.executeUpdate(q2);
        }} catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amtWith;
	}
	
	

}
