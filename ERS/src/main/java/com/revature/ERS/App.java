package com.revature.ERS;

import java.util.List;

import com.revature.ERS.model.UserRole;
import com.revature.ERS.model.Users;
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
    	UserDAO udao = new UserDAO();
    	Users newUser = new Users(1, "limsuean", "password", "su ean", "lim", "selsuean@gmail.com", new UserRole(1, "Manager") );
    	
    	udao.insertUser(newUser);
    	
    	List<Users> userList = udao.getUsers();
    	System.out.println(userList.get(0).toString());
    }
}
