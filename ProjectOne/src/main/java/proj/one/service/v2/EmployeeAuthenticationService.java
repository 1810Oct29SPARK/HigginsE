package proj.one.service.v2;

import proj.one.beans.Employee;
import proj.one.beans.EmployeeUser;
import proj.one.dao.EmployeeDAO;
import proj.one.dao.EmployeeDAOImpl;
import proj.one.dao.EmployeeUserDAO;
import proj.one.dao.EmployeeUserDAOImpl;

public class EmployeeAuthenticationService {
	
	EmployeeUserDAO udao = new EmployeeUserDAOImpl();
	EmployeeDAO edao = new EmployeeDAOImpl();
	
	public EmployeeAuthenticationService() {
		
	}
	
	public Employee isValidEmployee(EmployeeUser user) {
		Employee e = null;
		EmployeeUser u = null;
		String username = user.getEmployeeUser();
		String password = user.getEmployeePass();
		u = udao.getUsernameAndPassword(username, password);
		int id = e.getEmployee_id();
		if (username != null && password != null) {
			if (username.equals(u.getEmployeeUser()) && password.equals(u.getEmployeePass())) {
				e = edao.getEmployeeById(id);
			}
		}
		return e;
	}

}
