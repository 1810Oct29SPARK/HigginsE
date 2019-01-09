package proj.one.beans;

public class EmployeeUser {
	
	public EmployeeUser(String employeeUser, String employeePass) {
		super();
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
	}
	String employeeUser;
	String employeePass;
	
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
	@Override
	public String toString() {
		return "UserE [employeeUser=" + employeeUser + ", employeePass=" + employeePass + "]";
	}

}
