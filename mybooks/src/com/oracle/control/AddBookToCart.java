package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oracle.dao.ShopCartDao;
import com.oracle.entity.ShopCart;

public class AddBookToCart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){   //�û�û�е�¼
				request.setAttribute("message", "fail1");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{   //�����Ѿ���¼���û�
				String username = (String)session.getAttribute("username");
				System.out.println("��ǰ�û�:"+username);
				List<ShopCart> list = new ArrayList<ShopCart>();
				ShopCartDao dao = new ShopCartDao();
				list = dao.searchAllShopCartBooks(username);
				if(list == null){   //���û��Ĺ��ﳵ�ﻹû����Ʒ
					request.setAttribute("message", "nothing");
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}else{
					System.out.println("��ѯ������");
					float totalMoney = 0.0f;
					List<ShopCart> list1 = new ArrayList<ShopCart>();
					for (ShopCart shop : list) {
						list1.add(shop);
						shop.setTotalMoney(shop.getCounts()*shop.getPrice());
						totalMoney+=shop.getTotalMoney();
					}
					request.setAttribute("message", "yes");
					request.setAttribute("list", list);
					request.setAttribute("totalMoney", totalMoney);
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����Ʒ���빺�ﳵ
		HttpSession session = (HttpSession)request.getSession();
		if(session.getAttribute("username") == null){
			request.setAttribute("login", "fail");   //û�е�¼�Ͱ���Ʒ���빺�ﳵ
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}else{
			ShopCart cart = new ShopCart();
			ShopCartDao dao = new ShopCartDao();
			cart.setBookname((String)request.getParameter("bookname"));
			cart.setBooknumber((String)request.getParameter("booknumber"));
			cart.setPrice(Float.parseFloat(request.getParameter("price")));
			cart.setUsername((String)session.getAttribute("username"));
			cart.setCounts(1);
			//��Ҫ�ж����ﳵ���Ƿ��Ѿ����ڸ���Ʒ
			if(dao.searchShopCartId(cart.getBooknumber()) == -1){   //���ﳵ�ﲻ���ڸ���Ʒ
				if(dao.addBookToShopCart(cart) == true){
					request.setAttribute("success", "yes");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}else{
					response.sendRedirect("404error.html");
				}
			}else{   //������Ʒ
				int id = dao.searchShopCartId(cart.getBooknumber());
				if(dao.updateBooksCount1(cart.getBooknumber(), cart.getCounts(), id) == true){
					request.setAttribute("success", "yes");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}else{
					response.sendRedirect("404error.html");
				}
			}
		}
	}

}
