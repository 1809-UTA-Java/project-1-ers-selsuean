package com.revature.ERS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@Column(name="U_ID")
	private int userID;
	
	@Column(name="U_USERNAME")
	private String username;
	
	@Column(name="U_PASSWORD")
	private String password;
	
	@Column(name="U_FIRSTNAME")
	private String firstName;
	
	@Column(name="U_LASTNAME")
	private String lastName;
	
	@Column(name="U_EMAIL")
	private String email;
	
	@Column(name="UR_ID")
	private int userRoleID;

	public Users(int userID, String username, String password, String firstName, String lastName, String email,
			int userRoleID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleID = userRoleID;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", userRoleID=" + userRoleID + "]";
	}

	
	
}
