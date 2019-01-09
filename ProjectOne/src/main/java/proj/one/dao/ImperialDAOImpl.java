package proj.one.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proj.one.beans.Employee;
import proj.one.beans.Manager;
import proj.one.beans.Request;
import proj.one.util.ConnectionUtil;

public class ImperialDAOImpl implements ImperialDAO {

	private static final String filename = "connection.properties";
	
	public ImperialDAOImpl() {
		
	}
	//'twould seem that the following function is unnecessary
	//but I'm keeping a commented out version, just in case
	/*
	public List<Request> getOwnPending() {
		List<Request> ownPend = new ArrayList<Request>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT REQ_DETAILS WHERE EMPLOYEE_ID =  "
		}
		return null;
	}
	*/

	public List<Request> getOwnPendingById(int employeeId) {
		List<Request> pendList = new ArrayList<Request>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT DETAILS FROM REQUEST WHERE STATUS = PENDING";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String requestDetails = rs.getString("DETAILS");
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pendList;
	}

	public List<Request> getOwnResolvedById(int employeeId) {
		List<Request> resList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT DETAILS "
					+ "FROM REQUEST "
					+ "WHERE STATUS = APPROVED "
					+ "OR STATUS = DENIED";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String requestDetails = rs.getString("DETAILS");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resList;
	}

	/*
	public Request getOwnResolvedById() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	/*
	public List<Employee> getOwnInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	public List<Employee> getOwnInfoById(int employeeId) {
		List<Employee> viewInfo = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				String employeeUser = rs.getString("USERNAME");
				int ManagerId = rs.getInt("MANAGER");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return viewInfo;
	}

	/*
	public List<Request> getSubordinateRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	public List<Request> getSubordinateRequestsById(int managerId) {
		List<Request> subReqs = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT DETAILS FROM REQUEST R"
					+ "WHERE MANAGER = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, managerId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String requestDetails = rs.getString("DETAILS");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return subReqs;
	}

	public List<Request> getResolvedWithManagers() {
		List<Request> resWithMgrList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT REQUEST.DETAILS, MANAGER.FIRSTNAME, MANAGER.LASTNAME"
					+ "FROM MANAGER M FULL JOIN REQUEST R ON R.EMPLOYEE_ID = M.SUBORDINATE_ID"
					+ "WHERE REQUEST_STATUS = APPROVED OR REQUEST_STATUS = DENIED"
					+ "SELECT REQUEST.DETAILS, MANAGER.FIRSTNAME, MANAGER.LASTNAME,"
					+ "EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME"
					+ "FROM REQUSET R FULL JOIN EMPLOYEE E ON R.EMPLOYEE = EMPLOYEE.ID"
					+ "FULL JOIN MANAGER M ON R.MANAGER = MANAGER.ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String requestDetails = rs.getString("DETAILS");
				String managerFirst = rs.getString("MANAGER.FIRSTNAME");
				String managerLast = rs.getString("MANAGER.LASTNAME");
				String employeeFirst = rs.getString("EMPLOYEE.FIRSTNAME");
				String employeeLast = rs.getString("EMPLOYEE.LASTNAME");

			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resWithMgrList;
	}

	/*
	public Request getResolvedWithMagersById() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	public List<Employee> getEmployeeWithManager() {
		List<Employee> employeeManager = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, MANAGER.FIRSTNAME, MANAGER.LASTNAME"
					+ "FROM EMPLOYEE E FULL JOIN MANAGER M ON E.MANAGER = M.ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String firstname = rs.getString("EMPLOYEE.FIRSTNAME");
				String lastname = rs.getString("EMPLOYEE.LASTNAME");
				String managerFirst = rs.getString("MANAGER.FIRSTNAME");
				String managerLast = rs.getString("MANAGER.LASTNAME");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeManager;
	}

	/*
	public Manager getEmployeeWithManagerById() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	/*
	public List<Request> getIndivSubordinateRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

	public Request getIndivSubordinateRequestsById(int employeeId) {
		Request indivSubReqs = null;
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT DETAILS"
					+ "FROM REQUEST R FULL JOIN MANAGER M"
					+ "ON R.EMPLOYEE = M.EMPLOYEE"
					+ "WHERE R.EMPLOYEE = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String requestDetails = rs.getString("REQUEST_DETAILS");
			}  
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indivSubReqs;
	}

	

}
