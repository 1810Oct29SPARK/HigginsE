package proj.one.dao;

import proj.one.beans.EmployeeUser;

public interface EmployeeUserDAOProxy {
	
	public EmployeeUser verifyUser(String username, String password);


}
