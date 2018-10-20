package com.revature.ERS.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReimbursementDAOTest {

	@Test
	public void nextReimbursementIDTest() {
		ReimbursementDAO rdao = new ReimbursementDAO();
		int maxID = rdao.nextReimbursementID();
		assertTrue(maxID == 2);
	}
	
	@Test
	public void nextReimbursementTypeIDTest() {
		ReimbursementDAO rdao = new ReimbursementDAO();
		int maxID = rdao.nextReimbursementTypeID();
		assertTrue(maxID == 3);
	}

	@Test
	public void nextReimbursementStatusIDTest() {
		ReimbursementDAO rdao = new ReimbursementDAO();
		int maxID = rdao.nextReimbursementStatusID();
		assertTrue(maxID == 3);
	}

}
