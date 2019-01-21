package com.revature.beans;

public class User {
	
	public User(int id, String username, String email, String password, UserRole roleId) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roleId = roleId;
	}

	public User() {
		super();
	}

	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private UserRole roleId;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserRole getRoleId() {
		return roleId;
	}

	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}

}