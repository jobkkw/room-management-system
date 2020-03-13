<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="menu">
	<dl>
		<dt>房屋管理</dt>
			<dd><a href="http://localhost:8080/ShortRent/house_toUnchecked" target="in">审核房屋</a></dd>	
			<dd><a href="http://localhost:8080/ShortRent/" target="in">已审核订单</a></dd>
			<dd><a href="http://localhost:8080/ShortRent/" target="in">已拒绝房屋</a></dd>	
		<dt>用户管理</dt>
			<dd><a href="http://localhost:8080/ShortRent/" target="in">查看用户信息</a></dd>	
			<dd><a href="http://localhost:8080/ShortRent/" target="in">冻结用户</a></dd>
		<dt>查询统计</dt>
			<dd><a>房屋统计</a></dd>	
			<dd><a>用户统计</a></dd>	
	</dl>
</div>
</body>
</html>