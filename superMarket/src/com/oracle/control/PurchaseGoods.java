package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_Goods;
import com.oracle.entity.goods;

public class PurchaseGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<goods> list = new ArrayList<goods>();
		search_Goods search = new search_Goods();
		list = search.searchAllGoods();   //没有分页
		Iterator iterator = list.iterator();
		if(iterator.hasNext() == true){
			request.setAttribute("list", list);
			request.getRequestDispatcher("PurchaseGoods.jsp").forward(request, response);
		}else{   //没有商品
			request.setAttribute("mess", "no");
			request.getRequestDispatcher("PurchaseGoods.jsp").forward(request, response);
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
