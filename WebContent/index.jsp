<%@page import="com.ruanko.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id="wrapper">  
		<jsp:include page="header.jsp"></jsp:include>	
		<br><br><br><br>
		<br><br><br><br>		
		<div class="main">
			<p class="p">寻找旅行中的家</p>
			<div class="search">
				<form action="house_search">
					<input name="searchName">
					<button type="submit">搜索</button>
				</form>
			</div>
		</div>
	
		<jsp:include page="footer.jsp"></jsp:include>	
	</div>
</body>
</html>