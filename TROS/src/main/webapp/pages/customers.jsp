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
    <caption >新增订票人</caption>
    <thead>   
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>选择</th>
        </tr>
    </thead>
	<tbody>
        	<tr>
            	<td><input type="text"  value=""></td>
                <td><input type="text"  value=""></td>
                <td><input type="text"  value=""></td>
                <td><input type="text"  value=""></td>
                <td><input type="text"  value=""></td>
                <td><a href="formFltOrd.action" type="submit" >确认</a></td>
            </tr>
       </tbody>
       </table>                        
    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
    <caption >选择已有订票人</caption>
    <thead>   
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>选择</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="cust" items="${sessionScope.custs}" >
            <tr>
            	<td>${cust.custId}</td>
                <td>${cust.custName}</td>
                <td>${cust.gender}</td>
                <td>${cust.age}</td>
                <td>${cust.phoneNum}</td>
                <td><a href="formFltOrd.action?custId=${cust.custId}" type="submit" >确认</a></td>
            </tr>
        </c:forEach>
       </tbody>
       </table>
    </div>
    <div class="schedule_page_list clearfix" align="center">
    <a href="chooseCust.action?pageNum=<%=1%>" class="current">1</a>       
    <a href="chooseCust.action?pageNum=<%=2%>">2</a>
	<a href="chooseCust.action?pageNum=<%=3%>">3</a>
	<a href="chooseCust.action?pageNum=<%=4%>">4</a>
    <a href="chooseCust.action?pageNum=<%=5%>">5</a>          
    </div>
    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
     </div> 
	</body>
</html>