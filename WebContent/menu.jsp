<%@page import="com.ruanko.dao.impl.HouseDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>
<link href="css/menu.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="menu">
	<dl>
		<dt>我是房东</dt>
			<dd><a href="http://localhost:8080/ShortRent/toPublish" target="in">发布房屋</a></dd>	
			<dd><a href="http://localhost:8080/ShortRent/order_toUnchecked" target="in">受理订单</a></dd>
			<dd><a href="http://localhost:8080/ShortRent/myHouse" target="in">我的房屋</a></dd>	
			<dd><a href="http://localhost:8080/ShortRent/toCreate" target="_blank">创建房屋</a></dd>
		<dt>我是房客</dt>
			<dd><a href="http://localhost:8080/ShortRent/order_myUnChecked" target="in">待受理订单</a></dd>	
			<dd><a href="http://localhost:8080/ShortRent/order_myChecked" target="in">已受理订单</a></dd>
		<dt>交易记录</dt>
			<dd><a>成交订单</a></dd>	
			<dd><a>交易记录</a></dd>
		<dt>查询统计</dt>
			<dd><a>房屋统计</a></dd>	
			<dd><a>订单统计</a></dd>	
	</dl>
</div>

</body>
</html>