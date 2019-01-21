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
@Table(name = "USER_ROLES")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7910002628676412810L;

	public UserRoles() {
		super();
	}
	
	public UserRoles(int userRoleId, String role) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")
	@SequenceGenerator(allocationSize = 1, name = "roleSequence", sequenceName = "SQ_USER_ROLES_PK")
	@Column(name = "USER_ROLE_ID")
	private int userRoleId;
	
	@Column(name="ROLE")
	private String role;
	
	public int getUserRoleId() {
		return userRoleId;
	}
	
	public void setUserRoleId(int roleId) {
		this.userRoleId = roleId;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRoles [userRoleId=" + userRoleId + ", role=" + role + "]";
	}
}
