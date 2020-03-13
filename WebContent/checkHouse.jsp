<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>待审核房屋</title>
<link href="css/myHouse.css" type="text/css" rel="stylesheet" />
</head>
<body>

	<table class="table">
	<tr class="tr1">
		<td width="10%">房屋名称</td>
		<td width="10%">房屋预览</td>
		<td width="10%">房东</td>	
		<td width="10%">房屋类型</td>
		<td width="10%">出租类型</td>
		<td width="10%">面积（m²）</td>
		<td width="10%">价格（￥）</td>
		<td width="20%">创建时间</td>
		<td width="10%">操作</td>		
	</tr>		  
	<c:if test="${!empty houseBusiList}">
	<c:forEach items="${houseBusiList}" var="houseBusi">
	<tr class="tr2">
		<td><a href="">${houseBusi.name}</a></td>	
		<td>
			<img src="${houseBusi.picture1}" width="100px" height="100px"/>				
		</td>
		<td>${houseBusi.uname}</td>
		<td>
			<c:choose>
				<c:when test="${houseBusi.kind==1}">酒店</c:when>
				<c:when test="${houseBusi.kind==2}">客栈</c:when>
				<c:when test="${houseBusi.kind==3}">旅馆</c:when>
				<c:when test="${houseBusi.kind==4}">民宿</c:when>
			</c:choose>
		</td>		
		<td>
			<c:choose>
				<c:when test="${houseBusi.renttype==1}">整租</c:when>
				<c:when test="${houseBusi.renttype==2}">单间</c:when>
				<c:when test="${houseBusi.renttype==3}">床位</c:when>
			</c:choose>
		</td>
		<td>${houseBusi.area}</td>
		<td>${houseBusi.dayprice}</td>	
		<td>${houseBusi.createtime}</td>
		<td>
			<a href="http://localhost:8080/ShortRent/house_check?houseId=${houseBusi.id}" target="in">通过</a>
			<a href="http://localhost:8080/ShortRent/house_refuse?houseId=${houseBusi.id}" target="in">拒绝</a>
		</td>
	</tr>				
	</c:forEach>
	</c:if> 
	</table>

</body>
</html>