package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USER")
public class User {
	
	public User(int id,  String username,  String email,  String password, UserRole roleId) {
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(unique = true)
	
	private String username;
	
	@Column(unique = true)
	
	private String email;
	
	@Column
	
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id")
	@OnDelete (action = OnDeleteAction.CASCADE)
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
	
	@JsonProperty("roleId")
	private void unpackNested(int role_id) {
	    this.roleId = new UserRole();
	    roleId.setId(role_id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}

}