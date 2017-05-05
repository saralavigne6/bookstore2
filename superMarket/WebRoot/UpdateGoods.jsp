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
    
    <title>修改商品信息</title>
    
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
input{
background-color:#FFBFFF;
height:30px;
}
</style>

<script type="text/javascript">
function check(){
	var goodsname=document.getElementById("goodsname").value;
	var price=document.getElementById("price").value;
	var total=document.getElementById("total").value;
	if(((price =="")||isNaN(price)||price <=0) ||(isNaN(total) || parseInt(total)<=0)){
		alert("数据格式错误");
		return false;
	}else{
		return true;
	}
}
</script>

  </head>
  
  <body>
    <c:if test="${requestScope.message eq \"ex\" }">
  <script type="text/javascript">
  alert("商品名称已经存在");
  </script>
  </c:if>
  
  <c:if test="${requestScope.mess eq \"yes\" }">
  <script type="text/javascript">
  alert("修改商品成功");
  </script>
  </c:if>
  <c:if test="${requestScope.mess eq \"no\" }">
  <script type="text/javascript">
  alert("修改商品失败");
  </script>
  </c:if>
  <div id="add_Item">
  <form action="UpdateGoods" method="post" onSubmit="return check();">
  <table border="1" style="background:#DEDEDE" align="center">
  <tr>
  	<td align="cetner" bgcolor="#d3a4ff">
  	<center><font size="+2" color="#6F00D2">修改商品</font></center>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="goodsname" value="${requestScope.goods.bookname }" id="goodsname" size="50" placeholder="图书名称" readonly="readonly" required/>
  	<input type="hidden" name="picture" value="${requestScope.goods.picture }"/>
  	<input type="hidden" name="booknumber" value="${requestScope.goods.booknumber }"/>
  	<input type="hidden" name="author" value="${requestScope.goods.author }"/>
  	<input type="hidden" name="copyright" value="${requestScope.goods.copyright }"/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="price" value="${requestScope.goods.price }" id="price" size="50" placeholder="图书价格" required/>
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="detail" value="${requestScope.goods.detail }" id="detail" size="50" placeholder="图书描述" />
  	</td>
  </tr>
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<input type="text" name="total" value="${requestScope.goods.total }" id="total" size="50" placeholder="库存量" required/>
  	</td>
  </tr>
  
  <tr>
  	<td align="cetner"  bgcolor="#d3a4ff">
  	<a href="UpdateGoodsMessage?page=${requestScope.page }"><返回</a>
  	<center><input type="submit" value="修改" id="mysubmit"/>
  	
  	</center>
  	</td>
  </tr>
  </table>
  </form>
  </div>
  </body>
</html>
