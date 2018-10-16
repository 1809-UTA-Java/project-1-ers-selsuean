package com.revature.ERS.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.ERS.model.Users;
import com.revature.ERS.repository.UserDAO;

public class saveNgetServlet {

	List<Users> users;
	UserDAO dao = new UserDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		/**
		 * ObjectMapper is part of jackson; used to de/serialize java objects
		 * XMLMapper gives it the context of xml (og ObjectMapper is for JSON)
		 * readvalue used to parse or deseriaalized XML content into a Java object
		 * writevale used to serialize Java objects into XML
		 * readvalye(what to read in, class to serialize into)
		 * 
		 * PrintWriter allows you to write formatted data to a Writer object 
		 * getWriter returns a PrintWriter object that can send character text to the client
		 * so pw is printing the result returned by insertUser method
		 * 
		 * the request is the user to be inserted into db
		 * the response is what the called method returns 
		 */
		ObjectMapper om = new XmlMapper();
		Users postUser = (Users) om.readValue(request.getInputStream(), Users.class);
		
		PrintWriter pw = response.getWriter();
		pw.print(dao.insertUser(postUser));
		pw.close();
	}
}
