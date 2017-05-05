package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.BooksDao;
import com.oracle.entity.books;

public class ShowPictureHome extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<books> list = new ArrayList<books>();
		BooksDao book = new BooksDao();
		list = book.searchPartBooks();   //从数据库中查找所有书籍
		request.setAttribute("list", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
