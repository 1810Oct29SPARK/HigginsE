package com.revature.exercise.database;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="USER_ROLE")
public class UserRole implements Serializable{

	private static final long serialVersionUID = -100141452051494496L;

	@Id
	@Column(name="USER_ROLE_ID")
	private int id;
	
	@Column(name="ROLE")
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public UserRole(int id) {
		super();
		this.id = id;
	}
	
	public UserRole(String role) {
		super();
		this.role = role;
	}
	
	public UserRole() {
		super();
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role=" + role + "]";
	}

}
