package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.ChecksDao;

public class DealCheck extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = (HttpSession)request.getSession();
		if(session.getAttribute("username") == null){
			response.sendRedirect("Login.jsp");
		}else{   //¥¶¿Ì∂©µ•
			String checkid = (String)request.getParameter("checkid");
			String manager = (String)session.getAttribute("username");
			ChecksDao dao = new ChecksDao();
			if(dao.updateDealCheck(checkid,manager) == true){
				request.setAttribute("message", "success");
				request.getRequestDispatcher("GoodsSearch.jsp").forward(request, response);
			}
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
