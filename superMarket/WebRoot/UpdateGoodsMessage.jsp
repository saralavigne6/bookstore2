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
    
    <title>My JSP 'UpdateGoodsMessage.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
left:1%;
top:10%;
}
</style>
<script type="text/javascript">
function deleteGoods(goodsname,page){
	if(confirm("确认下架该商品?") == true){
		//self.location.href="DeleteGoods?goodsname="+goodsname+"&page="+page;
		return true;
	}else{
		//self.location.href="UpdateGoodsMessage?page="+page;
		return false;
	}
}
</script>
  </head>
  
  <body>
  
  <c:if test="${requestScope.mess eq \"yes\"}">
  
  <script type="text/javascript">
  alert("成功删除商品,请继续");
  self.location.href="UpdateGoodsMessage?page="+${requestScope.page}+"";
  </script>
  </c:if>
  
  <c:if test="${requestScope.mess eq \"no\"}">
  
  <script type="text/javascript">
  alert("删除商品失败,请继续");
  self.location.href="UpdateGoodsMessage?page="+${requestScope.page}+"";
  </script>
  </c:if>
  
  <div id="firpanel">
  <table border="1" width="1000px" bordercolor="#2828FF">
  <c:if test="${empty requestScope.list }">
  <tr>
  	<td align="center">
  	<font size="+2" color="#0000ff">没有商品!!!</font>
  	</td>
  </tr>
  </c:if>
  
    <c:if test="${not empty requestScope.list }">
    <c:forEach var="list" items="${requestScope.list }">
    <tr>
    	<td align="center" >
    	<a href="ShowGoods?goodsname=${list.booknumber }&page=${requestScope.page}">${list.bookname }&emsp;${list.booknumber }&emsp;${list.price }￥&emsp;
    	${list.author }&emsp;${list.copyright }&emsp;
    	${list.detail }
    	&emsp;&emsp;库存量:${list.total }&emsp;&emsp;</a>
    	<img alt="图片" width="70px" height="70px" src="${list.picture }">
    	&emsp;&emsp;&emsp;
    	<a href="UpdateGoods?goodsname=${list.booknumber }&page=${requestScope.page}" >商品更改</a>
    	&emsp;
    	<a href="DeleteGoods?goodsname=${list.booknumber }&page=${requestScope.page}" onclick="return deleteGoods('${list.bookname}','${requestScope.page }');">商品下架</a>
    	</td>
    </tr>
    </c:forEach>
    </c:if>
    <c:if test="${not empty requestScope.page }">
    <tr>
    <td align="right">
    <c:if test="${empty requestScope.up }">
    <a href="UpdateGoodsMessage?page=${requestScope.page-1 }">上一页</a>
    </c:if>
    &emsp;&emsp;
    <c:if test="${empty requestScope.down }">
    <a href="UpdateGoodsMessage?page=${requestScope.page+1 }">下一页</a>
    </c:if>
    </td>
    </tr>
    </c:if>
    </table>
    </div>
  </body>
</html>
