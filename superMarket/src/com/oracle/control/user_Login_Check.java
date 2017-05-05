package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.search_User;
import com.oracle.entity.admin;
import com.oracle.entity.employee;
import com.oracle.hibernate.hibernate;

public class user_Login_Check extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		employee em = new employee();
		em.setUsername((String)request.getParameter("username"));
		em.setUserpass((String)request.getParameter("userpass"));
		search_User search = new search_User();   //查找账号
		admin ad = new admin();
		ad.setUsername(em.getUsername());
		ad.setUserpass(em.getUserpass());
		if(search.search_User_Exit(em)){    //登录成功
			HttpSession session = (HttpSession)request.getSession();
			session.setAttribute("username", em.getUsername());
			session.setAttribute("role", "销售员");
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		}else if(search.search_Admin_Exit(ad)){
			HttpSession session = (HttpSession)request.getSession();
			session.setAttribute("username", ad.getUsername());
			session.setAttribute("role", "管理员");
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		}else{    //登录失败
			request.setAttribute("mess", "fail");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
