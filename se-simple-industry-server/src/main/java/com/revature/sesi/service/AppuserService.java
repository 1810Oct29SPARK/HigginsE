package com.revature.sesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.revature.sesi.model.Appuser;
import com.revature.sesi.repository.AppuserRepository;
import com.revature.sesi.utility.IndustryUtility;

@Service("appuserService")
public class AppuserService {

	private AppuserRepository appuserRepository;

	public AppuserService() {
		super();
	}

	public AppuserRepository getAppuserRepository() {
		return appuserRepository;
	}

	@Autowired
	@Qualifier("appuserRepository")
	public void setAppuserRepository(AppuserRepository appuserRepository) {
		this.appuserRepository = appuserRepository;
	}

	public Appuser getAppuserByEmailAndPassword(String email, String password) {

		Appuser authenticatedAppuser = null;

		try {
			Appuser retrievedAppuser = appuserRepository.findByEmail(email);

			if (retrievedAppuser != null) {
				if (retrievedAppuser.getPassword().equals(password)) {
					authenticatedAppuser = retrievedAppuser;
					authenticatedAppuser.setJws(IndustryUtility.createSignedJsonWebTokenWithEmailSubject(email));
				}
			}
		} catch (Exception e) {
			authenticatedAppuser = null;
		}

		return authenticatedAppuser;

	}

	public Appuser getAppuserByJws(String jws) {

		Appuser authenticatedAppuser = null;
		String email = null;

		try {
			email = IndustryUtility.getEmailSubjectFromSignedJsonWebToken(jws);

			if (email != null) {
				authenticatedAppuser = appuserRepository.findByEmail(email);
			} else {
				authenticatedAppuser = null;
			}
		} catch (Exception e) {
			authenticatedAppuser = null;
		}

		return authenticatedAppuser;

	}

}
