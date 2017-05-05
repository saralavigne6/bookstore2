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

import com.oracle.check.CheckId;
import com.oracle.dao.ChecksDao;
import com.oracle.dao.ShopCartDao;
import com.oracle.entity.ShopCart;
import com.oracle.entity.checks;

public class ProcessOrder extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			//处理提交的订单
			checks check = new checks();
			HttpSession session = (HttpSession)request.getSession();
			CheckId id = new CheckId();
			check.setCheckid(id.CreateOrder());
			System.out.println("订单号:"+check.getCheckid());
			check.setUsername((String)session.getAttribute("username"));
			check.setBname((String)request.getParameter("name"));
			check.setAddress((String)request.getParameter("address"));
			check.setTel((String)request.getParameter("tel"));
			String username = (String)session.getAttribute("username");
			List<ShopCart> list = new ArrayList<ShopCart>();
			List<ShopCart> list1 = new ArrayList<ShopCart>();
			ShopCartDao dao = new ShopCartDao();
			list = dao.searchAllShopCartBooks(username);
			System.out.println("物品数量:"+list.size());
			//查询出的商品全部加入订单中,然互再依次删除购物车中的物品
			for (ShopCart cart : list) {    //
				list1.add(cart);  //复制集合list
				check.setBooks(check.getBooks()+","+cart.getBookname());   //获取商品名称
				check.setMember(check.getMember()+","+cart.getCounts());  //获取商品数量
				check.setTotalmoney(check.getTotalmoney()+cart.getCounts()*cart.getPrice());  //设置总价
			}
			ChecksDao ch = new ChecksDao();
			ch.addNewChecks(check);
			for (ShopCart Cart : list1) {    //依次删除购物车里所有商品
				dao.deleteSingleShopCart(Cart.getId());
			}
			request.setAttribute("message", "success2");
			request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
		
	}

}
