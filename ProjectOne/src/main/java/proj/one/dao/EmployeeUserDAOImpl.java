package proj.one.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proj.one.beans.EmployeeUser;
import proj.one.util.ConnectionUtil;

public class EmployeeUserDAOImpl implements EmployeeUserDAO {

	private static final String filename = "connection.properties";
	
	@Override
	public EmployeeUser getUsernameAndPassword(String username, String password) {
		EmployeeUser user = new EmployeeUser(null, null);
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEE_USERS WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String employeeUsername = rs.getString("USERNAME");
				String employeePassword = rs.getString("PASSWORD");
				user = new EmployeeUser(employeeUsername, employeePassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<EmployeeUser> getLoginInfo() {
		List<EmployeeUser> user = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEE_USERS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				int id = rs.getInt("ID");
				user.add(new EmployeeUser(username, password, id));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
