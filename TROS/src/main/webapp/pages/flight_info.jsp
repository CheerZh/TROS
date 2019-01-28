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
	<h4 align="center">航班信息查询</h4>
    <div class="cow">
    <div class="carousel slide  col-md-8 col-lg-8" data-defer="form" data-submit-type="city">
            <strong >航线查询</strong>
            <input id="fromCity" class="submit_from input_txt depart" value="北京" data-field="text" 
            data-required-msg="请选择出发城市" data-defer="addressPlugin|noticePlugin" type="text"  
            data-notice="中文/拼音" />
            <input id="FCity" class="submit_from_no" type="hidden" value="BJS" />
            <a href="javascript:void(0);" class="ico change_city" data-defer="dataSwitch" 
            data-elemA="fromCity;FCity" data-elemB="toCity;TCity">换</a>
            <input id="toCity" class="submit_to input_txt arrive"  value="上海"  data-field="text" 
            data-validate="isSame(fromCity)" data-validate-msg="出发城市不能和到达城市相同" 
            data-defer="addressPlugin|noticePlugin" type="text" data-notice="中文/拼音" />
            <input id="TCity" class="submit_to_no" type="hidden" value="SHA" />
            <span class="btn_box">
                <input type="button" class="btn_blue_s submit" value=" 查询 ">
            </span>
    </div><span class="ico or"></span>
    <div class="carousel slide  col-md-4 col-lg-4" data-defer="form" data-submit-type="flight">
        <strong class="t">航班号查询</strong>
        <input type="text" id="flightNO" class="submit_flight input_txt" data-defer="noticePlugin" 
        data-notice="请输入您要搜索的航班号" data-field="text" data-validate="isFlightNO" 
        data-validate-msg="请输入正确的航班号" data-required="true" data-required-msg="请填写航班号">
        <span class="btn_box"><input type="button" class="btn_blue_s submit" value=" 查询 "></span>
    </div>
    </div>
	<div id="rerult_table">                         
    <table class="table table-bordered table-condensed table-striped table-responsive text-center" >
    <caption align="center" class="text-center">航班列表</caption>
    <thead >   
        <tr class="text-center">
            <th>航班号</th>
            <th>出发地</th>
            <th>到达地</th>
            <th>客运量</th>
            <th>操作</th>
        </tr>
    </thead>
	<tbody>
        <c:forEach var="flight" items="${sessionScope.flights}" >
            <tr>
                <td>${flight.flightNum}</td>
                <td>${flight.fromCity}</td>
                <td>${flight.arivCity}</td>
                <td>${flight.numSeats}</td>
                <td><a href="getSeatInfo.action?flightNum=${flight.flightNum}" type="submit" >查看详情</a></td>
            </tr>
        </c:forEach>
       </tbody>
	</table> 
    </div> 

	<h6 align="center">友情提醒：航班时刻表信息仅供参考，如有出入以实际航班信息为准。</h6>
    
    <a class="schedule_up_disable" href="javascript:void(0)">&nbsp;<b></b>&nbsp;</a>  
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
	</body>
</html>