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
    
    <title>商品查询界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/Logistics.css">
<script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
<style type="text/css">
body{
	background-image: url(images/back3.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size:100%;
	
}
#firpanel{
position:fixed;
left:10%;
top:10%;
width:1000px; 
height:400px; 
overflow:auto; 
} 
#but{
position:fixed;
top:90%;
right:15%;
}
#purchase{
width:100px;
height:40px;
background-color:#97CBFF;
}
</style>



  </head>
  
  <body>
  <form action="PurchaseComplete" method="post">
    <div id="firpanel">
    
  <table border="1" id="table1" width="800px" bordercolor="#2828FF">
  
  <c:if test="${requestScope.mess eq \"no\"}">
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
    	<a >${list.goodsname }&emsp;${list.price }￥/kg&emsp;&emsp;
    	${list.detail }
    	&emsp;&emsp;</a>
    	<img alt="图片" width="70px" height="70px" src="${list.picture }">
    	&emsp;&emsp;&emsp;
    	
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
    <c:if test="${not empty requestScope.totalMoney }">
    <div id="but">
    <a href="PurchaseGoods"><返回</a>
    &emsp;&emsp;&emsp;
    &emsp;&emsp;&emsp;
    金额:<font color="$ff0000">${requestScope.totalMoney }</font>&emsp;&emsp;订单号:${requestScope.id }
    &emsp;&emsp;
    <input type="submit" value="提交支付" id="purchase"/>
    </div>
    </c:if>
    </form>
  </body>
</html>
