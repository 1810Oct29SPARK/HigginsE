package com.carlos.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class User_Role implements Serializable {

	public User_Role(int userRoleID, String title) {
		super();
		this.userRoleID = userRoleID;
		this.title = title;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3577731497569029334L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "userRoleSequence")
	@SequenceGenerator(allocationSize=1, name="userRoleSequence", sequenceName = "SQ_USER_ROLE_PK")
	@Column(name="USER_ROLE_ID")
	private int userRoleID;
	@Column(name="title")
	private String title;
	
	
	
	public int getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "User_Role [userRoleID=" + userRoleID + ", title=" + title + "]";
	}
	
}
