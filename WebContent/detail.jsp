<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房屋详情</title>
<link href="css/detail.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript">
	function book(strInputDate) {
		
		var indate = strInputDate.checkindate.value;
		var outdate = strInputDate.checkoutdate.value;
		if (indate=="") {
			alert('入住时间不能为空！');
			return false;
		} else if (outdate=="") {
			alert('退房时间不能为空！');
			return false;
		}
		strInputDate = indate.replace(/-/g, "/");
		var d = new Date(strInputDate);
		var arr = indate.split("/");
		var flag = ((parseInt(arr[0], 10) == d.getFullYear()) && (parseInt(arr[1], 10) == (d.getMonth() + 1)) && (parseInt(arr[2], 10) == d.getDate()));   		   
		if (isNaN(d) || flag) {
			alert('格式错误错误，应为 yyyy-M-d、yyyy-MM-dd、yyyy/M/d、yyyy/MM/dd');
			return false;
		}	
		strOutputDate = outdate.replace(/-/g, "/");
		var d2 = new Date(strOutputDate);
		var arr2 = outdate.split("/");
		var flag = ((parseInt(arr2[0], 10) == d2.getFullYear()) && (parseInt(arr2[1], 10) == (d2.getMonth() + 1)) && (parseInt(arr2[2], 10) == d2.getDate()));   		   
		if (isNaN(d2) || flag) { 
			alert('格式错误错误，应为 yyyy-M-d、yyyy-MM-dd、yyyy/M/d、yyyy/MM/dd');
			return false;	
		} 						
	}

</script>
</head>
<body>

<div id="wrapper">  
	<jsp:include page="header.jsp"></jsp:include>	

<c:forEach items="${houseBusiList}" var="house">
<div class="div">
	<div class="div1">	
		<span>${house.name}</span>	
		<p class="address">地址：${house.address}</p>
		<div class="left">
			<img alt="" src="${house.shotcut1}">
			<img alt="" src="${house.shotcut2}">
			<img alt="" src="${house.shotcut3}">
			<p>房屋描述</p>
			${house.roomdesc}
			<p>设施服务</p>
			${house.facility}
			<p>房屋使用规则</p>
			${house.userule}
		</div>
		<div class="right">
		<table>
		<tr>
			<td>房屋类型：</td>
			<td>
				<c:choose>
					<c:when test="${house.kind==1}">酒店</c:when>
					<c:when test="${house.kind==2}">客栈</c:when>
					<c:when test="${house.kind==3}">旅馆</c:when>
					<c:when test="${house.kind==4}">民宿</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>出租类型：</td>
			<td>
				<c:choose>
					<c:when test="${house.renttype==1}">整租</c:when>
					<c:when test="${house.renttype==2}">单间</c:when>
					<c:when test="${house.renttype==3}">床位</c:when>
				</c:choose>		
			</td>
		</tr>
		<tr>
			<td>面积：</td>
			<td>${house.area}平方米</td>
		</tr>
		<tr>
			<td>可住人数：</td>
			<td>${house.guestnum}人</td>
		</tr>
		<tr>
			<td>卧室数：</td>
			<td>${house.bedroomnum}个</td>
		</tr>
		<tr>
			<td>房间数：</td>
			<td>${house.roomnum}间</td>
		</tr>
		<tr>
			<td>床数：</td>
			<td>${house.bednum}</td>
		</tr>
		<tr>
			<td>床型：</td>
			<td>
				<c:choose>
					<c:when test="${house.renttype==1}">双人床</c:when>
					<c:when test="${house.renttype==2}">单人床</c:when>
					<c:when test="${house.renttype==3}">高低床</c:when>
				</c:choose>	
			</td>
		</tr>
		<tr>
			<td>卫生间数：</td>
			<td>${house.toiletnum}间</td>
		</tr>
		<tr>
			<td>入住时间：</td>
			<td>
				<c:choose>
					<c:when test="${house.renttype==1}">14:00</c:when>
					<c:when test="${house.renttype==2}">17:00</c:when>
					<c:when test="${house.renttype==3}">9:00</c:when>
				</c:choose>	
				之后
			</td>
		</tr>
		<tr>
			<td>退房时间：</td>
			<td>
				<c:choose>
					<c:when test="${house.renttype==1}">15:00</c:when>
					<c:when test="${house.renttype==2}">19:00</c:when>
					<c:when test="${house.renttype==3}">10:00</c:when>
				</c:choose>	
				之后
			</td>
		</tr>
		<tr>
			<td>最少天数：</td>
			<td>${house.minday}</td>
		</tr>
		<tr>
			<td>最多天数：</td>
			<td>${house.maxday}</td>
		</tr>
		<tr>
			<td>发票：</td>
			<td>
				<c:choose>
					<c:when test="${house.renttype==1}">提供</c:when>
					<c:when test="${house.renttype==2}">不提供</c:when>
				</c:choose>
			</td>
		</tr>			
		</table>		
		</div>	
	</div>

	<div class="div2">
		<span>￥${house.dayprice}/晚</span>	
		<form action="order_book?state=${house.state}" method="post" onsubmit="return book(this);">
			<br>
			<input type="hidden" name="t_h_id" value="${house.id }">
			<input type="hidden" name="unitprice" value="${house.dayprice }">
			入住时间：<input type="text" name="checkindate"><br><br>
			退房时间：<input type="text" name="checkoutdate"><br><br>
			<%
				String msg = (String) request.getAttribute("message");
				if (msg != null) {
			%>
				<font color="red" size="3px"><%=msg %></font><br><br>				
			<%	
				}
			%>
			<input type="submit" value="立即预定！" class="submit">
		</form>
		<table>
			<tr>
				<td>房东图片：</td>
				<td><img src="${house.shotcut1}" width="50px" height="50px"></td>
			</tr>
			<tr>
				<td>房东姓名：</td>
				<td>${house.uname}</td>
			</tr>
			<tr>
				<td>房东联系电话：</td>
				<td>${house.mobile}</td>
			</tr>
		</table>
					
	</div>
</div>		
</c:forEach>

	<jsp:include page="footer.jsp"></jsp:include>	
</div>	
</body>
</html>