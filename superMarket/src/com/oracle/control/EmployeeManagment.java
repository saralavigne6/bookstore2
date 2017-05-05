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
import com.oracle.dao.search_User;
import com.oracle.entity.employee;
import com.oracle.entity.sales;

public class EmployeeManagment extends HttpServlet {

	
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
		search_User search = new search_User();
		
		List<employee> list = new ArrayList<employee>();
		list = search.searchEmployee(page, username);
		Iterator iterator = list.iterator();
		if (iterator.hasNext() == false) { // 没有数据了
			page = page - 1;
			key1 = 1;

			list = search.searchEmployee(page, username);
			if(username.equals("") == false)
				request.setAttribute("username", username);
			
			request.setAttribute("down", key1);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("EmployeeManagment.jsp").forward(
					request, response);
		} else { // 分页找到数据
			if (key == 1 || page == 0) {
				request.setAttribute("up", key);
			}
			if(username.equals("") == false)
				request.setAttribute("username", username);
			
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("EmployeeManagment.jsp").forward(
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
		search_User search = new search_User();
		List<employee> list = new ArrayList<employee>();
		
		boolean tag = false;
		tag = search.searchEmployeeExit(username);
		if (tag == false) { // 不存在
			request.setAttribute("mess", "no2");
			request.getRequestDispatcher("MessageTip.jsp").forward(request,
					response);
		} else {

			list = search.searchEmployee(page, username);
			Iterator iterator = list.iterator();
			if (iterator.hasNext() == false) { // 没有数据了
				page = page - 1;
				key1 = 1;
				list = search.searchEmployee(page, username);
				if(username.equals("") == false)
					request.setAttribute("username", username);
				request.setAttribute("down", key1);
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.getRequestDispatcher("EmployeeManagment.jsp")
						.forward(request, response);
			} else { // 分页找到数据
				if (key == 1 || page == 0) {
					request.setAttribute("up", key);
				}
				if(username.equals("") == false)
					request.setAttribute("username", username);
				request.setAttribute("list", list);
				request.setAttribute("page", page);
				request.getRequestDispatcher("EmployeeManagment.jsp")
						.forward(request, response);
			}
		}
		
	}

}
