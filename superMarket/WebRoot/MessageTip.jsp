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
    
    <title>信息提示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function Tip(mess,page){
	var message = "yes1";
	var message1 = "no";
	var messa = "no1";
	var messag = "no2";
	var message2 = "yes2";
	var message3 = "del";
	var message4 = "nodel";
	if(mess == message){
		alert("谢谢惠顾");
		self.location.href="PurchaseGoods";
	}else if(mess == message1){
		alert("请选择商品");
		self.location.href="PurchaseGoods";
	}else if(mess == messa){
		alert("该员工不存在销售记录");
		self.location.href="EmployeeSalesMessage?page=0";
	}else if(mess == messag){
		alert("该员工账号不存在");
		self.location.href="EmployeeManagment?page=0";
	}else if(mess == message2){
		alert("员工信息更改成功");
		self.location.href="EmployeeManagment?page=0&username=";
	}else if(mess == message3){
		alert("成功解聘员工");
		self.location.href="EmployeeManagment?page="+page+"&username=";
	}else if(mess == message4){
		alert("操作失败，请重试");
		self.location.href="EmployeeManagment?page="+page+"&username=";
	}else{
		alert("请先登录");
		parent.location.href="Login.jsp";
	}
}

</script>
  </head>
  
  <body onload="Tip('${requestScope.mess}','${requestScope.page }')">
  </body>
</html>
