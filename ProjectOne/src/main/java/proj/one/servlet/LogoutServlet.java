package proj.one.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import proj.one.service.Service;
import proj.one.service.ServiceImpl;

public class LogoutServlet extends HttpServlet {
	private static final long SerialVersionUID = 1L;
	private ObjectMapper om;
	private Service service;
	
	public LogoutServlet() {
		service = new ServiceImpl();
		om = new ObjectMapper();
		//Then there are two other entries used in the BearServlet Example
		//However, they do not seem to apply to this case, so I will omit them for now...
	}
	
	//And here's where the action begins
	//First, to grab information grabbed by the DAOs from the DB
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Home.html").include(req, resp);
		if (session != null) {
			session.invalidate();
		}
		pw.println("<p>You are successfully logged out</p>");
		pw.println("</div>");
		pw.println("<a href=\"login\">back to login</a>");
		pw.println("</body></html>");
	}
		
	//Next, to post the information we just grabbed onto the site, so that the users can see it
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
		
	//Then, once I've completed the DAOs for updating information in the DB, I'll want something to update info
	protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
