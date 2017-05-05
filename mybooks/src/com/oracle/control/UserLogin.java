package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.CustomerDao;

public class UserLogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String username = (String)request.getParameter("username");
			String userpass = (String)request.getParameter("userpass");
			CustomerDao cus = new CustomerDao();
			if(cus.userLogin(username, userpass)){
				request.setAttribute("mess", "yes");
				HttpSession session = (HttpSession)request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}else{
				request.setAttribute("mess", "no");
				request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

}
