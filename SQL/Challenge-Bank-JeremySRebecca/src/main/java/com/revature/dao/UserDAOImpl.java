package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.BankUtil;

public class UserDAOImpl implements UserDAO{

	@Override
	public void insertUser(int id, String first, String last) {
		// TODO Auto-generated method stub
		try (Connection con = BankUtil.getConnection("connection.properties")) {
			String sql = "INSERT INTO JSRUSER VALUES (?,?,?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			p.setString(2, first);
			p.setString(3, last);
			p.executeUpdate(); //if we are changing anything, use executeUpdate()
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void getUser(int id, String first, String last) {
		// TODO Auto-generated method stub
		try (Connection con = BankUtil.getConnection("connection.properties")) {
			String sql = "Select * from JSRUSER";
			PreparedStatement p = con.prepareStatement(sql);
			p.executeQuery(); //if we are changing anything, use executeUpdate()
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(String first) {
		// TODO Auto-generated method stub
		try (Connection con = BankUtil.getConnection("connection.properties")) {
			String sql = "Delete from JSRUSER where firstname = ?";
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, first);
			p.executeUpdate(); //if we are changing anything, use executeUpdate()
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
