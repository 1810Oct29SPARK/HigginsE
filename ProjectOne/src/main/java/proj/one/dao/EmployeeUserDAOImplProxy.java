package proj.one.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import proj.one.beans.EmployeeUser;
import proj.one.util.ConnectionUtil;

public class EmployeeUserDAOImplProxy implements EmployeeUserDAOProxy {

	static {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");        
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
    }
	
	@Override
	public EmployeeUser verifyUser(String username, String password) {
		EmployeeUser user = new EmployeeUser(null, null);
		try (Connection con = ConnectionUtil.getConnection()){
			String sql1 = "SELECT * FROM EMPLOYEE_USERS WHERE USERNAME = " + username;
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, username);
			ResultSet rs1 = pstmt1.executeQuery();
			String sql2 = "SELECT * FROM EMPLOYEE_USERS WHERE PASSWORD = " + password;
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(2, password);
			ResultSet rs2 = pstmt2.executeQuery();
			while(rs1.next()) {
				String employeeUsername = rs1.getString("USERNAME");
				String employeePassword = rs1.getString("PASSWORD");
				user = new EmployeeUser(employeeUsername, employeePassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
	}

}
