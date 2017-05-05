package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.insert_GoodsData;

public class DeleteGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String goodsname = (String)request.getParameter("goodsname");
		String booknumber = new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("商品名称:"+booknumber);
		String page = (String)request.getParameter("page");
		insert_GoodsData delete = new insert_GoodsData();
		if(delete.delete_Goods(booknumber) == true){    //商品删除成功
			request.setAttribute("mess", "yes");
			request.setAttribute("page", page);
			request.getRequestDispatcher("UpdateGoodsMessage.jsp").forward(request, response);
		}else{   //删除失败
			request.setAttribute("mess", "no");
			request.setAttribute("page", page);
			request.getRequestDispatcher("UpdateGoodsMessage.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}
