<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购书网站</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
 
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
 <style type="text/css">
 .img-responsive:hover {
 transform: scale(1.9);
 }
 </style>
<script type="text/javascript">
function messageTip1(message){
	
	var mess="yes";
	if(message == mess){
		alert("成功加入购物车!!!");
		self.location.href="LookBooks";
	}
	
}
</script>
</head>
<body onLoad="messageTip1('${requestScope.success}')">

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
<!-- banner section -->
<section class="banner-w3ls">
	<div class="header">
		<div class="banner-w3layouts">
			<div class="container">
				<h2 class="text-center w3 w3l agileinfo" style="font-family:微软雅黑;">Reading Make A Full Man.</h2>	
				<p class="text-center w3 w3l agileinfo" style="font-family:微软雅黑;">阅读使人充实</p>
			</div>
		</div>
	</div>
</section>
<!-- /banner section -->
<!-- specialization section -->
<section class="special-w3layouts">
	<div class="container">
		<h3 class="text-center wthree w3-agileits">Our Books</h3>
		<p class="text-center wthree w3-agileits">学习使我快乐，看书使我快乐</p>
		<c:if test="${not empty requestScope.list }">
		<c:forEach var="list" items="${requestScope.list }">
		<div class="col-lg-3 col-md-3 col-sm-6">
			
			<a href="DisplayBookSession?booknumber=${list.booknumber }">
			<img src="http://localhost:8080/superMarket/${list.picture }" alt="" class="img-responsive">
			</a>
			
			<h4 class="text-center">${list.bookname }</h4>
			<p class="special-p1">主编：${list.author }  </p>
		</div>
		</c:forEach>
		</c:if>
		<div class="clearfix"></div>
	</div>
</section>
<!-- /specialization section -->
<!-- 2nd banner section -->
<section class="banner-w3ls2">
	<div class="container">
		<h3 class="text-center agileits-w3layouts agile w3-agile" style="font-family:微软雅黑;">Do You Like Reading?</h3>
	</div>
</section>
<!-- /2nd banner section -->
<!-- 2nd info section -->
<section class="info-w3ls2">
	<div class="container">
		<i class="fa fa-trophy" aria-hidden="true"></i>
		<h3 class="text-center agileits-w3layouts agile w3-agile" style="font-family:微软雅黑;font-size:30px;"> Friends may betray you, while books are always loyal.</h3>
		<p class="text-center">我扑在书籍上,就好像饥饿的人扑在面包上</p>
	</div>
</section>
<!-- /2nd info section -->
<!-- 3rd banner section -->
<section class="banner-w3ls3">
	<div class="container">
		<h3 class="text-center" style="font-family:微软雅黑;">Making You Satisfied</h3>
	</div>
</section>
<!-- /3rd banner section -->
<!-- 3rd info section -->
<section class="info-w3ls3">
	<div class="container">
		<i class="fa fa-smile-o" aria-hidden="true"></i>
		<h3 class="text-center" style="font-family:微软雅黑;">Making Yourself at Home</h3>
		<p class="text-center">读书使人快乐</p>
	</div>
</section>
<!-- /3rd info section -->


<a href="#0" class="cd-top">Top</a>
<!-- js files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script src="js/index.js"></script>
<script src="js/top.js"></script> 
<script src="js/bgfader.js"></script>
<script>
var myBgFader = $('.header').bgfader([
  'image/banner1-1.jpg',
  'image/banner1-2.jpg',
  'image/banner1-3.jpg',
  'image/banner1-4.jpg',
], {
  'timeout': 2000,
  'speed': 3000,
  'opacity': 0.4
})

myBgFader.start()
</script>
 
  </body>
</html>
