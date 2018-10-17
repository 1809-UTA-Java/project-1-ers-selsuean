package com.revature.ERS;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.model.ReimbursementStatus;
import com.revature.ERS.model.ReimbursementType;
import com.revature.ERS.model.Users;
import com.revature.ERS.repository.ReimbursementDAO;
import com.revature.ERS.repository.UserDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/**
    	 * (int userID, String username, String password, String firstName,
    	 *  String lastName, String email,
			UserRolserRol
    	 */
//    	UserDAO udao = new UserDAO();
//    	//Users newUser = new Users(2, "ddellea", "happy", "dillon", "dellea", "ddellea17@gmail.com", new UserRole(2, "Employee") );
//    	
//    	//udao.insertUser(newUser);
//    	
//    	List<Users> userList = udao.getUsers();
//    	System.out.println(userList.get(0).toString());
    	
    	
    	/**
    	 * 
	public Reimbursement(int rID, double amount, String description,
	 Timestamp submitted, Timestamp resolved,
			Users author, Users resolver, ReimbursementType type, ReimbursementStatus status) {
    	 */
//    	UserDAO udao = new UserDAO();
//    	Users u = udao.thisUser("limsuean");
//    	
//    	
//    	Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
//    	ReimbursementType rt = new ReimbursementType(2, "Work");
//    	ReimbursementStatus rs = new ReimbursementStatus(2, "pending");
//    	ReimbursementDAO rdao = new ReimbursementDAO();
//    	Reimbursement newR = new Reimbursement(1, 100, "this is a test", currentTimestamp, currentTimestamp, 
//    			u, u, rt, rs);
//    	rdao.addReimbursement(newR);
//    	List<Reimbursement> rList = rdao.getReimbursements();
//    	System.out.println(rList.get(0).toString());
    }
}
