<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title>YOYO-在线预订，自在悠游！</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
     	<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      	<![endif]-->
      	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>	    
   </head>
   <body>
   <div>
   <iframe MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no 
   src="greeting.html" width="100%"  height="10%">
   </iframe>
   </div>
		<div id="box" class="panel panel-default text-center">
			<div class="panel-heading">
				<h3 class="panel-title">
				用户登录
				</h3>
			</div>
			<div class="panel-body ">
			<div id="logo" class="form-group">欢迎登陆！</div>
			<div id="info" class="form-group" >
			<form id="form" action="login" method="post">
				<div class="form-group" >
				<input type="text" name="userid" placeholder="账号:">
				</div>
				<div class="form-group" >
				<input type="password"  name="password" placeholder="密码:">
				</div>
				<div id="remember"><input type="checkbox">记住登陆</div>
				<div class="form-group">
				<button class="btn btn-info" id="btn-login" type="submit" onclick="Login()">登录</button>
				</div>
				<br/>没有账号？<a href="/TROS/pages/register.jsp">前往注册</a>
				</form>
				</div>
			</div>
		</div>
		<div>
		<iframe MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no 
   src="bottom.html" width="100%"  height="20%">
   </iframe>  
		</div>
		 
   </body>
</html>