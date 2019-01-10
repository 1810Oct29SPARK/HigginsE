package proj.one.servlet.v2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.one.beans.Employee;
import proj.one.beans.EmployeeUser;
import proj.one.service.v2.EmployeeAuthenticationService;

@WebServlet("/Login")
public class EmployeeLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeLogin() {
		super();
	}
	
	EmployeeAuthenticationService empAuthServ = new EmployeeAuthenticationService();
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("doGet is working");
		req.getRequestDispatcher("Employee.html").forward(req, resp);
	}
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Handling request...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		EmployeeUser user = new EmployeeUser(req.getParameter("employeeUser"), req.getParameter("employeePass"));
		Employee e = empAuthServ.isValidEmployee(user);
		if (e != null) {
			session.setAttribute("Employee Id", e.getEmployee_id());
			session.setAttribute("First Name", e.getFirstName());
			session.setAttribute("Last Name", e.getLastName());
			session.setAttribute("Email", e.getEmail());
			session.setAttribute("Username", e.getEmployeeUser());
			session.setAttribute("Manager", e.getManagerId());
			resp.sendRedirect("employeePage");
		} else {
			session.invalidate();
			resp.sendRedirect("Login");
		}
	}

}
