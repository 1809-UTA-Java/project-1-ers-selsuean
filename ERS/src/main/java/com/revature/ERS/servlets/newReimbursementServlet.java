package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.model.ReimbursementStatus;
import com.revature.ERS.model.ReimbursementType;
import com.revature.ERS.repository.ReimbursementDAO;
import com.revature.ERS.repository.UserDAO;

@WebServlet("/new")
public class newReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO udao = new UserDAO();
	ReimbursementDAO rdao = new ReimbursementDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);

			if (role.equals("Employee")) {
				RequestDispatcher rd = request.getRequestDispatcher("newreimbursement.html");
				rd.forward(request, response);

			} else {
				pwSesh.println("You must login first!");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pwSesh = response.getWriter();

		if (session != null) {
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);

			if (role.equals("Employee")) {

				String descr = request.getParameter("description");
				double amount = Double.parseDouble(request.getParameter("amount"));
				String type = request.getParameter("type");
				
				/**
				 * Reimbursement:
				 * int rID, double amount, String description, 
				 * Timestamp submitted, Timestamp resolved,
				 * Users author, Users resolver, 
				 * ReimbursementType type, ReimbursementStatus status
				 * 
				 */
				
				int rID = rdao.nextReimbursementID();
				Timestamp submitted = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
				ReimbursementType rType = new ReimbursementType(rdao.nextReimbursementTypeID(),type);
				ReimbursementStatus rStatus = new ReimbursementStatus(rdao.nextReimbursementStatusID(),"pending");
				
				Reimbursement thisR = new Reimbursement(rID, amount, descr, 
						submitted, null, 
						udao.thisUser(arg1), null, 
						rType, rStatus);
				
				rdao.saveReimbursement(thisR);
				
				pwSesh.println("Reimursement submitted!");

			} else {
				pwSesh.println("You must login first!");
			}
		}

	}
}
