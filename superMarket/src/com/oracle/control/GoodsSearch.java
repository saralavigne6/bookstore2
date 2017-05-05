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
import javax.servlet.http.HttpSession;

import com.oracle.dao.ChecksDao;
import com.oracle.dao.search_Goods;
import com.oracle.entity.checks;
import com.oracle.entity.goods;

public class GoodsSearch extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查询未完成订单
		HttpSession session = (HttpSession)request.getSession();
		if(session.getAttribute("username") == null){
			response.sendRedirect("Login.jsp");
		}else{
			List<checks> list = new ArrayList<checks>();
			ChecksDao dao = new ChecksDao();
			list = dao.searchAllNoDealChecks();
			if(list != null){
				request.setAttribute("list", list);
				request.getRequestDispatcher("GoodsSearch.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("GoodsSearch.jsp").forward(request, response);
			}
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("GoodsSearch.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
//		String goodsname = new String(request.getParameter("goodsname").getBytes("ISO-8859-1"),"UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String goodsname = (String)request.getParameter("goodsname");
		System.out.println("模糊查询结果:"+goodsname);
		List<goods> list = new ArrayList<goods>();
		search_Goods search = new search_Goods();
		list = search.fuzzySearchGoods(goodsname);
		Iterator iterator = list.iterator();
		int k =0;
		StringBuffer sb = new StringBuffer();
		while(iterator.hasNext() == true){    //模糊查询找到该商品
			k =1;
			goods good = (goods)iterator.next();
			sb.append("<tr><td align=\"center\"><a href=\"ShowGoodsDetail?goodsname="+good.getGoodsname()+"\">"
					+good.getGoodsname()+"&emsp;"+good.getPrice()+"￥/kg&emsp;&emsp;"+good.getDetail()
					+"&emsp;&emsp;库存量:"+good.getTotal()+"&emsp;&emsp;</a>"+
    	"<img alt=\"图片\" width=\"70px\" height=\"70px\" src=\""+good.getPicture()+"\" >&emsp;&emsp;&emsp;<input type=\"checkbox\" name=\"goodsname\" "+
					"id=\"goodsname\" value=\""+good.getGoodsname()+"\"/>购买</td></tr>");
		}
		
//		if(k == 0){
//			System.out.println("没有数据");
//			out.print("no");
//		}else{
			out.print(sb);
//		}
		out.flush();
		out.close();
	}

}
