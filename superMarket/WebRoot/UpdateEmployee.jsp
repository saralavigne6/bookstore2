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
	$("#goodsname").blur(function(){
		$.post("goods_Name_Check", {
			goodsname : $("#goodsname").val()
		}, function(data, status) {
			//$("#mytable").append(data);
			if(data=="yes"){
			alert("商品已经存在");
			}
		});
		
	});
});

</script>
<script type="text/javascript">
function check(){
	
	var price=document.getElementById("salary").value;
	
	if(((price =="")||isNaN(price)||price <=0)){
		alert("工资只能为大于0的数字");
		return false;
	}else{
		return true;
	}
}
</script>

  </head>
  
  <body>
    <!-- 添加商品项 -->
  
  <c:if test="${requestScope.message eq \"ex\" }">
  <script type="text/javascript">
  alert("商品名称已经存在");
  </script>
  </c:if>
  
  <c:if test="${requestScope.mess eq \"yes\" }">
  <script type="text/javascript">
  alert("添加商品成功");
  </script>
  </c:if>
  <c:if test="${requestScope.mess eq \"no\" }">
  <script type="text/javascript">
  alert("添加商品失败");
  </script>
  </c:if>
  <br><br>
  <div id="add_Item">
  <form action="UpdateEmployee" method="post" onSubmit="return check();">
  <table border="1" style="background:#DEDEDE" align="center">
  <tr>
  	<td align="cetner" bgcolor="#d3a4ff">
  	<center><font size="+2" color="#6F00D2">修改员工信息</font></center>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="username" value="${requestScope.employ.username }" id="username" size="50" required readonly="readonly"/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="userpass" value="${requestScope.employ.userpass }" id="username" size="50" required />
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="id" value="${requestScope.employ.id }" id="id" size="50" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="tel" value="${requestScope.employ.tel }" id="tel" size="50" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="realname" value="${requestScope.employ.realname }" id="realname" size="50" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="salary" value="${requestScope.employ.salary }" id="salary" size="50" required/>
  	</td>
  </tr>
  
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<a href="EmployeeManagment?page=${requestScope.page }&username=">>返回</a>
  	<center><input type="submit" value="修改" id="mysubmit"/>
  	
  	</center>
  	</td>
  </tr>
  </table>
  </form>
  </div>
  </body>
</html>
