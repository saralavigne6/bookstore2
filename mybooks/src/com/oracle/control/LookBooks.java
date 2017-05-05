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

public class LookBooks extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//搜索所有书籍，并保存数据
		List<books> list = new ArrayList<books>();
		BooksDao dao = new BooksDao();
		list = dao.searchAllBooks();
		request.setAttribute("list", list);
		request.getRequestDispatcher("books.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
