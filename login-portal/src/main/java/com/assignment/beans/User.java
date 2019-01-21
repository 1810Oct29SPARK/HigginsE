package com.assignment.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8142715083876793556L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
	@SequenceGenerator(allocationSize = 1, name = "userSequence", sequenceName = "SQ_USER_ID_PK")
	@Column(name = "USER_ID")
	private int userId;

	public User(int userId, String firstname, String lastname, String email, String username, String password,
			Role role) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name= "EMAIL")
	private String email;
	
	@Column(name= "USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}