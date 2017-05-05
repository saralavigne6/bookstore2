package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_User;

public class DeleteEmployee extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username1 = (String)request.getParameter("username");
		String username = new String(username1.getBytes("ISO-8859-1"),"UTF-8");
		String page = (String)request.getParameter("page");
		search_User search = new search_User();
		if(search.deleteEmployeeMessage(username) == true){    //É¾³ý³É¹¦
			request.setAttribute("mess", "del");
			request.setAttribute("page", page);
			request.getRequestDispatcher("MessageTip.jsp").forward(request, response);
		}else{   //É¾³ýÊ§°Ü
			request.setAttribute("mess", "nodel");
			request.setAttribute("page", page);
			request.getRequestDispatcher("MessageTip.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
