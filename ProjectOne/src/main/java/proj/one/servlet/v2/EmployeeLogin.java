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
		EmployeeUser user = new EmployeeUser(req.getParameter("username"), req.getParameter("password"));
		EmployeeUser e = empAuthServ.isValidEmployee(user);
		if (e != null) {
			session.setAttribute("Username", e.getEmployeeUser());
			session.setAttribute("Password", e.getEmployeePass());
			session.setAttribute("id", e.getEmployeeId());
			resp.sendRedirect("EmployeePage");
		} else {
			session.invalidate();
			resp.sendRedirect("InvalidLogin");
		}
	}

}
