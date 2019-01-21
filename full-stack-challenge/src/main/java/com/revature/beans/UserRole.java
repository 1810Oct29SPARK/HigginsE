package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class UserRole {

	public UserRole(int userRoleId, int userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleIdSequence")
	@SequenceGenerator(allocationSize = 1, name = "userRoleIdSequence", sequenceName = "SQ_USER_ROLE_PK")
	@Column(name = "USER_ROLE_ID")
	private int userRoleId;
	
	@Column(name="USER_ROLE")
	private int userRole;
	
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRole=" + userRole + "]";
	}
	
	
}