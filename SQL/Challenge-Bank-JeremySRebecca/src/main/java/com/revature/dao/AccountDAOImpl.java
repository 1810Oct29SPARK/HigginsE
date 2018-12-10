package com.revature.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.BankUtil;

public class AccountDAOImpl implements AccountDAO{

		@Override
		public void insertAccount(int id, int number, String user, String name, int balance, int userid) {
			// TODO Auto-generated method stub
			try (Connection con = BankUtil.getConnection("connection.properties")) {
				String sql = "INSERT INTO JSRACCOUNT VALUES (?,?,?,?,?,?)";
				PreparedStatement p = con.prepareStatement(sql);
				p.setInt(1, id);
				p.setInt(2, number);
				p.setString(3, user);
				p.setString(4, name);
				p.setInt(5, balance);
				p.setInt(6, userid);
				p.executeUpdate(); //if we are changing anything, use executeUpdate()
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		public void updateAccount(int id, int number, String user, String name, int balance) {
			// TODO Auto-generated method stub
			try (Connection con = BankUtil.getConnection("connection.properties")) {
				String sql = "UPDATE INTO JSRACCOUNT VALUES (?,?,?,?,?)";
				PreparedStatement p = con.prepareStatement(sql);
				p.setInt(1, id);
				p.setInt(2, number);
				p.setString(3, user);
				p.setString(4, name);
				p.setInt(5, balance);
				p.executeUpdate(); //if we are changing anything, use executeUpdate()
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		public void deleteAccount(int id, int number, String user, String name, int balance) {
			// TODO Auto-generated method stub
			try (Connection con = BankUtil.getConnection("connection.properties")) {
				String sql = "DELETE INTO JSRACCOUNT VALUES (?,?,?,?,?)";
				PreparedStatement p = con.prepareStatement(sql);
				p.setInt(1, id);
				p.setInt(2, number);
				p.setString(3, user);
				p.setString(4, name);
				p.setInt(5, balance);
				p.executeUpdate(); //if we are changing anything, use executeUpdate()
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void getAccount(int id, int number, String user, String name, int balance) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAccount(String first) {
			// TODO Auto-generated method stub
			
		}
	}


