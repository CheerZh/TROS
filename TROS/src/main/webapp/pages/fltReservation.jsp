<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <title></title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>	    
   </head>
	<body>
	<div>                         
    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
    <caption >订票成功</caption>
    <thead>   
        <tr>
        	<th>订票人</th>
            <th>航班号</th>
            <th>出发地</th>
            <th>目的地</th>
            <th>日期</th>
            <th>类型</th>
            <th>座位号</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="resv" items="${sessionScope.fltResv}" >
            <tr>
            	<td>${resv.custName}</td>
                <td>${resv.flightNum}</td>
                <td>${resv.fromCity}</td>
                <td>${resv.arivCity}</td>
                <td>${resv.ordDate}</td>
                <td>${resv.seatType}</td>
                <td>${resv.seatId}</td>
                <td>${resv.price}</td>
                <td><a href="#" type="submit" >支付</a></td>
            </tr>
        </c:forEach>
       </tbody>
	</table>
	</div> 
	</body>
</html>