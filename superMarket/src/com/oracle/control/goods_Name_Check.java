package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.search_Goods;

public class goods_Name_Check extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String booknumber=(String)request.getParameter("booknumber");
		System.out.println("����:"+booknumber);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		search_Goods search = new search_Goods();
		if(search.search_GoodsName_Exit(booknumber.trim())){   //��������Ѿ�����
			out.print("yes");
		}else{     //��Ʒ��������,��������
			out.print("no");
		}
		
		
		out.flush();
		out.close();
	}

}
