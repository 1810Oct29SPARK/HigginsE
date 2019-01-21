package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.beans.User;
import com.revature.daos.UserDAO;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService us;
	private UserDAO ud;


	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}

	@Autowired
	public void setUserDAO(UserDAO ud) {
		this.ud = ud;
	}


	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		ResponseEntity<String> resp = null;
		try {
			us.saveUser(user);
			resp = new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

/*	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public RedirectView handleFormRequest(@RequestParam(name = "login") String login, @RequestParam(name = "pass") String pass, RedirectAttributes attributes) {

		User user = ud.getUserByLogin(login);
		if (user != null) {
			if (user.getLogin().equals(pass) && user.getUserRole().getUserRoleId() == 1) {
				return new RedirectView("http://localhost:4200/admin");
			} else if (user.getLogin().equals(pass)) {
				return new RedirectView("http://localhost:4200/user");
			}
		}
		return new RedirectView("http://localhost:4200/login");
	}
}*/
	// handle form data sent to "/login"
		@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
		public RedirectView handleFormRequest(@RequestBody MultiValueMap<String, String> formParams, RedirectAttributes attributes, Model m) {

			User u = us.validateUser(formParams.getFirst("login"), formParams.getFirst("pass"));
			if (u == null) {
				// redirect to error page
				return new RedirectView("error");
			} else {
				// redirect to profile
				attributes.addFlashAttribute("user",u);
				return new RedirectView("/admin");
			}
		}
}