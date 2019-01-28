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
    <caption ></caption>
    <thead>   
        <tr>
            <th>订单号</th>
        	<th>订票人</th>
            <th>航班号</th>
            <th>出发地</th>
            <th>目的地</th>
            <th>日期</th>
            <th>类型</th>
            <th>座位号</th>
            <th>价格</th>
            <th>状态</th>   

        </tr>
    </thead>
	<tbody>
        <c:forEach var="resv" items="${sessionScope.fltOrds}" >
            <tr>
            	<td>${resv.resvKey}</td>
            	<td>${resv.custName}</td>
                <td>${resv.flightNum}</td>
                <td>${resv.fromCity}</td>
                <td>${resv.arivCity}</td>
                <td>${resv.ordDate}</td>
                <td>${resv.seatType}</td>
                <td>${resv.seatId}</td>
                <td>${resv.price}</td>
                <td>${resv.status}</td>
            </tr>
        </c:forEach>
       </tbody>
	</table>
	 </div>
    <div class="schedule_page_list clearfix" align="center">
    <a href="get_flt_ords.action?pageNum=<%=1%>" class="current">1</a>       
    <a href="get_flt_ords.action?pageNum=<%=2%>">2</a>
	<a href="get_flt_ords.action?pageNum=<%=3%>">3</a>
	<a href="get_flt_ords.action?pageNum=<%=4%>">4</a>
    <a href="get_flt_ords.action?pageNum=<%=5%>">5</a>          
    </div>
    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
     </div> 
	</div> 
	
	</body>
</html>