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
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{
	
	private static final String filename = "connection.properties";

	@Override
	public User getUserById(int id) {
		User user = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			
			String sql = "SELECT * FROM BANKUSER WHERE USERID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int userId = rs.getInt("USERID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				user = new User(userId, firstName, lastName);
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
