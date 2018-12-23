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

public class SessionServlet extends HttpServlet {
	
	protected void doGetEmployee (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeUser") != null) {
			try {
				int employee_id = Integer.parseInt(session.getAttribute("employee_id").toString());
				String firstName = session.getAttribute("firstName").toString();
				String lastName = session.getAttribute("lastName").toString();
				String email = session.getAttribute("email").toString();
				String employeeUser = session.getAttribute("employeeUser").toString();
				String employeePass = session.getAttribute("employeePass").toString();
				int directManagerId = Integer.parseInt(session.getAttribute("directManagerId").toString());
				int managerId = Integer.parseInt(session.getAttribute("managerId").toString());
				Employee e = new Employee(employee_id, firstName, lastName, email, employeeUser, employeePass, directManagerId, managerId);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			} catch(Exception e) {
				e.printStackTrace();
				resp.getWriter().write("{\"session\":null}");
			}
		} else {
			resp.getWriter().write("{\"session\":null}");
		}
	}
	protected void doGetManager (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("managerUser") != null) {
			try {
				int managerId = Integer.parseInt(session.getAttribute("managerId").toString());
				String managerFirst = session.getAttribute("managerFirst").toString();
				String managerLast = session.getAttribute("managerLast").toString();
				String managerUser = session.getAttribute("managerUser").toString();
				String managerPass = session.getAttribute("managerPass").toString();
				Manager m = new Manager(managerId, managerFirst, managerLast, managerUser, managerPass);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(m));
			} catch(Exception e) {
				e.printStackTrace();
				resp.getWriter().write("{\"session\":null}");
			}
		} else {
			resp.getWriter().write("{\"session\":null}");
		}
	}

}
