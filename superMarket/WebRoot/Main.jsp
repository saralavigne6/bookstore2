<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ö÷Ò³Ãæ</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <c:if test="${empty sessionScope.username }">
<script type="text/javascript">
alert("ÇëÏÈµÇÂ¼!!!");
self.location.href="Login.jsp";
</script>
</c:if>
  
  <frameset  COLS="10%,*,10%">
  <frame noresize="noresize"  src="about:blank"></frame>
  
  <frameset  ROWS="18%,*,6%">
  <frame noresize="noresize" src="top.jsp"></frame>
  <frameset  COLS="16%,*">
  <frame noresize="noresize" src="left.jsp"></frame>
  <frame noresize="noresize" src="AddGoods.jsp" name="right"></frame>
  </frameset>
  <frame noresize="noresize" src="button.jsp"></frame>
  </frameset>
  
  <frame noresize="noresize" src="about:blank"></frame>
  </frameset>
</html>
