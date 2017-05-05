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

import com.oracle.dao.search_Goods;
import com.oracle.entity.books;
import com.oracle.entity.goods;

public class UpdateGoodsMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page1 = (String)request.getParameter("page");
		int page = Integer.parseInt(page1);
		int key =0;
		int key1 = 0;
		if(page < 0){
			
			key = 1;
			page = 0;
		}
		search_Goods search = new search_Goods();
		List<books> list = new ArrayList<books>();
		list = search.searchAllGoods(page);
		Iterator iterator = list.iterator();
		if(iterator.hasNext()==false){    //没有数据了
			page = page-1;
			key1 = 1;
			
			list = search.searchAllGoods(page);
			request.setAttribute("down", key1);
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("UpdateGoodsMessage.jsp").forward(request, response);
		}else{   //分页找到数据
			if(key == 1 || page ==0){
				request.setAttribute("up", key);
			}
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("UpdateGoodsMessage.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
