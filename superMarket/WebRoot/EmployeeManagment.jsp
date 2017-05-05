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
function deleteEmployee(username,page){
	if(confirm("确认解聘该员工?") == true){
		self.location.href="DeleteEmployee?page="+page+"&username="+username;
		return true;
	}else{
		self.location.href="EmployeeManagment?page="+page+"&username=";
		return false;
	}
}

</script>
  </head>
  
  <body>
  
  
  <form action="EmployeeManagment" method="post">
  <div id="firpanel">
  <table border="1" width="800px" bordercolor="#2828FF">
  <tr>
  		<td align="right">
  		
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
    	<font color="#2828F">用户名</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">密码</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">员工编号</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">电话号码</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">姓名</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">工资:￥</font>&emsp;&emsp;&emsp;&emsp;
    	<font color="#2828F">操作</font>
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
    	${list.username }&emsp;&emsp;
    	${list.userpass }&emsp;&emsp;
    	${list.id }&emsp;&emsp;
    	${list.tel }&emsp;&emsp;
    	${list.realname }&emsp;&emsp;
    	${list.salary }&emsp;&emsp;
    	<a href="UpdateEmployee?page=${requestScope.page}&username=${list.username }">更改</a>&emsp;
    	<a href="DeleteEmployee?page=${requestScope.page}&username=${list.username }" >解聘</a>
    	</td>
    </tr>
    </c:forEach>
    </c:if>
    <c:if test="${not empty requestScope.page }">
    <tr>
    <td align="right">
    <c:if test="${empty requestScope.up }">
    <a href="EmployeeManagment?page=${requestScope.page-1 }&username=${requestScope.username}">上一页</a>
    </c:if>
    &emsp;&emsp;
    <c:if test="${empty requestScope.down }">
    <a href="EmployeeManagment?page=${requestScope.page+1 }&username=${requestScope.username}">下一页</a>
    </c:if>
    </td>
    </tr>
    </c:if>
    </table>
    </div>
    </form>
  </body>
</html>
