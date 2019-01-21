package com.revature.beans;

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
@Table(name="USER")
public class User {

	public User(int userId, String login, String pass, UserRole userRole) {
		super();
		this.userId = userId;
		this.login = login;
		this.pass = pass;
		this.userRole = userRole;
	}
	
	public User() {
		super();
}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userIdSequence")
	@SequenceGenerator(allocationSize=1,name="userIdSequence",sequenceName="SQ_USER_PK")
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASS")
	private String pass;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name="USER_ROLE_ID")
	private UserRole userRole;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", login=" + login + ", pass=" + pass + "]";
	}

}
