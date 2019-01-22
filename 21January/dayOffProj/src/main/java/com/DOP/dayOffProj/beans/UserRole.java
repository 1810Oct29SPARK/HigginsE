package com.DOP.dayOffProj.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "userRoleSequence")
	@SequenceGenerator(allocationSize=1, name="userRoleSequence", sequenceName="SQ_USER_ROLE_PK")
	@Column(name="ROLE_ID")
	private int roleId;
	@Column(name="NAME")
	private String name;
	
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(int roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}
	public UserRole(String name) {
		super();
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", name=" + name + "]";
	}
	
	
	
}
