package com.assignment.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Role implements Serializable{


	private static final long serialVersionUID = 2851990859027454235L;


	public Role(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")
	@SequenceGenerator(allocationSize = 1, name = "roleSequence", sequenceName = "SQ_ROLE_ID_PK")
	@Column(name = "USER_ROLE_ID")
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
		return "Role [roleId=" + roleId + ", role=" + role + "]";
	}

}
