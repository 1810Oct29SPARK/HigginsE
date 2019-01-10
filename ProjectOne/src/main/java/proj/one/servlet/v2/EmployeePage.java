package proj.one.servlet.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.one.beans.EmployeeUser;

@WebServlet("/employeePage")
public class EmployeePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeePage() {
        super();
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("employee.html").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Handling Request...");
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		EmployeeUser user = new EmployeeUser(req.getParameter("employeeUser"), req.getParameter("employeePass"));
	}

}
