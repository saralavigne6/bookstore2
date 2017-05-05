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
    
    <title>订单页面</title>
    
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
padding-left:100px;
padding-top:30px;
}
.submitgo {
margin-left:270px;
font-size:20px;


}
.submitstop {
margin-left:480px;
margin-top:-62px;
}
a{
text-decoration:none;
}
</style>
<script type="text/javascript">
function messageTip(message){
	var mess="success";
	var mess1="fail";
	var mess2="fail1";
	var mess3="success1";
	var mess5="success2";
	var mess4="fail2";
	var mess6="noresult";
	if(message == mess){
		alert("更改成功!!!");
		  self.location.href="AddBookToCart";
	}else if(message == mess1){
		alert("更改失败!!!请重试");
		  self.location.href="AddBookToCart";
	}else if(message == mess2){
		alert("请先登录!!!");
		  window.location.href="UserLogin.jsp";
	}else if(message == mess3){
		alert("订单删除成功!!!");
		self.location.href="LookCheckOrder";
	}else if(message == mess4){
		alert("操作失败，请重试!!!");
		self.location.href="LookCheckOrder";
	}else if(message == mess5){
		alert("下单成功!!!");
		self.location.href="AddBookToCart";
	}else if(message == mess6){
		alert("没有订单信息!!!");
		self.location.href="AddBookToCart";
	}
}

function deleteBook(state){
	var state1 ="1";
	if(state == state1){
		alert("订单已经处理，不能取消!!!");
		return false;
	}else{
		return true;
	}
}

function updateBook(){
	if(confirm("是否要修改商品数量?")){
		return true;
	}else{
		return false;
	}
}
</script>
  </head>
  
  <body onload="messageTip('${requestScope.message}')">
  
  
  
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
  <br><br>
<section class="about-w3ls">
	<div class="container">
        <!-- Intro Content -->
        <div class="row">
            <div class="col-lg-12">
				 
                <h3 class="text-center" style="font-family:微软雅黑 ;font-size:30px;">订单详情</h3>
               
                 </div>
        </div>
        <!-- /.row -->
	</div>
</section>	


  
  
  
  <div class="content">
  
     <table cellSpacing="1" cellPadding="1" width="1090px" border="1"
     style="width: 1390px; height: 192px;border:10px solid #c4bcb1;
     font-size:23px;color:white;font-family:华文细黑;text-align:center;
     background-color:#445370;
     ">
      <thead ><tr style="text-align:center;">
         <th style="text-align:center; " >订单号</th>
         <th style="text-align:center;">收货人</th>
         <th style="height: 60px;text-align:center; ">收货地址</th>
         <th style="text-align:center;">收货电话</th>
         <th style="text-align:center;">物品</th>
         <th style="text-align:center;">数量</th>
         <th style="text-align:center;">总价</th>
         <th style="text-align:center;">状态</th>
         <th style="text-align:center;">操作</th>
      </tr></thead>
		
		<c:if test="${requestScope.message eq \"nothing\" }">
		<script type="text/javascript">
    		alert("亲，购物车里空空如也!!!");
  		</script>
  		<tr>
  			<td colspan="5" style="width: 172px; ">
  			购物车里好空哦，快去购物吧，亲
  			</td>
  		</tr>
		</c:if>
		
		
		<c:forEach var="list" items="${requestScope.list }">
         <tr>
            <td style="width: 172px; ">${list.checkid }</td>

            <td align="center" style="width: 172px; ">${list.bname }</td>
            <td align="center" style="width: 172px; ">${list.address }</td>
            <td align="center" style="width: 172px; ">${list.tel }</td>

            <td class = "right" style="width: 172px; height: 62px">
               ${list.books }
            </td>
            <td class = "right" style="width: 172px; height: 62px">
               ${list.member }
            </td>
             
            <td class = "bold right" style="width: 172px; ">
               ${list.totalmoney }
            </td>
            <td align="center" style="width: 172px; ">
            <c:if test="${list.state eq \"0\" }">未处理</c:if>
            	
            
            <c:if test="${list.state eq \"1\" }">已发货</c:if>
            	
            </td>
             <td align="center" style="width: 172px; ">
             
             <a href="DeleteBookCheck?checkid=${list.checkid }" onclick=" return deleteBook('${list.state}')" style="color:#fb980b">取消订单</a>
             </td>
         </tr>
         </c:forEach>
         
        
   </table> 
    <br>
    
   </div>
   
   
   
  </body>
</html>
