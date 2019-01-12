package proj.one.service.v2;

import proj.one.beans.Employee;
import proj.one.beans.EmployeeUser;
import proj.one.dao.EmployeeDAO;
import proj.one.dao.EmployeeDAOImpl;
import proj.one.dao.EmployeeUserDAO;
import proj.one.dao.EmployeeUserDAOImpl;
import proj.one.dao.EmployeeUserDAOImplProxy;
import proj.one.dao.EmployeeUserDAOProxy;

public class EmployeeAuthenticationService {
	
	EmployeeUserDAO udao = new EmployeeUserDAOImpl();
	EmployeeDAO edao = new EmployeeDAOImpl();
	EmployeeUserDAOProxy proxy = new EmployeeUserDAOImplProxy();
	
	public EmployeeAuthenticationService() {
		
	}
	
	public EmployeeUser isValidEmployee(EmployeeUser user) {
		Employee e = null;
		EmployeeUser u = null;
		String username = user.getEmployeeUser();
		String password = user.getEmployeePass();
		u = udao.getUsernameAndPassword(username, password);
		if (username != null && password != null) {
			if (username.equals(u.getEmployeeUser()) && password.equals(u.getEmployeePass())) {
				u = udao.getEmployeeByUsername(username);
			}
		}
		return u;
	}
	
	public EmployeeUser employeeVerification(String username, String password) {
		Employee e = null;
		EmployeeUser user = null;
		user = proxy.verifyUser(username, password);
		if (username != null && password != null) {
			if(username.equals(user.getEmployeeUser()) && password.equals(user.getEmployeePass())) {
				user = new EmployeeUser(username, password);
			}
		}
		return user;
	}

}
