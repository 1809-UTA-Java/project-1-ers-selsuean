package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.ERS.model.Users;
import com.revature.ERS.repository.UserDAO;


// TODO: need button in emp view to update their info
// TODO: need button in manager view to see specific employee and view their reimbursement request 
//			maybe in manager home page tho 

/**
 * localhost:8080/ERS/employees doGet: list all the employees IF
 * userRole='Manager' ELSE list employee by u_id
 * 
 * 
 * @author Su Ean Lim
 *
 */

@WebServlet("/employees")
public class empInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public empInfoServlet() {
		super();
	}

	UserDAO udao = new UserDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {

			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);
			Users u = udao.thisUser(arg1);

			/**
			 * getServletPath retrieves the path that caused the request to be mapped to
			 * this servlet i.e. should return '/employees'
			 * 
			 * getPathInfo retrieves any information that then comes after the servlet path
			 * you can use this to check if the url reads /employees/1 and if it does, then
			 * u can change what the page displays
			 * 
			 * .split() is a method used for String objects that will return the portion(s)
			 * of the String separated by the given parameter
			 */
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();

			List<Users> userList = udao.allUsers();
			ObjectMapper om = new XmlMapper();

			/** ONLY MANAGERS CAN SEE FULL EMPLOYEES LIST */
			if (role.equals("Manager")) {
				String obj = om.writeValueAsString(userList);
				pw.print(obj);
				return;
			}

			if (role.equals("Employee")) {
				int thisUserID = u.getUserID();
				Users displayUser = null;
				for (Users forU : userList) {
					if (forU.getUserID() == thisUserID) {
						displayUser = forU;
					}
				}

				if (displayUser != null) {
					String obj = om.writeValueAsString(displayUser);
					pw.print(obj);	
				}
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("updatebutton.html");
			rd.include(request, response);

		} else {
			pwSesh.println("You must login first!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {
			String arg1 = (String) session.getAttribute("username");
			String choice = request.getParameter("info");
			if (choice.equals("username")) {
				String entry = request.getParameter("usernameentry");
				udao.actionUsername(arg1, entry);
				pwSesh.print("Username updated. You will have to login again.");
//				RequestDispatcher rd = request.getRequestDispatcher("/logout");
//				rd.forward(request, response);
				response.setHeader("Refresh", "2; /ERS/logout");
			}
			if (choice.equals("password")) {
				String entry = request.getParameter("passwordentry");
				udao.actionPassword(arg1, entry);
				pwSesh.print("Password updated");
			}
			if (choice.equals("email")) {
				String entry = request.getParameter("emailentry");
				udao.actionEmail(arg1, entry);
				pwSesh.print("Email updated");
			}
			
			

		} else {
			pwSesh.println("You must login first!");
		}
	}

}
