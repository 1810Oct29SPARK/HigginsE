package proj.one.beans;

public class Employee {
	
	public Employee(int employee_id, String firstName, String lastName, String email, String employeeUser,
			String employeePass, int directManagerId, int managerId) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
		this.directManagerId = directManagerId;
		this.managerId = managerId;
	}

	int employee_id;
	String firstName;
	String lastName;
	String email;
	String employeeUser;
	String employeePass;
	int directManagerId;
	int managerId;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployeeUser() {
		return employeeUser;
	}
	public void setEmployeeUser(String employeeUser) {
		this.employeeUser = employeeUser;
	}
	public String getEmployeePass() {
		return employeePass;
	}
	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", employeeUser=" + employeeUser + ", employeePass=" + employeePass
				+ ", directManagerId=" + directManagerId + ", managerId=" + managerId + "]";
	}
	public int getDirectManagerId() {
		return directManagerId;
	}
	public void setDirectManagerId(int directManagerId) {
		this.directManagerId = directManagerId;
	}

}
