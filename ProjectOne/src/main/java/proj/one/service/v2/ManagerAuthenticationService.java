package proj.one.service.v2;

import proj.one.beans.ManagerUser;

public class ManagerAuthenticationService {
	
	public ManagerAuthenticationService() {
	}
	
	public ManagerUser isValidManager(ManagerUser user) {
		ManagerUser m = null;
		String username = user.getManagerUser();
		String password = user.getManagerUser();
		if (username != null && password != null) {
			
		}
		return m;
	}

}
