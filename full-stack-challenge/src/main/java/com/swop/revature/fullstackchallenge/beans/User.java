package com.swop.revature.fullstackchallenge.beans;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_id")
	private UserRole roleid;

	public User() {
		super();

	}

	public User(int id, String name, String email, String password, UserRole roleid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roleid = roleid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRoleid() {
		return roleid;
	}

	public void setRoleid(UserRole roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roleid="
				+ roleid + "]";
	}

	@JsonProperty("roleid")
	private void unpackNested(int role_id) {
		this.roleid = new UserRole();
		roleid.setId(role_id);
	}

}
