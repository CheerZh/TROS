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
	
	<div id="rerult_table">                             
    <table class="table table-bordered table-condensed table-striped table-responsive" >
    <caption ></caption>
    <thead>   
        <tr>
            <th>座位类型</th>
            <th>价格</th>
            <th>总量</th>
            <th>余量</th>
            <th>操作</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="stInfo" items="${sessionScope.stInfos}" >
            <tr>
                <td>${stInfo.seatType}</td>
                <td>${stInfo.price}</td>
                <td>${stInfo.numSeats}</td>
                <td>${stInfo.numAvail}</td>
                <td><a href="getSeats.action?flightNum=${stInfo.flightNum}&seatType=${stInfo.seatType}&pageNum=1" type="submit">选座</a></td>
            </tr>
        </c:forEach>
       </tbody>
	</table>
    </div> 
	</body>
</html>