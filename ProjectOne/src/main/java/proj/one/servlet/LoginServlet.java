package proj.one.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import proj.one.beans.Employee;
import proj.one.beans.Manager;
import proj.one.beans.UserE;
import proj.one.beans.UserM;
import proj.one.service.AuthenticationService;
import proj.one.service.Service;
import proj.one.service.ServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private ObjectMapper om;
	private Service service;
	
	public LoginServlet() {
		service = new ServiceImpl();
		om = new ObjectMapper();
		//Then there are two other entries used in the BearServlet Example
		//However, they do not seem to apply to this case, so I will omit them for now...
	}
	
	AuthenticationService authServ = new AuthenticationService();
	
	//And here's where the action begins
	//First, to grab information grabbed by the DAOs from the DB
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("IMA_HomePage.html").forward(req, resp);
	}
		
	//Next, to post the information we just grabbed onto the site, so that the users can see it
	protected void doPostEmployeeLogin (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Handling request...Just a moment, please...Almost there...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		UserE ue = new UserE(req.getParameter("employeeUser"), req.getParameter("employeePass"));
		Employee e = authServ.isValidEmployee(ue);
		if (e != null) {
			session.setAttribute("employeeId", e.getEmployee_id());
			session.setAttribute("firstName", e.getFirstName());
			session.setAttribute("lastName", e.getLastName());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("employeeUser", e.getEmployeeUser());
			session.setAttribute("employeePass", e.getEmployeePass());
			session.setAttribute("problem", null);
			resp.sendRedirect("Employee Page");
		} else {
			session.setAttribute("problem", "invalid username or password");
			resp.sendRedirect("Imperial Martial Arts");
		}
	}
	protected void doPostManagerLogin (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Handling request...Just a moment, please...Almost there...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		UserM um = new UserM(req.getParameter("managerUser"), req.getParameter("managerPass"));
		Manager m = authServ.isValidManager(um);
		if (m != null) {
			session.setAttribute("managerId", m.getManagerId());
			session.setAttribute("managerFirst", m.getManagerFirst());
			session.setAttribute("managerLast", m.getManagerLast());
			session.setAttribute("managerUser", m.getManagerUser());
			session.setAttribute("managerPass", m.getManagerPass());
			session.setAttribute("problem", null);
			resp.sendRedirect("Manager Page");
		} else {
			session.setAttribute("problem", "invalid username or password");
			resp.sendRedirect("Imperial Martial Arts");
		}
	}
	
	
	
	//Then, once I've completed the DAOs for updating information in the DB, I'll want something to update info
	protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
