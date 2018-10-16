package com.revature.ERS.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="REIMBURSEMENTS")
public class Reimbursement {
	@Id
	@Column(name="R_ID")
	private int rID;
	
	@Column(name="R_AMOUNT")
	private double amount;
	
	@Column(name="R_DESCRIPTION")
	private String description;
	//receipt blob
	
	@Column(name="R_SUBMITTED")
	private Timestamp submitted;
	
	@Column(name="R_RESOLVED")
	private Timestamp resolved;
	
//	private String author;
//	private String resolver;
	
	@OneToMany
	@JoinColumn(name="USERROLES")
	private UserRole author;
	
	@OneToMany
	@JoinColumn(name="USERROLES")
	private UserRole resolver;
	
	private String type;
	
	private int status;
}
