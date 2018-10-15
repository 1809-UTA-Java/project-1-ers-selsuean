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

@WebServlet("/home")
public class homeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = "limsuean";
		String password = "password";

		PrintWriter pw = resp.getWriter();
		String arg1 = req.getParameter("name");
		String arg2 = req.getParameter("password");

		if (arg1.equals(username) && arg2.equals(password)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", arg1);

			pw.println("Hello " + arg1 + "!");
			pw.close();
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
