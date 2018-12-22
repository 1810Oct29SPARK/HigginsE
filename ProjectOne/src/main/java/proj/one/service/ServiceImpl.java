package proj.one.service;

import java.util.List;

import proj.one.beans.Employee;
import proj.one.beans.Request;
import proj.one.dao.ImperialDAO;
import proj.one.dao.ImperialDAOImpl;

public class ServiceImpl implements Service {

	private ImperialDAO dao = new ImperialDAOImpl();
	
	public ServiceImpl() {
		
	}
	
	@Override
	public List<Request> getOwnPendingById(int employeeId) {
		return dao.getOwnPendingById(employeeId);
	}

	@Override
	public List<Request> getOwnResolvedById(int employeeId) {
		return dao.getOwnResolvedById(employeeId);
	}

	@Override
	public List<Employee> getOwnInfoById(int employeeId) {
		return dao.getOwnInfoById(employeeId);
	}

	@Override
	public List<Request> getSubordinateRequestsById(int managerId) {
		return dao.getSubordinateRequestsById(managerId);
	}

	@Override
	public List<Request> getResolvedWithManagers() {
		return dao.getResolvedWithManagers();
	}

	@Override
	public List<Employee> getEmployeeWithManager() {
		return dao.getEmployeeWithManager();
	}

	@Override
	public Request getIndivSubordinateRequestsById(int employeeId) {
		return dao.getIndivSubordinateRequestsById(employeeId);
	}

}
