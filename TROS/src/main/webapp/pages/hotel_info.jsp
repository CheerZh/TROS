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
	<h4 align="center">酒店信息查询</h4>
    <div class="cow">
    <div class="carousel slide  col-md-8 col-lg-8" data-defer="form" data-submit-type="city">
            <strong >按位置查询</strong>
            <input id="City" class="submit_from input_txt depart" value="所在城市" data-field="text" 
            data-required-msg="请选择城市" data-defer="addressPlugin|noticePlugin" type="text"  
            data-notice="中文/拼音" />
            <input id="FCity" class="submit_from_no" type="hidden" value="BJS" />
            <input id="toCity" class="submit_to input_txt arrive"  value="所在区域"  data-field="text" 
            data-validate="isSame(City)" data-validate-msg="不能和城市名相同" 
            data-defer="addressPlugin|noticePlugin" type="text" data-notice="中文/拼音" />
            <input id="TCity" class="submit_to_no" type="hidden" value="SHA" />
            <span class="btn_box">
                <input type="button" class="btn_blue_s submit" value=" 查询 ">
            </span>
            <!-- 按名称查询 -->
            <div class="carousel slide  col-md-4 col-lg-4" data-defer="form" data-submit-type="flight">
	        <strong class="t">按名称查询</strong>
	        <input type="text" id="hotelName" class="submit_flight input_txt" data-defer="noticePlugin" 
	        data-notice="请输入您要搜索的酒店名称" data-field="text"  data-required="true" data-required-msg="请填写酒店名">
	        <span class="btn_box"><input type="button" class="btn_blue_s submit" value=" 查询 "></span>
    	</div>
    </div>
	<div id="rerult_table">                         
    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
    <caption align="center" class="text-center">酒店列表</caption>
    <thead >   
        <tr class="text-center">
            <th>酒店名称</th>
            <th>城市</th>
            <th>区域</th>
            <th>房间数量</th>
            <th>操作</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="hotel" items="${sessionScope.hotels}" >
            <tr>
                <td>${hotel.hotelName}</td>
                <td>${hotel.city}</td>
                <td>${hotel.area}</td>
                <td>${hotel.numRooms}</td>
                <td><a href="getSeatInfo.action?flightNum=${hotel.hotelName}" type="submit" >查看详情</a></td>
            </tr>
        </c:forEach>
       </tbody>
	</table> 
    </div> 
    
    <a class="schedule_up_disable" href="javascript:void(0)">&nbsp;<b></b>&nbsp;</a>  
    <div class="schedule_page_list clearfix" align="center">
    <a href="hotel_info.jsp?pageNum=<%=1%>" class="current">1</a>       
    <a href="hotel_info.jsp?pageNum=<%=2%>">2</a>
	<a href="hotel_info.jsp?pageNum=<%=3%>">3</a>
	<a href="hotel_info.jsp?pageNum=<%=4%>">4</a>
    <a href="hotel_info.jsp?pageNum=<%=5%>">5</a>          
    </div>
    <div class="schedule_page_value" align="center" data-defer="form" data-submit-type="pageIndex" data-url="#">
        到<input type="text" name="" data-field="text" data-validate="isPageNum(5)" 
        data-validate-msg="请输入正确的页码" data-required="true" data-required-msg="请输入页码" class="schedule_page_num">
        页<input type="button" name="" value="确定" class="schedule_page_submit submit">
    </div>             
	</body>
</html>