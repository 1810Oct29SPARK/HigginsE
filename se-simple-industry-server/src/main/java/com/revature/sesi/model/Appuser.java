package com.revature.sesi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APPUSER")
public class Appuser implements Serializable {

	private static final long serialVersionUID = 1L;

	private long appuserId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private UserRole userRole;
	private String jws;

	public Appuser() {
		super();
	}

	public Appuser(long appuserId) {
		super();
		this.appuserId = appuserId;
	}

	public Appuser(String jws) {
		super();
		this.jws = jws;
	}

	public Appuser(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Appuser(long appuserId, String firstName, String lastName, String email, String password, String jws) {
		super();
		this.appuserId = appuserId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.jws = jws;
	}

	@Id
	@Column(name = "APPUSER_ID")
	public long getAppuserId() {
		return appuserId;
	}

	public void setAppuserId(long appuserId) {
		this.appuserId = appuserId;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ROLE_ID")
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Transient
	public String getJws() {
		return jws;
	}

	public void setJws(String jws) {
		this.jws = jws;
	}

	@Override
	public String toString() {
		return "Appuser [appuserId=" + appuserId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (appuserId ^ (appuserId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appuser other = (Appuser) obj;
		if (appuserId != other.appuserId)
			return false;
		return true;
	}

}
