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

import com.oracle.dao.search_User;
import com.oracle.entity.employee;

public class UpdateEmployee extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getParameter("username");
		String page = (String)request.getParameter("page");
		System.out.println("用户名:"+username);
		List<employee> list = new ArrayList<employee>();
		search_User search = new search_User();
		list = search.searchEmployee1(username);
		employee employ = new employee();
		Iterator iterator = list.iterator();
		if(iterator.hasNext()){
			employ = (employee)iterator.next();
			request.setAttribute("page",page );
			request.setAttribute("employ", employ);     //资源转发
			request.getRequestDispatcher("UpdateEmployee.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		employee employ = new employee();
		employ.setUsername((String)request.getParameter("username"));
		System.out.println("员工:"+employ.getUsername());
		employ.setUserpass((String)request.getParameter("userpass"));
		System.out.println("密码:"+employ.getUserpass());
		employ.setId((String)request.getParameter("id"));
		employ.setTel((String)request.getParameter("tel"));
		employ.setRealname((String)request.getParameter("realname"));
		employ.setSalary(Float.parseFloat((String)request.getParameter("salary")));
		search_User search = new search_User();
		if(search.updateEmployeeMessage(employ) == true){
			request.setAttribute("mess", "yes2");
			request.getRequestDispatcher("MessageTip.jsp").forward(request, response);
		}else{
			response.sendRedirect("Login.jsp");
		}
	}

}
