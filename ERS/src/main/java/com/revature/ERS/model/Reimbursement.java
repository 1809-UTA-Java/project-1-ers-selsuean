package com.revature.ERS.model;

import java.sql.Timestamp;

public class Reimbursement {
	private int rID;
	private double amount;
	private String description;
	//receipt blob
	private Timestamp submitted;
	private Timestamp resolved;
	
}
