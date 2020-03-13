<%@page import="com.ruanko.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
<link href="css/welcome.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<p class="p">
		您好
		<%
			User user = (User) session.getAttribute("user");
			if (user != null) {					
		%>
		<%=user.getName() %>
		<%
			}
		%>
		，欢迎进入个人中心
	</p>	
</body>
</html>