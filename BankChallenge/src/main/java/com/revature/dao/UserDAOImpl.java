package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		
		List<User> userList = new ArrayList<>();
		
		String sqlStmt = "SELECT * FROM BANKUSER";
		
		Statement stmt = this.conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sqlStmt);
		
		while (rs.next()) {
			userList.add(new User(rs.getInt("USERID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME")));
		}
		
		return userList;
		
	}

	@Override
	public User getUserById(int userId) throws SQLException {
		
		User user = null;
		
		String sqlStmt = "SELECT *\r\n" + 
				"FROM BANKUSER\r\n" + 
				"WHERE USERID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery(); 
		
		if (rs.next()) {
			String firstName = rs.getString("FIRSTNAME");
			String lastName = rs.getString("LASTNAME");
			user = new User(userId, firstName, lastName);
		}
		
		return user;
		
	}

	@Override
	public int addUser(User user) throws SQLException {
		
		String sqlStmt = "INSERT INTO BANKUSER\r\n" + 
				"VALUES (?, ?, ?)";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(1, user.getId());
		pstmt.setString(2, user.getFirstName());
		pstmt.setString(3, user.getLastName());
		
		return pstmt.executeUpdate();
		
	}

	@Override
	public int updateUser(int userId, String firstName, String lastName) throws SQLException {
		
		String sqlStmt = "UPDATE BANKUSER\r\n" + 
				"SET FIRSTNAME = ?, LASTNAME = ?\r\n" + 
				"WHERE USERID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(3, userId);
		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		
		return pstmt.executeUpdate();
		
	}

	@Override
	public int deleteUser(int userId) throws SQLException {
		
		String sqlStmt = "DELETE FROM BANKUSER\r\n" + 
				"WHERE USERID = ?";
		
		PreparedStatement pstmt = this.conn.prepareStatement(sqlStmt);
		pstmt.setInt(1, userId);
		
		return pstmt.executeUpdate();
		
	}

}
