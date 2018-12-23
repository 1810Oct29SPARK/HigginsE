package proj.one.beans;

public class UserM {
	
	public UserM(String managerUser, String managerPass) {
		super();
		this.managerUser = managerUser;
		this.managerPass = managerPass;
	}
	String managerUser;
	String managerPass;
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
		return "UserM [managerUser=" + managerUser + ", managerPass=" + managerPass + "]";
	}
	

}
