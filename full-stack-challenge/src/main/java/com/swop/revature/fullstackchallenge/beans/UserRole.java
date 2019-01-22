package com.swop.revature.fullstackchallenge.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_roles")
public class UserRole{
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleId")
	private int id;
	
	@Column(name="NAME")
	@NotNull
	private String name;
	
	
	public UserRole(int id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
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


	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + "]";
	}	
	


	

}
