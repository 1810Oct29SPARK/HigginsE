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
@Table(name="USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public User (int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "useridSequence")
	@SequenceGenerator(allocationSize = 1, name = "useridSequence", sequenceName = "SQ_USERID_PK")
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	
	
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
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
