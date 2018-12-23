package proj.one.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import proj.one.service.Service;
import proj.one.service.ServiceImpl;

public class ManagerServlet extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private ObjectMapper om;
	private Service service;
	
	public ManagerServlet() {
		service = new ServiceImpl();
		om = new ObjectMapper();
		//Then there are two other entries used in the BearServlet Example
		//However, they do not seem to apply to this case, so I will omit them for now...
	}
	
	//And here's where the action begins
	//First, to grab information grabbed by the DAOs from the DB
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("managerUser") != null) {
			req.getRequestDispatcher("IMA_Manager_Page.html").forward(req, resp);
		} else {
			resp.sendRedirect("Imperial Martial Arts Home Page");
		}
	}
		
	//Next, to post the information we just grabbed onto the site, so that the users can see it
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
		
	//Then, once I've completed the DAOs for updating information in the DB, I'll want something to update info
	protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
	}

}
