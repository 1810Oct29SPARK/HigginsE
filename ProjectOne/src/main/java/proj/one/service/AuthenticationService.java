package proj.one.service;

import proj.one.beans.Employee;
import proj.one.beans.Manager;
import proj.one.beans.UserE;
import proj.one.beans.UserM;

public class AuthenticationService {
	
	public AuthenticationService() {
		
	}
	
	public Employee isValidEmployee(UserE ue) {
		Employee e = null;
		String username = Employee.getEmployeeUser();
		String password = Employee.getEmployeePass();
		return e;
	}
	
	public Manager isValidManager(UserM um) {
		Manager m = null;
		String username = Manager.getManagerUser();
		String password = Manager.getManagerPass();
		return m;
	}

}
