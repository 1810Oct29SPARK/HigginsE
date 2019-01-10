package proj.one.dao;

import java.util.List;

import proj.one.beans.EmployeeUser;

public interface EmployeeUserDAO {
	
	public EmployeeUser getUsernameAndPassword (String username, String password);
	
	public List<EmployeeUser> getLoginInfo();
	

}
