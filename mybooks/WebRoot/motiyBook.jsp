<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更改商品</title>
    
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
  .content {
  background:url(image/banner3.jpg);
background-attachment:fixed;
height:500px;
width:1550px;
padding-left:370px;
padding-top:30px;
  }
  
  a{
  text-decoration:none;
  }
  
  </style>
  
  <script type="text/javascript">
  function checkCounts(){
	  var counts = document.getElementById("number").value;
	  if(isNaN(counts) == true){
		  alert("商品数量只能为数字"); //isNaN(counts) == true 商品数量只能是大于等于1的整数
		  return false;
	  }else if(parseInt(counts) <=0 || counts%1 !=0){
		  alert("商品数量只能是大于等于1的整数");
		  return false;
	  }else{
		  return true;
	  }
  }
  </script>
  
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
			  <li class="active"><a href="home.html" style=" font-family:微软雅黑;
 font-size:18px; ">主页</a></li>
			  <li><a href="regist.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">注册</a></li>
			  <li><a href="Login.html" style=" font-family:微软雅黑;
 font-size:18px; ">登录</a></li>
			  <li><a href="books.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">购书</a></li>
			  <li><a href="AddBookToCart" style=" font-family:微软雅黑;
 font-size:18px; ">查看购物车</a></li>
			  <li><a href="LoginExit" style=" font-family:微软雅黑;
 font-size:18px; ">退出</a></li>
			  <li><a href="books.jsp" style=" font-family:微软雅黑;
 font-size:18px; ">登录者：${sessionScope.username}</a></li>
				
				
			</ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!--/navigation -->
  <br><br>
<section class="about-w3ls">
	<div class="container">
        <!-- Intro Content -->
        <div class="row">
            <div class="col-lg-12">
				 
                <h3 class="text-center" style="font-family:微软雅黑 ;font-size:30px;">修改购物数量</h3>
               
                 </div>
        </div>
        <!-- /.row -->
	</div>
</section>	
  
  <div class="content">
    <form action="MotiyBook" method="post" onSubmit="return checkCounts()">
									<TABLE style="TEXT-ALIGN: center;background-color:#2b2d41;
									color:white;font-family:黑体;font-size:20px;border:10px solid #c4bcb1;" 
										cellSpacing="1" cellPadding="1" width="590" border="1">
										<TBODY>
											<tr height="80" style="background-color: rgba(0, 0, 0, 0.2);color:#d24747;">
												<td colspan="3">
												<h2>MODIFY COUNT</h2>
												</td>
											</tr>
											
											<tr>
											
												<!-- create table cell for product image -->
												<td rowspan="5" width="200px" height="270px;"><!-- cell spans 5 rows -->
													<img
														style="border: thin solid black"
														src="http://localhost:8080/superMarket/${prcture }" alt="" width="300px" height="300px" />
												</td>

												<!-- create table cells for price in row 1 -->
												<td class="bold" align="center" height="40px" style="width: 187px; ">
													
													<input type="hidden" name="booknumber" value="${requestScope.cart.booknumber }"/>
												</td>

												<td align="center"  height="40px" align="center">
													图书编号：${requestScope.cart.booknumber }
													<input type="hidden" name="booknumber" value="${requestScope.cart.booknumber }"/>
												</td>
											</tr>

											<tr align="center" >

												<!-- create table cells for ISBN in row 2 -->
												<td class="bold"  align="center"  height="40px">
													价格：
												</td>

												<td  align="center"  height="40px" align="center">
													${requestScope.cart.price }
													<input type="hidden" name="price" value="${requestScope.cart.price }"/>
												</td>
												
											</tr>

											<tr  align="center">

												<!-- create table cells for edition in row 3 -->
												<td class="bold"  height="40px">
													书名：
												</td>

												<td align="center"  height="40px" align="center">
												${requestScope.cart.bookname }
												<input type="hidden" name="bookname" value="${requestScope.cart.bookname }"/>
												</td>
											</tr>

											
											<tr align="center">
												<td class="bold"  height="40px">数量：</td>
												<td align="center">
												 <input type="text" id="number" name="counts" size="4" value="${requestScope.cart.counts }" 
												 style="width: 66px;color:black; "/>
												</td>
												
												
											</tr>

											<tr align="center">
												<!-- create Add to Cart button in row 5 -->
												<td align="left" style="height: 80px;background-color: rgba(0, 0, 0, 0.2);">
													<a href="AddBookToCart">back</a>
												</td>

												<!-- create View Cart button in row 5 -->
												<%
												
												
												 %>
												<td colspan="2" style="height: 80px;background-color: rgba(0, 0, 0, 0.2);">
													<div align="center">
													
       												<input type="submit" name="Submit" value="修 改" 
       												style="height: 35px; 
															background-color:#d24747;border-style:none;border-color:#d24747;font-family:微软雅黑;
															color:white;font-size:15px; width: 155px"
       												/>
       												<input type="hidden" name="isbn" value="">
      												</div>
												</td>
											</tr>
										</TBODY>
									</TABLE>
									</form>
</div>
									
									
  </body>
</html>
