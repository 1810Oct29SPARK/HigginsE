package login.portal.services;

import login.portal.model.User;
import login.portal.repositories.UserDAO;

public class AuthenticationService {
	
	
	
	public AuthenticationService() {
		//no-args constructor
	}
	
	public User isValidUser(User user) {
		//I might need something here...
		String username = user.getUsername();
		String password = user.getPassword();
		User valid = 
	}
	
	
}
