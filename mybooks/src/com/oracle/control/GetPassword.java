package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.CustomerDao;

public class GetPassword extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String username = (String)request.getParameter("username");
			String tel = (String)request.getParameter("tel");
			
			CustomerDao cus = new CustomerDao();
			if(cus.searchCusUsernameExit(username)){    //�Ȳ鿴�û����Ƿ����
				String userpass = cus.backForgetPassword(username, tel);
				
				if(userpass.equals("") == false){   //�Ѿ��鵽������
					
					request.setAttribute("userpass", userpass);
					request.setAttribute("mess", "yes");
					request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
				}else{
					request.setAttribute("mess", "no");
					request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
				}
			}else{    //   �����ڸ��û�
				request.setAttribute("mess", "no1");
				request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
			}
		}catch(Exception e){
			response.sendRedirect("404error.html");
		}
	}

}
