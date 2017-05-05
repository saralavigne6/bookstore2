<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
  
  <style type="text/css">
   .display {
   background:url(image/banner2.jpg);
   background-attachment:fixed;
   padding-left:450px;
   padding-top:30px;
   
   }
  
  img:hover{
 transform: scale(1.4);
}

 a{
 text-decoration:none;
 }
 
 #mysubmit{
 width:250px;
 height:35px;
 background-color:#BEBEBE;
 }
  </style>
  
  
  </head>
  
  <body>
 
  
 <!-- navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
		  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp"><h1 style="font-family:微软雅黑;"><span class="fa fa-diamond" aria-hidden="true"></span >Book Store</h1></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
		<ul class="nav navbar-nav navbar-right" >
			  <li class="active"><a href="ShowPictureHome" style=" font-family:微软雅黑;
 font-size:18px; ">主页</a></li>
			  <li><a href="regist.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">注册</a></li>
			  <li><a href="UserLogin.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">登录</a></li>
			  <li><a href="LookBooks" style=" font-family:微软雅黑;
 font-size:18px; ">购书</a></li>
			  <li><a href="AddBookToCart" style=" font-family:微软雅黑;
 font-size:18px; ">查看购物车</a></li>
			  <li><a href="LoginExit" style=" font-family:微软雅黑;
 font-size:18px; ">退出</a></li>
			  <li><a href="customer.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">登录者：${sessionScope.username}</a></li>
				
				
			</ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- navigation -->

<!-- navigation -->
<!-- banner section -->
<section class="inner-w3ls">
	<div class="container">
		<h2 class="text-center w3 w3l agileinfo wthree" style="font-family:微软雅黑">Our Books</h2>
		<p class="text-center w3 w3l agileinfo wthree" style="font-family:黑体">书籍是全人类的营养品,生活里没有书籍,就好像没有阳光;智慧里没有书籍,就好像鸟儿没有翅膀。</p>
	</div>
</section>
<!-- /banner section -->
<section class="about-w3ls">
	<div class="container">
        <!-- Intro Content -->
        <div class="row">
            <div class="col-lg-12">
				<i class="fa fa-braille" aria-hidden="true"></i>
                <h3 class="text-center" style="font-family:微软雅黑">BOOKS</h3>
                <p style="font-family:黑体">书是人类进步的阶梯,终生的伴侣,最诚挚的朋友。</p>
                <c:set var="num" value="0"></c:set>
                <c:if test="${not empty requestScope.list }">
                <c:forEach var="list" items="${requestScope.list }">
                <c:if test="${num%4 ==0 }">
                <br>
                </c:if>
                <div class="col-lg-3 col-md-3 col-sm-6">
			
			<a href="DisplayBookSession?booknumber=${list.booknumber }">
			<img src="http://localhost:8080/superMarket/${list.picture }" width="300px" height="300px" alt="" class="img-responsive">
			</a>
			
			<h4 class="text-center">${list.bookname }</h4>
			<p class="special-p1">主编：${list.author }  </p>
			<form action="AddBookToCart" method="post">
			<input type="hidden" name="booknumber" value="${list.booknumber }"/>
			<input type="hidden" name="bookname" value="${list.bookname }"/>
			<input type="hidden" name="price" value="${list.price }"/>
			<input type="submit" value="加入购物车" id="mysubmit"/>
			</form>
		</div>
		<c:set var="num" value="${num+1 }"></c:set>
                </c:forEach>
                </c:if>
                
                
                 </div>
        </div>
        <!-- /.row -->
	</div>
</section>	


 <div class="display">
  
  
   <c:set var="titles" value="${titlesBean.titles}" scope="session"/>
		<c:forEach items="${sessionScope.titles}" var="bb" varStatus="status">
		<c:if test="${status.index%3==0}">
      	<TR>
      	</c:if>
        <TD>
      
						
						<BR>
						</TD><table cellSpacing="0" cellPadding="0" width="180" background="images/bg.jpg" border="0" height="140" style="width: 447px; height: 295px">
							
							
							
							<tbody>
								<tr>
								
									<td vAlign="bottom" height="30px" style="width: 255px; text-align:center;font-family:微软雅黑;font-size:20px;"> 
									<a href="displayBookSession.jsp?id=${bb.isbn }" style="color:black;">
									${bb.title}
									</a>
									</td>
									
								</tr>
								<tr align="center">
								
									<td height="120" style="height: 200px; width: 389px">
									<a href="displayBookSession.jsp?id=${ bb.isbn}">
									<img src="images/${bb.imageFile  }" width="80" alt="${bb.title}"  style="width: 165px;text-align:center; ">
									</a>
									</td>
									
								</tr>
							</tbody>
							
							
						</table>
						
						<c:if test="${status.index%3==2}">					
						<br>						
						</c:if>
						</c:forEach>					
</div>

  </body>
</html>
