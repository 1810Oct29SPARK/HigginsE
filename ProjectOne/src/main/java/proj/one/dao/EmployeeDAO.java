package proj.one.dao;

import java.util.List;

import proj.one.beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(int employeeId);

}
