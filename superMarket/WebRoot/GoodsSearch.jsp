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

<script type="text/javascript">
$(document).ready(function() {
	$("#searchGoods").click(function(){
		$.post("GoodsSearch", {
			goodsname : $("#name").val()
		}, function(data, status) {
			//$("#mytable").append(data);
				$("#table1").append(data);
		});
		
	});
});

</script>

<script type="text/javascript">
function dealCheck(){
	if(confirm("确认处理订单?")){
		return true;
	}else{
		return false;
	}
}
function messageTip(message){
	var mess="success";
	if(message == mess){
		alert("处理成功");
		self.location.href="GoodsSearch";
	}
}
</script>
  </head>
  
  <body onload="messageTip('${requestScope.message}')">
  


  
    <div id="firpanel">
<form action="GoodsSearch" method="post">
  <table border="1" id="table1" width="800px" bordercolor="#2828FF">
  
  <tr>
  <td>订单号</td>
  <td>收货人姓名</td>
  <td>收货地址</td>
  <td>收货人电话</td>
  <td>书籍</td>
  <td>数量</td>
  <td>总价</td>
  <td>状态</td>
  <td>操作</td>
  
  </tr>
  
  <c:if test="${ empty requestScope.list }">
  <tr>
  <td colspan="8" align="center">当前没有要处理的订单</td>
  </tr>
  </c:if>
  
  <c:if test="${not empty requestScope.list }">
  <c:forEach var="list" items="${requestScope.list }">
  <tr>
  <td>${list.checkid }</td>
  <td>${list.bname }</td>
  <td>${list.address }</td>
  <td>${list.tel }</td>
  <td>${list.books }</td>
  <td>${list.member }</td>
  <td>${list.totalmoney }</td>
  <td>
  未处理
  </td>
  <td><a href="DealCheck?checkid=${list.checkid }" onclick="return dealCheck()">处理订单</a></td>
  </tr>
  </c:forEach>
  </c:if>
    </table>

    </div>
    <div id="but">
    
        </form>
    </div>
  </body>
</html>
