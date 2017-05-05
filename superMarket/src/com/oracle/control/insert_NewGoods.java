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

		//应保证在根目录中有此目录的存在（也就是说需要自己建立相应的文件夹） 
		String url="upload\\";    //转义字符 
		JspFactory fac=JspFactory.getDefaultFactory();
		PageContext pageContext=fac.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);
		//初始化 
		mySmartUpload.initialize(pageContext); 
		try { 

			mySmartUpload.setAllowedFilesList("bmp,jpg,tiff,gif,png,tga,exif,fpx,svg,psd,cdr,pcd,dxf,ufo,eps,ai,raw");//此处的文件格式可以根据需要自己修改 

			//上载文件 
			mySmartUpload.upload(); 

			} catch (Exception e){ 
				
			}
		try{ 
			//得到上传的文件
			com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0); 

			//如果文件获得为空
			if (myFile.isMissing()){
				response.sendRedirect("market_Items.jsp");
			} 
			//得到了上传的文件
			else{ 

			//String myFileName=myFile.getFileName(); //取得上载的文件的文件名 

			ext= myFile.getFileExt(); //取得后缀名 

			int file_size=myFile.getSize(); //取得文件的大小 

			String saveurl=""; 

			//如果文件没有超过限制上传的大小
			if(file_size<file_size_max){ 

			//更改文件名，取得当前上传时间的毫秒数值 
			Calendar calendar = Calendar.getInstance(); 
			String filename = String.valueOf(calendar.getTimeInMillis());
			ServletContext application = this.getServletContext();// 获取application
			saveurl=application.getRealPath("/")+url; 

			String filenamea="";

			//保存路径 
			saveurl+=filename+"."+ext; 
			filenamea+=filename+"."+ext; 
			System.out.println("文件名:"+filenamea);
			String filepath="upload/";
			filepath+=filenamea;
			System.out.println("filepath:"+filepath);
			//接受普通参数
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
			if(insert.insert_Goods(book)==true){   //插入数据成功
				session.removeAttribute("goods");
				request.setAttribute("mess", "yes");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			}else{   //插入数据失败
				request.setAttribute("mess", "no");
				request.getRequestDispatcher("AddGoods.jsp").forward(request, response);
			}
			
			
			//保存到后台数据库
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
