package com.revature.ERS.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REIMBURSEMENTS")
public class Reimbursement {
	@Id
	@Column(name = "R_ID")
	private int rID;

	@Column(name = "R_AMOUNT")
	private double amount;

	@Column(name = "R_DESCRIPTION")
	private String description;
	// receipt blob

	@Column(name = "R_SUBMITTED")
	private Timestamp submitted;

	@Column(name = "R_RESOLVED")
	private Timestamp resolved;

	@ManyToOne
	@JoinColumn(name = "U_ID_AUTHOR")
	private Users author;

	@ManyToOne
	@JoinColumn(name = "U_ID_RESOLVER")
	private Users resolver;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "RT_TYPE")
	private ReimbursementType type;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "RT_STATUS")
	private ReimbursementStatus status;

	public Reimbursement(int rID, double amount, String description, Timestamp submitted, Timestamp resolved,
			Users author, Users resolver, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.rID = rID;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	public Users getResolver() {
		return resolver;
	}

	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
	}

	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", amount=" + amount + ", description=" + description + ", submitted="
				+ submitted + ", resolved=" + resolved + ", type=" + type + ", status=" + status + "]";
	}

}
