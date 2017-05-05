package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.ShopCartDao;

public class DeleteBookFormCart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//删除购物车里的商品
		System.out.println("执行删除商品程序");
		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){   //用户没有登录
				request.setAttribute("message", "fail1");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{
				String booknumber = new String(request.getParameter("booknumber").
						getBytes("ISO-8859-1"),"UTF-8");   //处理中文乱码
				ShopCartDao dao = new ShopCartDao();
				int id = dao.searchShopCartId(booknumber);
				if(dao.deleteSingleShopCart(id) == true){   //成功删除单个商品
					request.setAttribute("message", "success1");
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}else{   //删除失败
					request.setAttribute("message", "fail2");
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
