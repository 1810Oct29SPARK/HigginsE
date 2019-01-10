package proj.one.beans;

public class ManagerUser {
	
	public ManagerUser(String managerUser, String managerPass, int managerId) {
		super();
		this.managerUser = managerUser;
		this.managerPass = managerPass;
		this.managerId = managerId;
	}
	public ManagerUser(String managerUser, String managerPass) {
		super();
		this.managerUser = managerUser;
		this.managerPass = managerPass;
	}
	String managerUser;
	String managerPass;
	int managerId;
	
	public String getManagerUser() {
		return managerUser;
	}
	public void setManagerUser(String managerUser) {
		this.managerUser = managerUser;
	}
	public String getManagerPass() {
		return managerPass;
	}
	public void setManagerPass(String managerPass) {
		this.managerPass = managerPass;
	}
	@Override
	public String toString() {
		return "ManagerUser [managerUser=" + managerUser + ", managerPass=" + managerPass + ", managerId=" + managerId
				+ "]";
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	

}
