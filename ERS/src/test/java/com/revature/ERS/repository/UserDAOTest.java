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

//	@Test
//	public void testThisUserRole() {
//		String role = "Manager";
//		
//		UserDAO udao = new UserDAO();
//		UserRole ur = new UserRole();
//		String DAOrole;
//		
//		DAOrole = udao.thisUserRole("limsuean");
//
//		assertEquals(DAOrole, role);
//	}
	
//	@Test
//	public void testActionPassword() {
//		String username = "ddellea";
//		String entry = "iloveyou";
//		
//		UserDAO udao = new UserDAO();
//		udao.actionPassword(username, entry);
//		
//		Users thisUser = udao.thisUser(username);
//		assertTrue(thisUser.getPassword().equals(entry));
//	}
	
//	@Test
//	public void testActionUsername() {
//		String username = "ddellea";
//		String entry = "dillon.dellea";
//		
//		UserDAO udao = new UserDAO();
//		udao.actionUsername(username, entry);
//		
//		Users thisUser = udao.thisUser(entry);
//		assertTrue(thisUser.getUsername().equals(entry));
//	}
	
	@Test
	public void testActionEmail() {
		String username = "dillon.dellea";
		String entry = "dillon.dellea@fakedomain.com";
		
		UserDAO udao = new UserDAO();
		udao.actionEmail(username, entry);
		
		Users thisUser = udao.thisUser(username);
		assertTrue(thisUser.getEmail().equals(entry));
	}
}
