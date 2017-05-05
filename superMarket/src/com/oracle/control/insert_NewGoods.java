package com.oracle.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.oracle.dao.insert_GoodsData;
import com.oracle.entity.books;
import com.oracle.entity.goods;


public class insert_NewGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SmartUpload mySmartUpload =new SmartUpload(); 
		
		//mySmartUpload.service(request,response);
		//System.out.println(mySmartUpload.getRequest().getParameter("goodsname"));
		
		
		
		long file_size_max=4000000; 
		String fileName2="",ext="",testvar=""; 

		//Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У� 
		String url="upload\\";    //ת���ַ� 
		JspFactory fac=JspFactory.getDefaultFactory();
		PageContext pageContext=fac.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);
		//��ʼ�� 
		mySmartUpload.initialize(pageContext); 
		try { 

			mySmartUpload.setAllowedFilesList("bmp,jpg,tiff,gif,png,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw");//�˴����ļ���ʽ���Ը�����Ҫ�Լ��޸� 

			//�����ļ� 
			mySmartUpload.upload(); 

			} catch (Exception e){ 
				
			}
		try{ 
			//�õ��ϴ����ļ�
			com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0); 

			//����ļ����Ϊ��
			if (myFile.isMissing()){
				response.sendRedirect("market_Items.jsp");
			} 
			//�õ����ϴ����ļ�
			else{ 

			//String myFileName=myFile.getFileName(); //ȡ�����ص��ļ����ļ��� 

			ext= myFile.getFileExt(); //ȡ�ú�׺�� 

			int file_size=myFile.getSize(); //ȡ���ļ��Ĵ�С 

			String saveurl=""; 

			//����ļ�û�г��������ϴ��Ĵ�С
			if(file_size<file_size_max){ 

			//�����ļ�����ȡ�õ�ǰ�ϴ�ʱ��ĺ�����ֵ 
			Calendar calendar = Calendar.getInstance(); 
			String filename = String.valueOf(calendar.getTimeInMillis());
			ServletContext application = this.getServletContext();// ��ȡapplication
			saveurl=application.getRealPath("/")+url; 

			String filenamea="";

			//����·�� 
			saveurl+=filename+"."+ext; 
			filenamea+=filename+"."+ext; 
			System.out.println("�ļ���:"+filenamea);
			String filepath="upload/";
			filepath+=filenamea;
			System.out.println("filepath:"+filepath);
			//������ͨ����
			Request req = mySmartUpload.getRequest(); 
			String bt=(String)req.getParameter("mcdb_content");
			String linkurl = (String)req.getParameter("linkUrl");

			myFile.saveAs(saveurl,SmartUpload.SAVE_PHYSICAL); 

			System.out.print(filenamea); 
			
			HttpSession session = (HttpSession)request.getSession();
			books book = new books();
			book = (books)session.getAttribute("goods");
			book.setPicture(filepath);
			insert_GoodsData insert = new insert_GoodsData();
			if(insert.insert_Goods(book)==true){   //�������ݳɹ�
				session.removeAttribute("goods");
				request.setAttribute("mess", "yes");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			}else{   //��������ʧ��
				request.setAttribute("mess", "no");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			}
			
			
			//���浽��̨���ݿ�
//			good.setPicture(filepath);
//			insert_GoodsData insert = new insert_GoodsData();
//			if(insert.insert_Goods(good)==true){
//				request.setAttribute("mess", "yes");
//			}else{
//				request.setAttribute("mess", "no");
//			}
			}
			
			}



			}catch (Exception e){ 

			response.sendRedirect("404error.html");

			} 
		
	}

}
