package login.portal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {
	
	public UserRole() {
		super();
	}

	public UserRole(String roleId, String role, List<User> users) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userRoleSequence")
	@SequenceGenerator(allocationSize = 1, name = "userRoleSequence", sequenceName = "SQ_USER_ROLE_PK")
	@Column(name = "USER_ROLE_ID")
	private String roleId;
	
	@Column(name = "USER_ROLE_NAME")
	private String role;
	
	@OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, orphanRemoval = true)
	@JoinColumn(name = "USER_ROLE_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private List<User> users = new ArrayList<>();

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", role=" + role + ", users=" + users + "]";
	}

}
