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
	<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">酒店信息管理中心</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active text-warning" ><a href="hotel_info_m.jsp">信息同步</a></li>
            <li><a href="Icry.html">批量更新</a></li>
            <li><a href="Icry.html">新增信息</a></li>
            <li class="text-warning"><a href="Icry.html">提交所有操作</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    排序<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="Icry.html">按名称</a></li>
                    <li><a href="Icry.html">按城市</a></li>
                    <li><a href="Icry.html">按价格</a></li>
                    <li><a href="Icry.html">按客房余量</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
	<div id="rerult_table">                         
	    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
	    <thead >   
	        <tr class="text-center">
	        	<th>批量</th>
	            <th>酒店名称</th>
	            <th>城市</th>
	            <th>区域</th>
	            <th>房间数量</th>
	            <th>详情</th>
	            <th>更新</th>
            	<th>删除</th>
	        </tr>
	    </thead>
		<tbody>
	        <c:forEach var="hotel" items="${sessionScope.hotels}" >
	            <tr>
	            	<td><input name="selected_htl" type="checkbox" value="${hotel.hotelName}"></td>
	                <td><input type="text"  value="${hotel.hotelName}"></td>
	                <td><input type="text"  value="${hotel.city}"></td>
	                <td><input type="text"  value="${hotel.area}"></td>
	                <td><input type="text"  value="${hotel.numRooms}"></td>
	                <td><a href="searchhotel.action?hotelName=${hotel.hotelName}" type="submit" >详情</a></td>
                	<td><a href="updatehotel.action?hotelName=${hotel.hotelName}" type="submit" >更新</a></td>
                	<td><a href="delecthotel.action?hotelName=${hotel.hotelName}" type="submit" >删除</a></td>
	            </tr>
	        </c:forEach>
	       </tbody>
		</table> 
	    </div> 
	    
	    <a class="schedule_up_disable" href="javascript:void(0)">&nbsp;<b></b>&nbsp;</a>  
	    <div class="schedule_page_list clearfix" align="center">
	    <a href="hotel_info.jsp?pageNum=<%=1%>" class="current">1</a>       
	    <a href="hotel_info.jsp?pageNum=<%=2%>">2</a>
		<a href="hotel_info.jsp?pageNum=<%=1%>">3</a>
		<a href="hotel_info.jsp?pageNum=<%=1%>">4</a>
	    <a href="hotel_info.jsp?pageNum=<%=2%>">5</a>          
	    </div>
	    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
	        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
	        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
	        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
	    </div>  
	</nav>
</body>
</html>