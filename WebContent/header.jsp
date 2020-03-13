<%@page import="com.ruanko.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="head">
		<h1 class="f-left">
			<a href="index.jsp">短租网</a>
		</h1>
		<span class="chat"></span>
		<ul>
			
			<%
				User user = (User) session.getAttribute("user");
				
				if (user == null || user.equals("")) {
			%>
			<li>
				<a href="register.jsp">注册</a>
			</li>
			<li>
				｜
			</li>
			<li>
				<a href="login.jsp">登录</a>
			</li>
			<li>
				｜
			</li>
			<li>
				<a href="http://localhost:7733/ShortRent/toCreate">免费创建房屋</A>
			</li>
			<%						
				} else {
			%>
			<li>
				<a href=""><%=user.getName() %></a>
			</li>
			<li>
				｜
			</li>
			<li>
				<a href="logout">退出</a>
			</li>
			<li>
				｜
			</li>
			<li>
				<a href="http://localhost:7733/ShortRent/toCreate">免费创建房屋</A>
			</li>	
			<%		
				}
			%>									
		</ul>
	</div>
</body>
</html>