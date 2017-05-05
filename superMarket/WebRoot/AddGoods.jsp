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
	$("#booknumber").blur(function(){
		$.post("goods_Name_Check", {
			booknumber : $("#booknumber").val()
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
	var goodsname=document.getElementById("booknumber").value;
	var price=document.getElementById("price").value;
	var total=document.getElementById("total").value;
	if((goodsname =="") || ((price =="")||isNaN(price)||price <=0) ||(isNaN(total) || parseInt(total)<=0)){
		alert("数据格式错误");
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
  <div id="add_Item">
  <br><br>
  <form action="AddGoods" method="post" onSubmit="return check();">
  <table border="1" style="background:#DEDEDE" align="center">
  <tr>
  	<td align="cetner" bgcolor="#d3a4ff">
  	<center><font size="+2" color="#6F00D2">添加书籍</font></center>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="bookname" value="${sessionScope.goods.bookname }" id="bookname" size="50" placeholder="书名" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="booknumber" value="${sessionScope.goods.booknumber }" id="booknumber" size="50" placeholder="图书编号" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="price" value="${sessionScope.goods.price }" id="price" size="50" placeholder="商品价格" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="author" value="${sessionScope.goods.author }" id="author" size="50" placeholder="作者" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="copyright" value="${sessionScope.goods.copyright }" id="copyright" size="50" placeholder="版权" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="detail" value="${sessionScope.goods.detail }" id="detail" size="50" placeholder="书名描述" />
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="total" value="${sessionScope.goods.total }" id="total" size="50" placeholder="库存量" required/>
  	</td>
  </tr>
  
  
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
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
