package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_Goods;
import com.oracle.entity.books;
import com.oracle.entity.goods;

public class ShowGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String booknumber = new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("书名:"+booknumber);
		String page = (String)request.getParameter("page");
		System.out.println("当前页数:"+page);
		books book = new books();
		search_Goods search = new search_Goods();
		book = search.searchSingleGoods(booknumber);
		if(book != null){
			request.setAttribute("goods", book);
			request.setAttribute("page", page);
			request.getRequestDispatcher("ShowGoods.jsp").forward(request, response);
		}else{
			response.sendRedirect("Login.jsp");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
