package com.revature.sesi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.sesi.model.Appuser;
import com.revature.sesi.model.LoginPayload;
import com.revature.sesi.service.AppuserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/appuser")
public class AppuserController {

	private AppuserService appuserService;

	public AppuserController() {
		super();
	}

	public AppuserService getAppuserService() {
		return appuserService;
	}

	@Autowired
	@Qualifier("appuserService")
	public void setAppuserService(AppuserService appuserService) {
		this.appuserService = appuserService;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public ResponseEntity<Appuser> sendAuthenticatedAppuserIfLoginValid(@RequestBody LoginPayload loginPayload) {

		HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
		Appuser validatedAppuser = null;

		String email = loginPayload.getEmail();
		String password = loginPayload.getPassword();
		String jws = loginPayload.getJws();

		if (jws != null) {
			validatedAppuser = appuserService.getAppuserByJws(jws);
		} else {
			validatedAppuser = appuserService.getAppuserByEmailAndPassword(email, password);
		}

		if (validatedAppuser == null) {
			status = HttpStatus.UNAUTHORIZED;
			validatedAppuser = new Appuser();
		} else {
			status = HttpStatus.OK;
		}

		return new ResponseEntity<Appuser>(validatedAppuser, status);

	}

}
