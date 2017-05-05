<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
<style type="text/css">
body{
	background-image: url(images/back3.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	background-size:100%;
	
}
input{
background-color:#FFBFFF;
height:30px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#username").blur(function(){
		$.post("EmployeeUsernameCheck", {
			username : $("#username").val()
		}, function(data, status) {
			//$("#mytable").append(data);
			if(data=="yes"){
			alert("用户名已经存在");
			}
		});
		
	});
});

</script>
<script type="text/javascript">
function check(){
	
	var salary=document.getElementById("salary").value;
	if(((salary =="")||isNaN(salary)||salary <=0)){
		alert("工资数据不合法");
		return false;
	}else{
		return true;
	}
}
</script>

  </head>
  
  <body>
    <!-- 添加商品项 -->
  
  <c:if test="${requestScope.mess eq \"ex\" }">
  <script type="text/javascript">
  alert("用户名已存在");
  </script>
  </c:if>
  
  <c:if test="${requestScope.mess eq \"yes\" }">
  <script type="text/javascript">
  alert("成功雇佣");
  </script>
  </c:if>
  <c:if test="${requestScope.mess eq \"no\" }">
  <script type="text/javascript">
  alert("雇佣失败,请重试");
  </script>
  </c:if>
  <div id="add_Item">
  <br><br>
  <form action="AddEmployee" method="post" onSubmit="return check();">
  <table border="1" style="background:#DEDEDE" align="center">
  <tr>
  	<td align="cetner" bgcolor="#d3a4ff">
  	<center><font size="+2" color="#6F00D2">新增员工</font></center>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="username"  id="username" size="50" placeholder="员工账号" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="userpass"  id="userpass" size="50" placeholder="员工密码" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="id"  id="id" size="50" placeholder="员工编码" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="tel"  id="tel" size="50" placeholder="员工电话" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="realname"  id="realname" size="50" placeholder="员工姓名" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="salary"  id="salary" size="50" placeholder="员工工资" required/>
  	</td>
  </tr>
  
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<center><input type="submit" value="聘用" id="mysubmit"/>
  	&emsp;&emsp;&emsp;
  	<input type="reset" value="重置"/>
  	</center>
  	</td>
  </tr>
  </table>
  </form>
  </div>
  </body>
</html>
