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
			if(session.getAttribute("username") == null){   //用户没有登录
				request.setAttribute("message", "fail1");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{   //对于已经登录的用户
				String username = (String)session.getAttribute("username");
				System.out.println("当前用户:"+username);
				List<ShopCart> list = new ArrayList<ShopCart>();
				ShopCartDao dao = new ShopCartDao();
				list = dao.searchAllShopCartBooks(username);
				if(list == null){   //该用户的购物车里还没有物品
					request.setAttribute("message", "nothing");
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}else{
					System.out.println("查询到数据");
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

		//把商品放入购物车
		HttpSession session = (HttpSession)request.getSession();
		if(session.getAttribute("username") == null){
			request.setAttribute("login", "fail");   //没有登录就把商品加入购物车
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}else{
			ShopCart cart = new ShopCart();
			ShopCartDao dao = new ShopCartDao();
			cart.setBookname((String)request.getParameter("bookname"));
			cart.setBooknumber((String)request.getParameter("booknumber"));
			cart.setPrice(Float.parseFloat(request.getParameter("price")));
			cart.setUsername((String)session.getAttribute("username"));
			cart.setCounts(1);
			//先要判定购物车中是否已经存在该物品
			if(dao.searchShopCartId(cart.getBooknumber()) == -1){   //购物车里不存在该商品
				if(dao.addBookToShopCart(cart) == true){
					request.setAttribute("success", "yes");
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}else{
					response.sendRedirect("404error.html");
				}
			}else{   //更新商品
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
