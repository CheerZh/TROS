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
        <a class="navbar-brand" href="#">航班信息管理中心</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active text-warning"><a href="flight_info_m.jsp">信息同步</a></li>
            <li><a href="Icry.html">批量更新</a></li>
            <li><a href="Icry.html">新增航班信息</a></li>
            <li class="text-warning"><a href="Icry.html">提交所有操作</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    排序<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">按航班号</a></li>
                    <li><a href="#">按时间</a></li>
                    <li><a href="#">按价格</a></li>
                    <li><a href="#">按余票量</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
    <div>                             
    <table class="table table-bordered table-condensed table-striped table-responsive text-center">
    <caption>航班列表</caption>
    <thead>   
        <tr>
        	<th>批量</th>
            <th>航班号</th>
            <th>出发地</th>
            <th>到达地</th>
            <th>客运量</th>
            <th>详情</th>
            <th>更新</th>
            <th>删除</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="flight" items="${sessionScope.flights}" >
            <tr>           	
            	<td><input name="selected_fly" type="checkbox" value="${flight.flightNum}"></td>
                <td><input type="text"  value="${flight.flightNum}"></td>
                <td><input type="text"  value="${flight.fromCity}"></td>
                <td><input type="text"  value="${flight.arivCity}"></td>
                <td><input type="text"  value="${flight.numSeats}"></td>
                <td><a href="searchseat.action?flightNum=${flight.flightNum}" type="submit" >详情</a></td>
                <td><a href="updateseat.action?flightNum=${flight.flightNum}" type="submit" >更新</a></td>
                <td><a href="updateseat.action?flightNum=${flight.flightNum}" type="submit" >删除</a></td>               
            </tr>
        </c:forEach>
       </tbody>
	</table>
    </div>    
	
	<div class="schedule_page_list clearfix" align="center">
    <a href="searchflt.action?pageNum=<%=1%>" class="current">1</a>       
    <a href="searchflt.action?pageNum=<%=2%>">2</a>
	<a href="searchflt.action?pageNum=<%=3%>">3</a>
	<a href="searchflt.action?pageNum=<%=4%>">4</a>
    <a href="searchflt.action?pageNum=<%=5%>">5</a>          
    </div>
    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
    </div>
    </nav>             
   </body>
</html>