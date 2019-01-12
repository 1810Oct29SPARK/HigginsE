package proj.one.loginInfo;

import static org.junit.Assert.*;

import org.junit.Test;

import proj.one.beans.Employee;
import proj.one.beans.EmployeeUser;
import proj.one.dao.EmployeeDAO;
import proj.one.dao.EmployeeDAOImpl;
import proj.one.dao.EmployeeUserDAO;
import proj.one.dao.EmployeeUserDAOImpl;

public class EmployeeLoginInfoTest {

	@Test
	public void getsCorrectUsernameTest() {
		Employee e = new Employee(2003);
		String username = e.getEmployeeUser();
		assertEquals(e, username);
	}
	
	@Test
	public void getsEmployeeByIdTest() {
		EmployeeDAO eDao = new EmployeeDAOImpl();
		Employee e = eDao.getEmployeeById(2003);
		Employee me = new Employee(2003, "Sean", "Sulham", "ssulham@gmail.com", "ssulham", 4001);
		assertEquals(me, e);
	}
	
	@Test
	public void getsEmployeeUsernameAndPasswordTest() {
		EmployeeUserDAO userDAO = new EmployeeUserDAOImpl();
		EmployeeUser user = userDAO.getUsernameAndPassword("employeeUser", "employeePass");
		EmployeeUser me = new EmployeeUser("ssulham", "sulhams", 2003);
		assertEquals(me, user);
	}
	
	@Test
	public void getsParamTest() {
		Employee e = null;
		EmployeeUser user = new EmployeeUser("SSULHAM", "SEANS", 2003);
		String username = user.getEmployeeUser();
		
	}

}
