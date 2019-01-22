package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class User implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2330907753270922122L;

	public User (int id, String name, String email, String username) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
	}
	
	public User() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "useridSequence")
	@SequenceGenerator(allocationSize = 1, name = "useridSequence", sequenceName = "SQ_USERID_PK")
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_USERNAME")
	private String username;
	
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
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + "]";
	}
	
	
}
