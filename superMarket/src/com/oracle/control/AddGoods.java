package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.search_Goods;
import com.oracle.entity.books;
import com.oracle.entity.goods;

public class AddGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		books book = new books();
		book.setBooknumber((String)request.getParameter("booknumber"));
		search_Goods search = new search_Goods();
		if(search.search_GoodsName_Exit(book.getBooknumber()) == true){
			request.setAttribute("message", "ex");
			request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
		}else{
			book.setBookname((String)request.getParameter("bookname"));
			book.setAuthor((String)request.getParameter("author"));
			book.setPrice(Float.parseFloat((String)request.getParameter("price")));
			book.setCopyright((String)request.getParameter("copyright"));
			book.setDetail((String)request.getParameter("detail"));
			book.setTotal((String)request.getParameter("total"));
			HttpSession session = (HttpSession)request.getSession();
			session.setAttribute("goods", book);
			request.getRequestDispatcher("market_Items.jsp").forward(request, response);
		}
	}

}
