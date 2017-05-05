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
		//ɾ�����ﳵ�����Ʒ
		System.out.println("ִ��ɾ����Ʒ����");
		try{
			HttpSession session = (HttpSession)request.getSession();
			if(session.getAttribute("username") == null){   //�û�û�е�¼
				request.setAttribute("message", "fail1");
				request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
			}else{
				String booknumber = new String(request.getParameter("booknumber").
						getBytes("ISO-8859-1"),"UTF-8");   //������������
				ShopCartDao dao = new ShopCartDao();
				int id = dao.searchShopCartId(booknumber);
				if(dao.deleteSingleShopCart(id) == true){   //�ɹ�ɾ��������Ʒ
					request.setAttribute("message", "success1");
					request.getRequestDispatcher("viewCartUpdate.jsp").forward(request, response);
				}else{   //ɾ��ʧ��
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
