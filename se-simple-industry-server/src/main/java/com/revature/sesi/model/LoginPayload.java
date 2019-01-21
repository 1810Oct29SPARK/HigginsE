package com.revature.sesi.model;

public class LoginPayload {

	private String email;
	private String password;
	private String jws;

	public LoginPayload() {
		super();
	}

	public LoginPayload(String jws) {
		super();
		this.jws = jws;
	}

	public LoginPayload(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJws() {
		return jws;
	}

	public void setJws(String jws) {
		this.jws = jws;
	}

	@Override
	public String toString() {
		return "LoginPayload [email=" + email + ", password=" + password + ", jws=" + jws + "]";
	}

}
