package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.repository.ReimbursementDAO;
import com.revature.ERS.repository.UserDAO;

@WebServlet("/action")
public class actionReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReimbursementDAO rdao = new ReimbursementDAO();
	UserDAO udao = new UserDAO();
	List<Reimbursement> rList = rdao.allReimbursements();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pwSesh = response.getWriter();
		
		if (session != null) {
			
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);
			
			if (role.equals("Manager")) {
				
				//list all reimbursements with pending status
				//include html form for option to approve or deny and text to enter id
				//call dao to take action on that reimbursement 
				
			}
			
		} else {
			pwSesh.println("You must login first!");
		}
		
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
