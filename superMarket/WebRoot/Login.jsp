<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>后台管理登录界面</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<style>
#mysubmit{
background-color:#0000ff;
}
</style>
<script type="text/javascript">
var tax=0;
function check(){
	var username=document.getElementById("username").value;
	var userpass=document.getElementById("userpass").value;
	if((username =="") || (userpass =="")){
		alert("账号或密码不能为空");
		return false;
	}else{
		return true;
	}
}
</script>
    </head>

    <body>
    <c:if test="${not empty requestScope.mess }">
    <script type="text/javascript">
    alert("账号或密码错误");
    </script>
    </c:if>
        <div class="page-container">
            <h1>LOGIN</h1>
            <form action="user_Login_Check" method="post" onSubmit="return check()">
                <input type="text" size="48" name="username" id="username" class="username" placeholder="Username">
                <input type="password" size="48" name="userpass" id="userpass" class="userpass" placeholder="Password">
                <input type="submit" id="mysubmit" size="40" value="Login" />
                <div class="error"><span>+</span></div>
            </form>
        </div>
        

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>
