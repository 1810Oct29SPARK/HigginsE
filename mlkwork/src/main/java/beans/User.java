package beans;

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
@Table(name="USER")
public class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -4430710058921804679L;

public User(int id, String username, String password, String email,UserRole userRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userRole=userRole;
	}
public User() {
		super();
		// TODO Auto-generated constructor stub
	}

public User(String username, String password, String email ,UserRole userRole) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.userRole=userRole;
}



@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
@SequenceGenerator(allocationSize = 1, name = "userSequence", sequenceName = "SQ_USER_PK")
@Column(name = "USER_ID")
private int id;

@Column(name="NAME")
private String username;

@Column(name="PASSWORD")
private String password;

@Column(name="EMAIL")
private String email;


@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
@JoinColumn(name="USER_ROLE_ID")
private UserRole userRole;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public UserRole getUserRole() {
	return userRole;
}
public void setUserRole(UserRole userRole) {
	this.userRole = userRole;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
