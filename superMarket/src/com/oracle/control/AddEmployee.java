package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_User;
import com.oracle.entity.employee;

public class AddEmployee extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employee em = new employee();
		em.setUsername((String)request.getParameter("username"));
		search_User search = new search_User();
		if(search.searchEmployeeExit(em.getUsername()) == true){   //用户名已经存在
			request.setAttribute("mess", "ex");
			request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
		}
		em.setUserpass((String)request.getParameter("userpass"));
		em.setId((String)request.getParameter("id"));
		em.setTel((String)request.getParameter("salary"));
		em.setRealname((String)request.getParameter("realname"));
		em.setSalary(Float.parseFloat(request.getParameter("salary")));
		if(search.insertEmployee(em) == true){
			request.setAttribute("mess", "yes");
			request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
		}else{
			request.setAttribute("mess", "no");
			request.getRequestDispatcher("AddEmployee.jsp").forward(request, response);
		}
		
		
	}

}
