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
left:10%;
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
  
  
  <form action="EmployeeSalesMessage" method="post">
  <div id="firpanel">
  <table border="1" width="800px" bordercolor="#2828FF">
  <tr>
  		<td align="right">
  		销售总金额(￥):${requestScope.total }
  		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  		&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
  		&emsp;
  		<input type="hidden" name="page" value="${requestScope.page }"/>
  		<input type="text" name="username" value="${requestScope.username }" id="username" placeholder="输入员工账号" required/>
  		&nbsp;
  		<input type="submit" value="查询"/>
  		</td>
  </tr>
  <tr>
    	<td align="center" >
    	<font color="#2828F">序号</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">用户名</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">销售额:￥</font>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">时间</font>
    	</td>
    </tr>
  
  <c:if test="${empty requestScope.list }">
  <tr>
  	<td align="center">
  	<font size="+2" color="#0000ff">没有员工信息!!!</font>
  	</td>
  </tr>
  </c:if>
  
    <c:if test="${not empty requestScope.list }">
    <c:forEach var="list" items="${requestScope.list }">
    <tr>
    	<td align="center" >
    	${list.id }&emsp;&emsp;&emsp;&emsp;
    	${list.username }&emsp;&emsp;&emsp;&emsp;
    	${list.salesmoney }&emsp;&emsp;&emsp;&emsp;
    	${list.dates }
    	</td>
    </tr>
    </c:forEach>
    </c:if>
    <c:if test="${not empty requestScope.page }">
    <tr>
    <td align="right">
    <c:if test="${empty requestScope.up }">
    <a href="EmployeeSalesMessage?page=${requestScope.page-1 }&username=${requestScope.username}">上一页</a>
    </c:if>
    &emsp;&emsp;
    <c:if test="${empty requestScope.down }">
    <a href="EmployeeSalesMessage?page=${requestScope.page+1 }&username=${requestScope.username}">下一页</a>
    </c:if>
    </td>
    </tr>
    </c:if>
    </table>
    </div>
    </form>
  </body>
</html>
