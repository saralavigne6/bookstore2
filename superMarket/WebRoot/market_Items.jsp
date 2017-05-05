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
    
    <title></title>
    
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
  </head>
  
  <body>
  <!-- 添加商品项 -->
  
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
  <div id="add_Item">
  <form action="insert_NewGoods" method="post" enctype="multipart/form-data">
  <table border="1" style="background:#DEDEDE" align="center">
  <tr>
  	<td align="cetner" bgcolor="#d3a4ff">
  	<center><font size="+2" color="#6F00D2">添加商品图片</font></center>
  	</td>
  </tr>
 
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	
  	<input type="file"  size="39" name="img" id="img" placeholder="选择图片" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<a href="AddGoods.jsp"><返回</a>
  	<center><input type="submit" value="添加" id="mysubmit"/>
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
