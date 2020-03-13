<%@page import="com.ruanko.model.User"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录 - 轻松短租网</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/reg.css" type="text/css" rel="stylesheet" />
</head>
<body>	
	
	<%
		String message = (String) request.getAttribute("messages");		
		String name = (String) request.getAttribute("name");
		String pass = (String) request.getAttribute("pass");
	%>
	
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
							 
		<div id="cols">
			<div class="index_zbg">
				<div class="reg-main">
					<div class="reg-center">
						<div class="reg-left">
							<form id="loginform" name="loginform" action="login" method="post">
								<dl>
									<dt>
										登录到您的短租网账户
										<br />
									</dt>
									<dd id="showtips" style="display: none"></dd>
									<%
										if (name == null || pass ==null) {
									%>
									<dd class="">
										<label id="label_username" class="labeltips"
											style="width: 140px; display: block;">
											用户名：
										</label>
										<input id="username" class="input-reg" type="text"
											name="name"/>
									</dd>
									<dd class="">
										<label id="label_password" class="labeltips"
											style="display: block;">
											密码：
										</label>
										<input id="password" class="input-reg" type="password"
											maxlength="12" name="password"/>
									</dd>	
									<%		
										} else {
									%>
									<dd class="">
										<label id="label_username" class="labeltips"
											style="width: 140px; display: block;">
											用户名：
										</label>
										<input id="username" class="input-reg" type="text"
											name="name" value="<%=name %>"/>
									</dd>
									<dd class="">
										<label id="label_password" class="labeltips"
											style="display: block;">
											密码：
										</label>
										<input id="password" class="input-reg" type="password"
											maxlength="12" name="password" value="<%=pass %>"/>
									</dd>
									<%		
										}
									%>																											
								</dl>
								<p>
									<a href="#">忘记密码？</a>
								</p>															
								<%					
									if (message != null) {
								%>										
							 	<font color="red"><%=message %></font>								 	
								<%		
									}
								%>								
								<p class="my-login">
									<input id="login_btn" class="log-gj" type="submit"
										value="登录短租网" />
								</p>
								<p class="reg-gj">
									还没有短租网网账户吗？
									<a href="register.jsp">立即注册</a>
								</p>
							</form>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>		
	</div>	

</body>
</html>