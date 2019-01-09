package proj.one.servlet.v2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.one.beans.v2.Employee;
import proj.one.beans.v2.EmployeeUser;
import proj.one.service.v2.EmployeeAuthenticationService;

//@WebServlet("/EmployeeLogin");
public class EmployeeLogin extends HttpServlet {
	
	EmployeeAuthenticationService empAuthServ = new EmployeeAuthenticationService();
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("Home.html").forward(req, resp);
	}
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Handling request...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		EmployeeUser user = new EmployeeUser(req.getParameter("username"), req.getParameter("password"));
		Employee e = empAuthServ.isValidEmployee(user);
		if (e != null) {
			session.setAttribute("Employee Id", e.getId());
			session.setAttribute("First Name", e.getFirstname());
			session.setAttribute("Last Name", e.getLastname());
			session.setAttribute("Email", e.getEmail());
			session.setAttribute("Username", e.getUsername());
			session.setAttribute("Manager", e.getManager());
			session.setAttribute("Problem", null);
			resp.sendRedirect("Employee");
		} else {
			session.setAttribute("Problem", "Invalid Username/Password");
			resp.sendRedirect("Home");
		}
	}

}
