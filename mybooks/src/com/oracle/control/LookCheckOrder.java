package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.ChecksDao;
import com.oracle.entity.checks;

public class LookCheckOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){
				request.setAttribute("message", "fail1");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{
				List<checks> list = new ArrayList<checks>();
				ChecksDao dao = new ChecksDao();
				list = dao.searchAllChecks((String)session.getAttribute("username"));
				if(list != null){   //说明有订单
					
					request.setAttribute("list", list);
					request.getRequestDispatcher("LookCheckOrder.jsp").forward(request, response);
				}else{   //没有订单
					request.setAttribute("message", "noresult");
					request.getRequestDispatcher("LookCheckOrder.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
