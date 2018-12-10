package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	private static final String filename = "connection.properties";
	
	@Override
	public void insertUser(int id, String firstName, String lastName) {	

		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO USER_BANK VALUES (?, ?, ?)";
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, id);
			p.setString(2, firstName);
			p.setString(3, lastName);
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
