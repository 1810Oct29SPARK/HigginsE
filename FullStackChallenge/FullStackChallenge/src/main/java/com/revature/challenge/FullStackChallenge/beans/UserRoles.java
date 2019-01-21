package com.revature.challenge.FullStackChallenge.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRoles implements Serializable {
	
	public UserRoles(int roleId, String type) {
		super();
		this.roleId = roleId;
		this.type = type;
	}
	
	public UserRoles(String type) {
		super();
		this.type = type;
	}
	
	@Id
	@Column(name="USER_ROLES_ID")
	private int roleId;
	@Column(name="ROLE")
	private String type;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", type=" + type + "]";
	}

}
