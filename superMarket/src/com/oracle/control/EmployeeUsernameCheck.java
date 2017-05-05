package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_User;

public class EmployeeUsernameCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String)request.getParameter("username");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		search_User search = new search_User();
		if(search.searchEmployeeExit(username) == true){    //用户名已经存在
			out.print("yes");
		}else{    //用户名不存在
			out.print("no");
		}
		out.flush();
		out.close();
	}

}
