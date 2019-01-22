package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table (name = "USERS")
public class Users implements Serializable {
	
	
	
	public Users(int userId, String username, String userpass, String email, UserRoles userrole) {
		super();
		this.userId = userId;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
		this.userrole = userrole;
	}

	public Users() {
		super();

	}
	
	public Users(String username, String userpass, UserRoles userrole) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.userrole = userrole;
	}


	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="USER_PASS")
	private String userpass;
	
	@Column(name="EMAIL")
	private String email; 
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private UserRoles userrole;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getUserPass() {
		return userpass;
	}

	public void setUserPass(String userpass) {
		this.userpass = userpass;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRoles getUserRole() {
		return userrole;
	}

	public void setUserRole(UserRoles userrole) {
		this.userrole = userrole;
	}
	
	@JsonProperty("roleId")
	private void unpackNested(int roleId) {
		this.userrole = new UserRoles();
		userrole.setRoleId(roleId);
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", userpass=" + userpass + ", email=\" + email, userrole="
				+ userrole + "]";
	}
	

}
