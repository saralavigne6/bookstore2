package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.BooksDao;
import com.oracle.dao.ShopCartDao;
import com.oracle.entity.ShopCart;

public class MotiyBook extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//更改购物车里的商品数量
		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}
			ShopCart cart = new ShopCart();
			cart.setBookname(new String((request.getParameter("bookname")).getBytes("ISO-8859-1"),"UTF-8"));
			cart.setBooknumber(new String(request.getParameter("booknumber").getBytes("ISO-8859-1"),"UTF-8"));
			cart.setPrice(Float.parseFloat((String)request.getParameter("price")));
			cart.setCounts(Integer.parseInt((String)request.getParameter("counts")));
			cart.setUsername((String)session.getAttribute("username"));
			BooksDao dao = new BooksDao();
			String picture = dao.searchSingleBook(cart.getBooknumber()).getPicture();
			request.setAttribute("prcture", picture);
			request.setAttribute("cart", cart);
			request.getRequestDispatcher("motiyBook.jsp").forward(request, response);
//			ShopCartDao dao = new ShopCartDao();
//			if(dao.updateBooksCount(cart) == true){  //更新数据成功
//				request.setAttribute("message", "success");
//				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
//			}else{   //更新失败
//				request.setAttribute("message", "fail");
//				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
//			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}
			String booknumber = (String)request.getParameter("booknumber");
			int counts = Integer.parseInt((String)request.getParameter("counts"));
			
			ShopCartDao dao = new ShopCartDao();
			int id = dao.searchShopCartId(booknumber);
			if(dao.updateBooksCount(booknumber,counts,id) == true){  //更新数据成功
				request.setAttribute("message", "success");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{   //更新失败
				request.setAttribute("message", "fail");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

}
