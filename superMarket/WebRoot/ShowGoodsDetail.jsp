<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowGoodsDetail.jsp' starting page</title>
    
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
body{
	background-image: url(images/back3.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size:100%;
	
}
#firpanel{
position:fixed;
left:30%;
top:15%;
width:40%;
height:70%;
border-color:#2828FF;
border:2px solid blue;
}
</style>
  </head>
  
  <body>
    <div id="firpanel">
    <img alt="图片" src="${requestScope.goods.picture }" width="100%" height="80%">
    <br>
    <table border="1" bordercolor="#2828FF" width="100%">
    <tr>
    <td align="center"><font color="#0000ff">商品名称</font></td>
    <td align="center"><font color="#0000ff">价格(￥)</font></td>
    <td align="center"><font color="#0000ff">商品描述</font></td>
    <td align="center"><font color="#0000ff">库存量</font></td>
    </tr>
    <tr>
    <td align="center"><font color="#6A6AFF">${requestScope.goods.goodsname }</font></td>
    <td align="center"><font color="#6A6AFF">${requestScope.goods.price }</font></td>
    <td align="center"><font color="#6A6AFF">${requestScope.goods.detail }</font></td>
    <td align="center"><font color="#6A6AFF">${requestScope.goods.total }</font></td>
    </tr>
    <tr>
    <td align="left" colspan="4"><a href="GoodsSearch"><返回</a></td>
    </tr>
    </table>
    </div>
  </body>
</html>