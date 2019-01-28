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
				用户注册
				</h3>
			</div>
			<div class="panel-body ">
			<h5>您好，新用户！请完善以下信息<br>（**为必填，*管理账户必填）</h5>
			<div id="info" class="form-group" >
			<form id="form" action="register" method="post">
				<div class="form-group" >
				<input type="text" name="userid" required="required" placeholder="账号**">
				</div>
				<div class="form-group" >
				<input type="text" name="username" required="required" placeholder="昵称**">
				</div>
				<div class="form-group" >
				<input type="password" name="password" required="required" placeholder="密码**">
				</div>
				<div class="form-group" >
				<input type="text" name="custName" placeholder="姓名*">
				</div>	
				<div class="form-group" >
				<input type="text" name="custId" placeholder="身份证号*">
				</div>
				<div class="form-group" >
				<input type="text" name="phoneNum" placeholder="手机号码*">
				</div>
				<div class="form-group" >
				<input type="text" name="age" placeholder="年龄">
				</div>	
				<div>
				<input type="radio" name="gender" value="man">男<input type="radio" name="gender" value="wom">女
				</div>
				<!-- -->  <div class="form-group">
				<select name="role" title="申请账号类型" >
				<option value="ODI">普通用户</option>
				<option value="FLDB">航务信息管理员</option>
				<option value="HLDB">酒店信息管理员</option>
				<option value="CSDB">车辆服务信息管理员</option>
				</select>
				</div>
				<div class="form-group">
				<button class="btn btn-info" id="btn-register" type="submit" onclick="register();">注册</button>
				</div>
				</form>
				</div>
			</div>
		</div> 
		<div>
		<iframe MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no src="bottom.html" width="100%"  height="20%">
   </iframe>  
		</div>  
   </body>
</html>