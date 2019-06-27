package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRoles {

	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRoles(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")
	@SequenceGenerator(allocationSize = 1, name = "roleSequence", sequenceName = "SQ_USER_ROLES_PK")
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name="ROLE")
	private String role;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", role=" + role + "]";
	}
}