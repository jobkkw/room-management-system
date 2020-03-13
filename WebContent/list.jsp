<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房屋列表</title>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="css/list.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="wrapper">  
	<jsp:include page="header.jsp"></jsp:include>
		
	<div class="main">			
		<div class="search">			
			<form action="house_search">
				<span class="span">输入房屋地址或名称查询：</span>			
				<input name="searchName">
				<button type="submit">搜索</button>
			</form>
		</div>
	</div>

	<div class="list">
	<c:if test="${empty houseList}">
		<font color="red" size="5px">抱歉，没有查询到与“<%=request.getAttribute("searchName") %>”相关的房屋</font>
	</c:if>
	
	<c:forEach items="${houseList}" var="house">
	<table>
		<tr>
			<td rowspan="4" width="15%">
			<a href="http://localhost:8080/ShortRent/house_getHouseById?id=${house.id}&state=${house.state}">
			<img src="${house.shotcut1}">
			</a>			
			</td>
		</tr>
		<tr>				
			<td colspan="2" width="40%">${house.name}</td>
			<td rowspan="2" style="font-size: 30px;" width="10%">￥${house.dayprice}</td>				
		</tr>
		<tr>
			<td colspan="2"><img src="${house.shotcut1}" width="50px" height="50px"></td>
		</tr>		
		<tr>
			<td>
			<c:choose>
					<c:when test="${house.kind==1}">酒店</c:when>
					<c:when test="${house.kind==2}">客栈</c:when>
					<c:when test="${house.kind==3}">旅馆</c:when>
					<c:when test="${house.kind==4}">民宿</c:when>
			</c:choose>
			-
			<c:choose>
					<c:when test="${house.renttype==1}">整租</c:when>
					<c:when test="${house.renttype==2}">单间</c:when>
					<c:when test="${house.renttype==3}">床位</c:when>
			</c:choose>
			</td>
			<td>地址：${house.address}</td>			
		</tr>		
	</table>			
	</c:forEach>
	</div>

<jsp:include page="footer.jsp"></jsp:include>	
</div>	
</body>
</html>