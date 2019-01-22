package com.revature.sesi.controller;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
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
import com.revature.sesi.utility.IndustryUtility;

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

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<Appuser> sendNewlyRegisteredAppuserIfValid(HttpServletRequest request) {

		HttpStatus status = HttpStatus.I_AM_A_TEAPOT;
		Appuser registeredUser = null;

		try (BufferedReader br = request.getReader()) {
			JSONObject jo = new JSONObject(IndustryUtility.readRequest(br));
			String firstName = jo.getString("firstName");
			String lastName = jo.getString("lastName");
			String email = jo.getString("email");
			String password = jo.getString("password");

			registeredUser = appuserService.saveNewAppuserAsMember(firstName, lastName, email, password);
			if (registeredUser != null) {
				status = HttpStatus.OK;
				if (email.endsWith("@mailinator.com") || email.endsWith("@gmail.com")) {
					String emailContent = String.format("Welcome to SE Simple Industry!%n%s %s", firstName, lastName);
					IndustryUtility.sendEmail(email, "Your New SESI Account Activated", emailContent);
				}
			} else {
				status = HttpStatus.CONFLICT;
				registeredUser = new Appuser();
			}
		} catch (Exception e) {
			status = HttpStatus.BAD_REQUEST;
			registeredUser = new Appuser();
		}

		return new ResponseEntity<Appuser>(registeredUser, status);

	}

}
