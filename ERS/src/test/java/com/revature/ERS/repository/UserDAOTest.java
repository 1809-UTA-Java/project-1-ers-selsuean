package com.revature.ERS.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.ERS.model.UserRole;
import com.revature.ERS.model.Users;

public class UserDAOTest {

//	@Test
//	public void testGetUsers() {
//		Users u = new Users();
//		
//	}

	@Test
	public void testThisUserRole() {
		String role = "manager";
		
		UserDAO udao = new UserDAO();
		UserRole ur = new UserRole();
		String DAOrole;
		
		DAOrole = udao.thisUserRole("limsuean");
//		assertTrue(ur.getRoles().equals(role));
		//assertTrue(ur==null);
//		assertEquals(DAOrole, role);
		assertEquals(DAOrole, null);
		
	}
}
