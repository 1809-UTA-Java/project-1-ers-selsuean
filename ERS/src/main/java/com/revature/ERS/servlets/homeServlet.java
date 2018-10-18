package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ERS.model.Users;
import com.revature.ERS.repository.UserDAO;

@WebServlet("/home")
public class homeServlet extends HttpServlet {

	UserDAO udao = new UserDAO();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("username");
		String arg2 = req.getParameter("password");
		
		Users u = udao.thisUser(arg1);

		if (arg1.equals(u.getUsername()) && arg2.equals(u.getPassword())) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", arg1);
			String role = udao.thisUserRole(arg1);
			
			if (role.equals("Employee")) {
				RequestDispatcher rd = req.getRequestDispatcher("employeehomepage.html");
				rd.include(req, resp);
			}
			else if (role.equals("Manager")) {
				RequestDispatcher rd = req.getRequestDispatcher("managerhomepage.html");
				rd.include(req, resp);
			}
			else {
				PrintWriter out = resp.getWriter();
				out.println("error");
			}

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			// resp.sendRedirect("login");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>Either username or password is wrong. Try again.</font>");
			rd.include(req, resp);
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter pw = resp.getWriter();
		if (session != null) {

			String arg1 = (String) session.getAttribute("username");

			pw.println("Hello again " + arg1 + "!");
			pw.close();
		} else {
			pw.println("Error !");
		}
	}
}
