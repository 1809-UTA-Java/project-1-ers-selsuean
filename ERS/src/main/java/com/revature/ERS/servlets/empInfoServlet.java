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

/**
 * localhost:8080/ERS/employees doGet: list all the employees IF
 * userRole='Manager' ELSE redirect to doGet employees/[u_id]
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

			String path = request.getPathInfo();

			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();

			List<Users> userList = udao.allUsers();
			ObjectMapper om = new XmlMapper();

			// FOR PATH: ERS/employees/
			if (path == null || path.equals("/")) {

				/** ONLY MANAGERS CAN SEE FULL EMPLOYEES LIST */
				if (role.equals("Manager")) {
					String obj = om.writeValueAsString(userList);
					pw.print(obj);
					return;
				}

			}

//			String[] pathParam = path.split("/");
//			int userID = Integer.parseInt(pathParam[1]);
//			Users thisUser = null;
//			for (Users forU : userList) {
//				if (forU.getUserID() == userID) {
//					thisUser = forU;
//				}
//			}
//
//			if (thisUser != null) {
//				String obj = om.writeValueAsString(thisUser);
//				pw.print(obj);
//			}

		} else {
			pwSesh.println("You must login first!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {
			doGet(request, response);
//			String arg1 = (String) session.getAttribute("username");
//			String role = udao.thisUserRole(arg1);
//			Users u = udao.thisUser(arg1);
//		
//		if (role.equals("Employee")) {
//			RequestDispatcher rd = request.getRequestDispatcher("employee/" + Integer.toString(u.getUserID()));
//			rd.forward(request, response);
//		}
		} else {
			pwSesh.println("You must login first!");
		}
	}

}
