package com.revature.ERS.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ERS.model.Users;

@WebServlet("/upload")
public class receiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO udao = new UserDAO();
	ReimbursementDAO rdao = new ReimbursementDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session != null) {
			
			String arg1 = (String) session.getAttribute("username");
			String role = udao.thisUserRole(arg1);
			Users u = udao.thisUser(arg1);
			
			if (role.equals("Employee")) {
				
				FileInputStream inputStream = new FileInputStream(request.getParameter("file"));
//				File imagePath = new File("image.jpg");
//				
//				/** CONVERTS IMAGE TO BYTES 	 */
//				byte[] imageToByte = new byte[(int)imagePath.length()];
//				
//				/** CREATE INPUT OBJECT   */
//				FileInputStream inputStream = new FileInputStream(imagePath);
//				
//				/** INPUT STREAM READS FILE    */
//				inputStream.read(imageToByte);
//				inputStream.close();
			}
		}
	}

}
