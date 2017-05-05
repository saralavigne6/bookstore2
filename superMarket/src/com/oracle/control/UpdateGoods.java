package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.insert_GoodsData;
import com.oracle.dao.search_Goods;
import com.oracle.entity.books;
import com.oracle.entity.goods;

public class UpdateGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String bookname = new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println("商品名称:"+goodsname);
		String page = (String)request.getParameter("page");
		System.out.println("当前页数:"+page);
		books book = new books();
		search_Goods search = new search_Goods();
		book = search.searchSingleGoods(bookname);
		if(book != null){
			request.setAttribute("goods", book);
			request.setAttribute("page", page);
			request.getRequestDispatcher("UpdateGoods.jsp").forward(request, response);
		}else{
			response.sendRedirect("Login.jsp");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		books book = new books();
		book.setBookname((String)request.getParameter("goodsname"));
		book.setDetail((String)request.getParameter("detail"));
		book.setPrice(Float.parseFloat((String)request.getParameter("price")));
		book.setTotal((String)request.getParameter("total"));
		book.setPicture((String)request.getParameter("picture"));
		book.setBooknumber((String)request.getParameter("booknumber"));
		book.setAuthor((String)request.getParameter("author"));
		book.setCopyright((String)request.getParameter("copyright"));
		insert_GoodsData update = new insert_GoodsData();
		if(update.update_Goods(book)==true){
			request.setAttribute("mess", "yes");
			request.setAttribute("page", "0");
			request.getRequestDispatcher("UpdateGoods.jsp").forward(request, response);
		}else{
			request.setAttribute("mess", "no");
			request.setAttribute("page", "0");
			request.getRequestDispatcher("UpdateGoods.jsp").forward(request, response);
		}
		
	}

}
