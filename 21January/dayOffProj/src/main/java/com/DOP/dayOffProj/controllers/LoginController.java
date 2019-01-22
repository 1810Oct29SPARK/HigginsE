package com.DOP.dayOffProj.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DOP.dayOffProj.beans.Credential;
import com.DOP.dayOffProj.beans.User;
import com.DOP.dayOffProj.services.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	/*
	 * This method is a constructor that makes a call to the Super class, and it
	 * establishes the authService for the controller.
	 */
	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;

	}

	/*
	 * Instantiates an authService variable that will be used in the methods.
	 */
	private UserService userService;

	/*
	 * This method will handle the Form data sent to the login page.It will take in
	 * credentials as well as a request to the HTTPServlet. The method will have an
	 * HTTP session created and then will pass through the credentials to
	 * Authenticate users, and if the user is not properly authenticated, the site
	 * prompt the user Bad Request. If they are properly authenticated, there
	 * attributes will be filled properly. There will also be an OK HTTP request
	 * status.
	 */

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/sent")
	public ResponseEntity<User> handleFormRequest(@RequestBody Credential creds, HttpServletRequest req) {

		HttpSession session = req.getSession();

		User u = userService.authenticateUser(creds);
		if (u == null) {

			System.out.println("for the night");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("for the Weekend");

			session.setAttribute("User_Id", u.getUserId());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("userRole", u.getUserRole());

			session.setAttribute("problem", null);

			return new ResponseEntity<>(u, HttpStatus.OK);
		}
	}
	
}
