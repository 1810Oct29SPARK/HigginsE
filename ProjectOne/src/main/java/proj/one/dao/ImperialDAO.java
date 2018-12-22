package proj.one.dao;

import java.util.List;

import proj.one.beans.Employee;
import proj.one.beans.Manager;
import proj.one.beans.Request;

public interface ImperialDAO {
	
	//Define methods here
	//Methods for pulling data from DB
	//	submit reimbursement request, view their pending requests, view their resolved requests, 
	//	view their information, update their information
	//	Managers approve/deny pending reimbursement requests from their subordinates, view requests,
	//	view resolved requests from all employees as well as which managers approved them, view all 
	//	employees and their managers, view all reimbursement requests from a single employee that they manage
	//
	//
	//Just pulling
	//O  employees view their pending requests
	//O  employees view their resolved requests
	//O  employees view their information
	//o  managers view total reimbursement requests from their own employees
	//O  managers view resolved requests from all employees as well as which manager resolved them
	//O  managers view all employees and their managers
	//X  view all reimbursement requests from any single employee that they manage
	//
	
	
	//SELECT by the employee's own id
	//display results of all his/her own pending requests
	//public List<Request> getOwnPending();
	public List<Request> getOwnPendingById(int employeeId);
	
	//SELECT by the employee's own id
	//display results of all his/her own resolved requests
	public List<Request> getOwnResolvedById(int employeeId);
	//public Request getOwnResolvedById();
	
	//SELECT by the employee's own id
	//display results of all his/her own personal info
	//public List<Employee> getOwnInfo();
	public List<Employee> getOwnInfoById(int employeeId);
	
	//SELECT by request WHERE the manager id = his/her own
	//public List<Request> getSubordinateRequests();
	public List<Request> getSubordinateRequestsById(int managerId);
	
	//SELECT Managers WHERE the request is resolved
	public List<Request> getResolvedWithManagers();
	//public Request getResolvedWithMagersById();
	
	//SELECT * GROUP BY Managers
	public List<Employee> getEmployeeWithManager();
	//public Manager getEmployeeWithManagerById();
	
	//For this one I want to use the same table as I used in the getSubordinateRequests method
	// However, in this case I will want to SELECT the results in such a way that I will get 
	// only one employee and all of the reimbursement requests made by that one employee
	//		This will be handled in the DAOImpl Class
	//public List<Request> getIndivSubordinateRequests();
	public Request getIndivSubordinateRequestsById(int employeeId);
	
	//Updating
	//  employees update their information
	//  managers approve/deny pending requests from their subordinates
	//
	
	
	//Uploading images
	//  employees can upload images of their receipts along with the reimbursement requests
	//  managers can view the uploaded images of receipts from the employees they manage
	//...
	//It would seem that we need to harness the power of BLOB for this.
	
	//Other stuff
	//  employees can login to their page
	//  employees can view their page
	//  employees can logout of their page
	//  managers can login to their page
	//  managers can view the manager page as well as the employee page
	//  managers can logout of their page
	//...
	//It would seem that these things ought to be handled not by the DAO but by the servlets
	//So as far as this class is concerned, only the pulling and updating portions are necessary

}
