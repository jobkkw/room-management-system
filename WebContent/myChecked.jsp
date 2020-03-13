<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已受理订单</title>
<link href="css/myHouse.css" type="text/css" rel="stylesheet" />
</head>
<body>

<table class="table">
	<tr class="tr1">
		<td width="10%">订单号</td>		
		<td width="20%">房屋预览</td>
		<td width="10%">入住时间</td>
		<td width="10%">退房时间</td>
		<td width="10%">单价（￥）</td>
		<td width="10%">总价（￥）</td>
		<td width="10%">预定时间</td>
		<td width="10%">操作</td>		
	</tr>		  
	<c:if test="${!empty orderBusilist}">
	<c:forEach items="${orderBusilist}" var="order">
	<tr class="tr2">
		<td>${order.ordernum}</td>			
		<td>
		<img src="${order.shotcut1}" width="100px" height="100px"/>			
		</td>
		<td>${order.checkindate}</td>
		<td>${order.checkoutdate}</td>
		<td>${order.unitprice}</td>		
		<td>${order.total}</td>
		<td>${order.orderdate}</td>			
		<td>
			<a href="http://localhost:8080/ShortRent/order_myUnsubscribed?orderid=${order.id}">退订</a>
		</td>
	</tr>				
	</c:forEach>
	</c:if> 
</table>


</body>
</html>