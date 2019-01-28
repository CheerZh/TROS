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
   <div >
   		<% String username=(String)session.getAttribute("username");
   		if(username!=null){%>
   		<div class="text-right">您好,<%out.println(username);%>!</div>
       	 <%}else{ %>
		<div class="text-right">
			您未登录！&nbsp;&nbsp;&nbsp;<a href="login.jsp" target="_parent">登录</a>&nbsp;&nbsp;<a href="register.jsp" target="_parent">注册</a>&nbsp;&nbsp;&nbsp;<a></a>
   		</div>
 		<%} %> 
	</div>
   </body>
</html>