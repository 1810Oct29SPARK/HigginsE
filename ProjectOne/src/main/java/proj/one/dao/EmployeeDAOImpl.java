package proj.one.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proj.one.beans.Employee;
import proj.one.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> eList = new ArrayList<Employee>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int employeeId = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String username = rs.getString("USERNAME");
				int managerId = rs.getInt("MANAGER");
				eList.add(new Employee(employeeId, firstName, lastName, email, username, managerId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return eList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = new Employee(0, null, null, null, null, 0);
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int employeeId = rs.getInt("ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String username = rs.getString("USERNAME");
				int managerId = rs.getInt("MANAGER");
				employee = new Employee(employeeId, firstName, lastName, email, username, managerId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
