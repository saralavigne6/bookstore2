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

<title>����ҳ��</title>

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
alert("�ɹ��˳�ϵͳ");
windows.location.href="destory_User_Login_Message?message=vasdvnonavnvd";
}
</script>
</head>

<body>
<c:if test="${empty sessionScope.username }">
<script type="text/javascript">
alert("���ȵ�¼!!!");
self.location.href="Login.jsp";
</script>
</c:if>
	<div id="Accordion1" class="Accordion" tabindex="0">
	<c:if test="${not empty sessionScope.username }">
		<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;��&nbsp;Ʒ&nbsp;ά&nbsp;��</font>
			</div>
			<div class="AccordionPanelContent">
				<a href="AddGoods.jsp" target="right"><font size="+1"
					color="#000000">&nbsp;&nbsp;&nbsp;�����Ʒ</font></a><br> <a
					href="UpdateGoodsMessage?page=0" target="right"><font size="+1"
					color="#000000">&nbsp;&nbsp;&nbsp;������Ʒ</font></a><br> <a href="GoodsNumberLow?page=0"
					target="right"><font size="+1" color="#000000">&nbsp;&nbsp;&nbsp;���漱</font></a><br>
					
			</div>
		</div>
		</c:if>
		<c:if test="${ not empty sessionScope.username }">
		<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;��&nbsp;��&nbsp;��&nbsp;��</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="GoodsSearch" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;��������</font></a><br>
			<a href="CompleteCheck" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;��ɶ���</font></a><br>
			
			
			</div>
			</div>
			</c:if>
			
			<c:if test="${not empty sessionScope.username and sessionScope.role eq \"����Ա\"}">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;��&nbsp;��&nbsp;��&nbsp;��</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="EmployeeSalesMessage?page=0&username=" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;����ҵ��</font></a><br>
			
			</div>
			</div>
			</c:if>
			
			<c:if test="${not empty sessionScope.username and sessionScope.role eq \"����Ա\"}">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;Ա&nbsp;��&nbsp;��&nbsp;��</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="EmployeeManagment?page=0&username=" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;�˺Ź���</font></a><br>
			<a href="AddEmployee.jsp" target="right"><font size="+1" color="#000000">&nbsp;&nbsp;����Ա��</font></a><br>
			</div>
			</div>
			</c:if>
			
			<c:if test="${ not empty sessionScope.username }">
			<div class="AccordionPanel">
			<div class="AccordionPanelTab">
				<font size="+1">&nbsp;&nbsp;��&nbsp;ȫ&nbsp;��&nbsp;��</font>
			</div>
			<div class="AccordionPanelContent">
			<a href="ExitSystem" target="_parent"><font size="+1" color="#000000">&nbsp;&nbsp;�˳�ϵͳ</font></a><br>
			
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
