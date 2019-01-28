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
	<h4 align="center">车辆信息查询</h4>
    <div class="cow">
    <div class="carousel slide " align="center" data-defer="form" data-submit-type="city">
            <strong >路线查询</strong>
            <input id="fromCity" class="submit_from input_txt depart" value="官渡区" data-field="text" 
            data-required-msg="请选择出地" data-defer="addressPlugin|noticePlugin" type="text"  
            data-notice="中文/拼音" />
            <input id="FCity" class="submit_from_no" type="hidden" value="BJS" />
            <a href="javascript:void(0);" class="ico change_city" data-defer="dataSwitch" 
            data-elemA="fromCity;FCity" data-elemB="toCity;TCity">换</a>
            <input id="toCity" class="submit_to input_txt arrive"  value="盘龙区"  data-field="text" 
            data-validate="isSame(fromCity)" data-validate-msg="出发地不能和到目的地相同" 
            data-defer="addressPlugin|noticePlugin" type="text" data-notice="中文/拼音" />
            <input id="TCity" class="submit_to_no" type="hidden" value="SHA" />
            <span class="btn_box">
                <input type="button" class="btn_blue_s submit" value=" 查询 ">
            </span>
      </div>
    </div>
	<div id="rerult_table">                         
    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
    <caption align="center" class="text-center">车辆列表</caption>
    <thead >   
        <tr class="text-center">
            <th>车牌号</th>
            <th>车型</th>
            <th>当前位置</th>
            <th>单价/km</th>
            <th>当前状态</th>
            <th>操作</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="car" items="${sessionScope.cars}" >
            <tr>
                <td>${car.carId}</td>
                <td>${car.type}</td>
                <td>${car.area}</td>
                <td>${car.price}</td>
                <td>${car.isEmp}</td>
                <td><a href="ordercar.action?carId=${car.carId}" type="submit" >叫车</a></td>
            </tr>
        </c:forEach>
       </tbody>
	</table> 
    </div>
    
    <a class="schedule_up_disable" href="javascript:void(0)">&nbsp;<b></b>&nbsp;</a>  
    <div class="schedule_page_list clearfix" align="center">
    <a href="searchcars.action?pageNum=<%=1%>" class="current">1</a>       
    <a href="searchcars.action?pageNum=<%=2%>">2</a>
	<a href="searchcars.action?pageNum=<%=1%>">3</a>
	<a href="searchcars.action?pageNum=<%=1%>">4</a>
    <a href="searchcars.action?pageNum=<%=2%>">5</a>          
    </div>
    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
    </div>             
	</body>
</html>