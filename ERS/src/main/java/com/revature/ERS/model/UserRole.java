package com.revature.ERS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRole {

	@Id
	@Column(name = "UR_ID")
	private int urID;

	@Column(name = "UR_ROLE")
	private String roles;

	public UserRole(int urID, String roles) {
		super();
		this.urID = urID;
		this.roles = roles;
	}

	public UserRole() {
		super();
	}

	public int getUrID() {
		return urID;
	}

	public void setUrID(int urID) {
		this.urID = urID;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
