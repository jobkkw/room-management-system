<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核待发布房屋</title>
<link href="css/myHouse.css" type="text/css" rel="stylesheet" />
</head>
<body>

<table class="table">
	<tr class="tr1">
		<td width="10%">房屋名称</td>
		<td width="10%">房屋预览</td>	
		<td width="10%">房屋类型</td>
		<td width="10%">出租类型</td>
		<td width="10%">面积（m²）</td>
		<td width="10%">价格（￥）</td>
		<td width="20%">创建时间</td>
		<td width="10%">操作</td>		
	</tr>		  
	<c:if test="${!empty houseList}">
	<c:forEach items="${houseList}" var="house">
	<tr class="tr2">
		<td><a href="">${house.name}</a></td>	
		<td>
			<a href="http://localhost:8080/ShortRent/house_getHouseById?id=${house.id}&state=${house.state}">
			<img src="${house.picture1}" width="100px" height="100px">
			</a>
		</td>		
		<td>
			<c:choose>
				<c:when test="${house.kind==1}">酒店</c:when>
				<c:when test="${house.kind==2}">客栈</c:when>
				<c:when test="${house.kind==3}">旅馆</c:when>
				<c:when test="${house.kind==4}">民宿</c:when>
			</c:choose>
		</td>		
		<td>
			<c:choose>
				<c:when test="${house.renttype==1}">整租</c:when>
				<c:when test="${house.renttype==2}">单间</c:when>
				<c:when test="${house.renttype==3}">床位</c:when>
			</c:choose>
		</td>
		<td>${house.area}</td>
		<td>${house.dayprice}</td>	
		<td>${house.createtime}</td>
		<td><a href="http://localhost:8080/ShortRent/publish?id=${house.id}">发布</a></td>
		<!-- <td><a href="javascript:void(0)" onclick="$('#content').load('house/publish?id=${house.id}')">发布</a></td> -->
	</tr>				
	</c:forEach>
	</c:if> 
</table>

</body>
</html>