package proj.one.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import proj.one.beans.EmployeeUser;
import proj.one.util.ConnectionUtil;

public interface EmployeeUserDAO {
	
	public EmployeeUser getUsernameAndPassword (String username, String password);
	
	public List<EmployeeUser> getLoginInfo();
	
	public EmployeeUser getEmployeeByUsername(String username);

}
