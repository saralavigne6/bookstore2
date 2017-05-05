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

import com.oracle.dao.EmployeeSales;
import com.oracle.dao.search_Goods;
import com.oracle.entity.goods;
import com.oracle.entity.sales;

public class EmployeeSalesMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page1 = (String) request.getParameter("page");
		String username = (String) request.getParameter("username");
		if (username == null) {
			username = "";
		}
		int page = Integer.parseInt(page1);
		int key = 0;
		int key1 = 0;
		if (page < 0) {

			key = 1;
			page = 0;
		}
		EmployeeSales search = new EmployeeSales();
		float total = 0;
		total = search.SubEmployeeSales(username);
		List<sales> list = new ArrayList<sales>();
		list = search.searchSalesOrderPage(page, username);
		Iterator iterator = list.iterator();
		if (iterator.hasNext() == false) { // 没有数据了
			page = page - 1;
			key1 = 1;

			list = search.searchSalesOrderPage(page, username);
			if(username.equals("") == false)
				request.setAttribute("username", username);
			request.setAttribute("total", total);
			request.setAttribute("down", key1);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("EmployeeSalesMessage.jsp").forward(
					request, response);
		} else { // 分页找到数据
			if (key == 1 || page == 0) {
				request.setAttribute("up", key);
			}
			if(username.equals("") == false)
				request.setAttribute("username", username);
			request.setAttribute("total", total);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("EmployeeSalesMessage.jsp").forward(
					request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page1 = (String) request.getParameter("page");
		String username = (String) request.getParameter("username");
		if (username == null) {
			username = "";
		}
		int page = Integer.parseInt(page1);
		int key = 0;
		int key1 = 0;
		if (page < 0) {

			key = 1;
			page = 0;
		}
		EmployeeSales search = new EmployeeSales();
		List<sales> list = new ArrayList<sales>();
		float total = 0;
		total = search.SubEmployeeSales(username);
		
		boolean tag = false;
		tag = search.serachEmployeeSalesExit(username);
		if (tag == false) { // 不存在
			request.setAttribute("mess", "no1");
			request.getRequestDispatcher("MessageTip.jsp").forward(request,
					response);
		} else {

			list = search.searchSalesOrderPage(page, username);
			Iterator iterator = list.iterator();
			if (iterator.hasNext() == false) { // 没有数据了
				page = page - 1;
				key1 = 1;
				list = search.searchSalesOrderPage(page, username);
				if(username.equals("") == false)
					request.setAttribute("username", username);
				request.setAttribute("total", total);
				request.setAttribute("down", key1);
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.getRequestDispatcher("EmployeeSalesMessage.jsp")
						.forward(request, response);
			} else { // 分页找到数据
				if (key == 1 || page == 0) {
					request.setAttribute("up", key);
				}
				if(username.equals("") == false)
					request.setAttribute("username", username);
				request.setAttribute("total", total);
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.getRequestDispatcher("EmployeeSalesMessage.jsp")
						.forward(request, response);
			}
		}

	}

}
