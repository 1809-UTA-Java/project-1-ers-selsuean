package com.revature.ERS.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.ERS.model.Reimbursement;

public class ReimbursementDAOTest {
//
//	@Test
//	public void nextReimbursementIDTest() {
//		ReimbursementDAO rdao = new ReimbursementDAO();
//		int maxID = rdao.nextReimbursementID();
//		assertTrue(maxID == 1);
//	}
//	
//	@Test
//	public void nextReimbursementTypeIDTest() {
//		ReimbursementDAO rdao = new ReimbursementDAO();
//		int maxID = rdao.nextReimbursementTypeID();
//		assertTrue(maxID == 1);
//	}
//
//	@Test
//	public void nextReimbursementStatusIDTest() {
//		ReimbursementDAO rdao = new ReimbursementDAO();
//		int maxID = rdao.nextReimbursementStatusID();
//		assertTrue(maxID == 1);
//	}
	
	@Test
	public void actionReimbursementTest() {
		ReimbursementDAO rdao = new ReimbursementDAO();
		int rsID = 1;
		rdao.actionReimbursement(rsID, "approved");
		
		Reimbursement thisR = rdao.thisReimbursement(rsID);
	
		
		assertTrue(thisR.getStatus().getrStatus().equals("approved"));
	}

}
