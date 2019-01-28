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
  	<div  id="navbarSupportedContent">
		<ul class="nav nav-pills text-center">
  			<li><a href="boutique.html" target="centerFrame">推荐</a></li>
  			<li>
            <a href="searchflt.action?pageNum=1" target="centerFrame" type="submit">机票</a>
            </li> 
			<li><a href="searchhotel.action?pageNum=1" target="centerFrame">酒店</a></li>
			<li><a href="searchcars.action?pageNum=1" target="centerFrame">乘车</a></li>
			<li><a href="get_flt_ords.action?pageNum=1" target="centerFrame">订单</a></li>
			<li class="dropdown">
                <a href="management.jsp" class="dropdown-toggle"  data-toggle="dropdown">
                    管理<b class="caret"></b></a>
                <ul class="dropdown-menu text-center">
                	<li><a href="syn_cust.action?pageNum=1" target="centerFrame">个人中心</a></li>
                	<li><a href="syn_cust.action?pageNum=1" target="centerFrame">旅客信息管理</a></li>
    				<li><a href="syn_flt.action?pageNum=1" target="centerFrame">航班信息管理</a></li>  
                    <li><a href="syn_htl.action?pageNum=1" target="centerFrame">酒店信息管理</a></li>
                    <li><a href="syn_cars.action?pageNum=1" target="centerFrame">车辆服务信息管理</a></li>
                </ul>
            </li>
		</ul>
   </div>
   <hr>
   <div >
   <iframe name="centerFrame"  MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 
   SCROLLING=no width="100%"  height="100%" src="boutique.html">
    </iframe>
    </div>
   </body>
</html>