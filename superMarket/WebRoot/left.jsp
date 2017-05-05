<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>操作页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/Logistics.css">
<script src="SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>
<script src="SpryAssets/SpryAccordion.js" type="text/javascript"></script>
<link href="SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet"
	type="text/css">
<link href="SpryAssets/SpryAccordion.css" rel="stylesheet"
	type="text/css">
<style>
body {
	background-image: url(images/left1.jpg);
	background-position: 0px 0px;
	background-repeat: no-repeat;
	
}

a {
	text-decoration: none;
}

a:link{
	color:#0000ff;
}
a:visited{
	color:#0000ff;
}
a:hover{
	color:#ff0000;
}
</style>
<script type="text/javascript">
function exitSystem(){
alert("成功退出系统");
windows.location.href="destory_User_Login_Message?message=vasdvnonavnvd";
}
</script>
</head>

<body>
<c:if test="${empty sessionScope.username }">
<script type="text/javascript">
alert("请先登录!!!");
self.location.href="Login.jsp";
</script>
</c:if>
	<div id="Accordion1" class="Accordion" tabindex="0">
	<c:if test="${not empty sessionScope.username }">
		<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;商&nbsp;品&nbsp;维&nbsp;护</font>
			</div>
			<div class="AccordionPanelContent">
				<a href="AddGoods.jsp" target="right"><font size="+1"
					color="#000000">&nbsp;&nbsp;&nbsp;添加商品</font></a><br> <a
					href="UpdateGoodsMessage?page=0" target="right"><font size="+1"
					color="#000000">&nbsp;&nbsp;&nbsp;更改商品</font></a><br> <a href="GoodsNumberLow?page=0"
					target="right"><font size="+1" color="#000000">&nbsp;&nbsp;&nbsp;库存告急</font></a><br>
					
			</div>
		</div>
		</c:if>
		<c:if test="${ not empty sessionScope.username }">
		<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;账&nbsp;单&nbsp;管&nbsp;理</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="GoodsSearch" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;订单处理</font></a><br>
			<a href="CompleteCheck" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;完成订单</font></a><br>
			
			
			</div>
			</div>
			</c:if>
			
			<c:if test="${not empty sessionScope.username and sessionScope.role eq \"管理员\"}">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;销&nbsp;售&nbsp;管&nbsp;理</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="EmployeeSalesMessage?page=0&username=" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;销售业绩</font></a><br>
			
			</div>
			</div>
			</c:if>
			
			<c:if test="${not empty sessionScope.username and sessionScope.role eq \"管理员\"}">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;员&nbsp;工&nbsp;管&nbsp;理</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="EmployeeManagment?page=0&username=" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;账号管理</font></a><br>
			<a href="AddEmployee.jsp" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;新增员工</font></a><br>
			</div>
			</div>
			</c:if>
			
			<c:if test="${ not empty sessionScope.username }">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;安&nbsp;全&nbsp;退&nbsp;出</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="ExitSystem" target="_parent"><font size="+1" color="#000000">&nbsp;&nbsp;退出系统</font></a><br>
			
			</div>
			</div>
			</c:if>
			
		</div>
		
	</div>
	<script type="text/javascript">
		var Accordion1 = new Spry.Widget.Accordion("Accordion1");
	</script>
</body>
</html>
