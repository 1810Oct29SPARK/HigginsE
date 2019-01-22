package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERROLE")
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	@Id
	@Column(name="USER_ID")
	private int id;

	@Column(name="USER_ROLE")
	private String role;

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role=" + role + "]";
	}
	

}
