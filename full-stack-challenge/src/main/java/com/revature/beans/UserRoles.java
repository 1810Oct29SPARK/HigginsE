package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USER_ROLES")
public class UserRoles implements Serializable {

	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRoles(int roleId, String title) {
		super();
		this.roleId = roleId;
		this.title = title;
	}
	
	public UserRoles(String title) {
		super();
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	private int roleId;
	
	@Column(name="TITLE")
	private String title;
	
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", title=" + title + "]";
	}

}
