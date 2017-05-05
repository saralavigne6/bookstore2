package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_Goods;
import com.oracle.entity.books;
import com.oracle.entity.goods;

public class GoodsNumberLow extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page1 = (String)request.getParameter("page");
		System.out.println("当前页数:"+page1);
		int page = Integer.parseInt(page1);
		
		int key =0;
		int key1 = 0;
		if(page < 0){
			
			key = 1;
			page = 0;
		}
		
		List<books> list = new ArrayList<books>();
		search_Goods search = new search_Goods();
		list = search.search_GoodsNumber_Low(page);
		Iterator iterator = list.iterator();
		if(iterator.hasNext() == false){    //没有商品库存告急
			page = page-1;
			key1 = 1;
			list = search.search_GoodsNumber_Low(page);
			request.setAttribute("down", key1);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("GoodsNumberLow.jsp").forward(request, response);
		}else{    //存在库存告急
			if(key == 1 || page ==0){
				request.setAttribute("up", key);
			}
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("GoodsNumberLow.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示商品库存量不足
		
		
	}

}
