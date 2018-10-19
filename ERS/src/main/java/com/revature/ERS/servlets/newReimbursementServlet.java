package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ERS.repository.ReimbursementDAO;
import com.revature.ERS.repository.UserDAO;

@WebServlet("/new")
public class newReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO udao = new UserDAO();
	ReimbursementDAO rdao = new ReimbursementDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);
			
			
			if (role.equals("Employee"))  {
				
			}
			
			
		} else {
			pwSesh.println("You must login first!");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
