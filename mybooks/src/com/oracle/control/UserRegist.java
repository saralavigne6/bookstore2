package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.CustomerDao;
import com.oracle.entity.customer;

public class UserRegist extends HttpServlet {

	
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
		//获取用户注册信息
		try{
		customer cus = new customer();
		cus.setUsername((String)request.getParameter("username"));
		cus.setUserpass((String)request.getParameter("userpass"));
		cus.setTel((String)request.getParameter("tel"));
		cus.setEmail((String)request.getParameter("email"));
		CustomerDao dao = new CustomerDao();
		if(dao.searchCusUsernameExit(cus.getUsername())){   //账号已经存在，本次注册不成功
			request.setAttribute("mess", "no");
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}else{    // 可以进行注册
			if(dao.userRegist(cus)){
				request.setAttribute("mess", "yes");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			}else{   //系统出错
				response.sendRedirect("404error.html");
			}
		}
	}catch(Exception e){
		response.sendRedirect("404error.html");
	}
		
		
		
	}

}
