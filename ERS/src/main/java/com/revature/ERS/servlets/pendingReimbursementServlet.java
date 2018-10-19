package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.repository.ReimbursementDAO;
import com.revature.ERS.repository.UserDAO;

@WebServlet("/pending")
public class pendingReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReimbursementDAO rdao = new ReimbursementDAO();
	UserDAO udao = new UserDAO();
	List<Reimbursement> rList = rdao.allReimbursements();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter pwSesh = response.getWriter();
		
		if (session!=null) {
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);
			
			response.setContentType("text/xml");
			PrintWriter pw = response.getWriter();
			
			ObjectMapper om = new XmlMapper();
			List<Reimbursement> allPendReimbursements = new ArrayList<Reimbursement>();
			
			if (role.equals("Manager")) {
				
				for (Reimbursement r : rList) {
					if (r.getStatus().equals("pending")) {
						allPendReimbursements.add(r);
					}
				}
				String obj = om.writeValueAsString(allPendReimbursements);
				pw.print(obj);
				return;
			}
			
			if (role.equals("Employee")) {
				allPendReimbursements = udao.thisUserReimbursement(arg1);
				String obj = om.writeValueAsString(allPendReimbursements);
				pw.print(obj);
				return;
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
