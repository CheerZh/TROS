<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
      <title></title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>	    
   </head>
   <body>
   <div class="form-group">
   		<% String username=(String)session.getAttribute("username");
   		if(username!=null){%>
    	<ul class="nav navbar-nav navbar-right small">
    	<li><a>您好,<%out.println(username);%>!</a></li>
      	<li><a href="logout.action" target="_parent" type="submit"><span class="glyphicon glyphicon-log-out small" ></span>注销</a></li>
    	</ul>
       	 <%}else{%>
    	<ul class="nav navbar-nav navbar-right small form-inline">
      	<li><a href="login.jsp" target="_parent" ><span class="glyphicon glyphicon-user small"></span>登录</a></li>
      	<li><a href="register.jsp" target="_parent" ><span class="glyphicon glyphicon-log-in samll"></span>注册</a></li>
    	</ul>
    	<%}%> 
   <div class="form-inline hidden-xs">	
   <h3> YOYO悠游<small>&nbsp;&nbsp;&nbsp;欢迎使用悠游在线订票系统！</small></h3>
   </div>
   </div>
   </body>
</html>