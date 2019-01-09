package proj.one.beans;

public class Request {
	
	public Request(int requestId, String requestDetails, Enum requestStatus, int employeeId, int managerId) {
		super();
		this.requestId = requestId;
		this.requestDetails = requestDetails;
		this.requestStatus = requestStatus;
		this.employeeId = employeeId;
		this.managerId = managerId;
	}
	
	
	int requestId;
	String requestDetails;
	Enum requestStatus;
	//I have forgotten how to make an enum...I will come back to this later
	//I want to set the possible values for reqStat to be PENDING, APPROVED, or DENIED
	int employeeId;
	int managerId;
	//??? receipt;
	
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}
	public Enum getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(Enum requestStatus) {
		this.requestStatus = requestStatus;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", requestDetails=" + requestDetails + ", requestStatus="
				+ requestStatus + ", employeeId=" + employeeId + ", managerId=" + managerId + "]";
	}
	
	//I will generate the getters and setters and such once I figure out what to do about reqStat and receipt

}
