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
    
    <title>购物车</title>
    
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
padding-left:300px;
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
		alert("删除成功!!!");
		self.location.href="AddBookToCart";
	}else if(message == mess4){
		alert("操作失败，请重试!!!");
		self.location.href="AddBookToCart";
	}else if(message == mess5){
		alert("下单成功!!!");
		self.location.href="AddBookToCart";
	}
}

function deleteBook(){
	if(confirm("确认删除该商品?")){
		return true;
	}else{
		return false;
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
				 
                <h3 class="text-center" style="font-family:微软雅黑 ;font-size:30px;">购物车详情</h3>
               
                 </div>
        </div>
        <!-- /.row -->
	</div>
</section>	


  
  
  
  <div class="content">
  <p><a href="LookCheckOrder"><font color="#ffffff" size="+2">查看订单</font></a></p>
     <table cellSpacing="1" cellPadding="1" width="590" border="1"
     style="width: 904px; height: 192px;border:10px solid #c4bcb1;
     font-size:23px;color:white;font-family:华文细黑;text-align:center;
     background-color:#445370;
     ">
      <thead ><tr style="text-align:center;">
         <th style="text-align:center; " >书籍名称</th>
         <th style="text-align:center;">数量</th>
         <th style="height: 60px;text-align:center; ">价格</th>
         <th style="text-align:center;">小计</th>
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
		
		<c:if test="${requestScope.message eq \"yes\" }">
		<c:forEach var="list" items="${requestScope.list }">
         <tr>
            <td style="width: 172px; ">${list.bookname }</td>

            <td align="center" style="width: 172px; ">${list.counts }</td>

            <td class = "right" style="width: 172px; height: 62px">
               ${list.price }
            </td>

            <td class = "bold right" style="width: 172px; ">
               ${list.totalMoney }
            </td>
             <td align="center" style="width: 172px; ">
             <a href="MotiyBook?booknumber=${list.booknumber }&price=${list.price}&bookname=${list.bookname}&counts=${list.counts}" onclick="return updateBook()" style="color:#fb980b">修改</a>
             <a href="DeleteBookFormCart?booknumber=${list.booknumber }" onclick=" return deleteBook()" style="color:#fb980b">删除</a>
             </td>
         </tr>
         </c:forEach>
         </c:if>
        <tr>
         <td colspan = "5" class = "bold right" style="height: 58px; "><b>总计：${requestScope.totalMoney }  </b>
            
         </td>
      </tr>
   </table> 
    <br>
    
   <form method = "get" action = "LookBooks" class="submitgo">
      <p><input type = "submit" value = "继续购物" style="width: 166px; height: 42px;
      font-family:微软雅黑;background-color:#d24747;color:white;border:none;font-size:17px;"/></p>
   </form>
    <form method = "get" action = "order.jsp" class="submitstop">
    <input type="hidden" name="totalMoney" value="${requestScope.totalMoney }"/>  <!-- 总金 -->
      <p><input type = "submit" value = "结 账" style="width: 166px; height: 42px;
      font-family:微软雅黑;background-color:#d24747;color:white;border:none;font-size:17px;"/></p>
   </form>
   
   </div>
   
   
   
  </body>
</html>
