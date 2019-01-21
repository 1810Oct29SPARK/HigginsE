package com.revature.exercise.database;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = -6921066852096544591L;
	
	public User(int id, String name, String password, String email, UserRole userRole) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}
	
	public User(String name, String password, String email, UserRole userRole) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	@Id
	@Column(name = "USER_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ROLE_ID")
	private UserRole userRole;

}
