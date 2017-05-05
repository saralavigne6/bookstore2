<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>顶部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/Logistics.css">
	<style type="text/css">
	#tit{
	margin:0 auto;
	margin-left:40%;
	}
	body{
	background-image: url(images/top3.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size:100%;
	}
	#top1{
	position:fixed;
	left:0%;
	top:80%;
	}
	</style>
  </head>
  
  <body>
  <c:if test="${empty sessionScope.username }">
<script type="text/javascript">
alert("请先登录!!!");
self.location.href="Login.jsp";
</script>
</c:if>
  <div id="tit">
  <br>
  <font size="+4" color="#000000">购书管理后台</font>
  </div>
  <div id="top1">
  OPERATOR:<font color="#0000ff">${sessionScope.username }</font>
  </div>
  </body>
</html>
