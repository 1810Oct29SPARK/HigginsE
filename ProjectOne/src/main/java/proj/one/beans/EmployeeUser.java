package proj.one.beans;

public class EmployeeUser {
	
	public EmployeeUser(String employeeUser, String employeePass, int employeeId) {
		super();
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
		this.employeeId = employeeId;
	}
	public EmployeeUser(String employeeUser, String employeePass) {
		super();
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
	}
	public EmployeeUser() {
		super();
	}
	
	String employeeUser;
	String employeePass;
	int employeeId;
	
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
		return "EmployeeUser [employeeUser=" + employeeUser + ", employeePass=" + employeePass + ", employeeId="
				+ employeeId + "]";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
