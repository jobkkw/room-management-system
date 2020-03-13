<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册 - 轻松短租网</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/reg.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
	
		<div id="cols">
			<div class="index_zbg">
				<div class="reg-main">
					<div class="reg-center">
						<div class="reg-left">
							<form id="registerform" method="post" name="registerform"
								action="register">
								<dl>
									<dt>
										注册新账号
									</dt>
									<dd class="">
										<label id="label_username" class="labeltips"
											style="display: block;">
											用户名
										</label>
										<input id="username" class="input-reg" type="text"
											name="name" />
									</dd>
									<dd id="tip_username" class="info">
										<span class="validatorMsg validatorValid">4-20个字符（汉字、字母、数字、下划线）</span>
									</dd>
									<dd class="">
										<label id="label_password" class="labeltips"
											style="display: block;">
											密码
										</label>
										<input id="password" class="input-reg" type="password"
											name="password" />
									</dd>
									<dd id="tip_password" class="info">
										<span class="validatorMsg validatorValid">6-12个字符</span>
									</dd>
									<dd class="">
										<label id="label_password2" class="labeltips"
											style="display: block;">
											确认密码
										</label>
										<input id="password2" class="input-reg" type="password"
											name="password2" />
									</dd>
									<dd id="tip_password2" class="info">
										<span class="validatorMsg validatorValid">重复输入一次密码</span>
									</dd>
									<dd class="">
										<label id="label_phone" class="labeltips"
											style="display: block;">
											手机号
										</label>
										<input id="phone" class="input-reg" type="text" name="mobile" />
									</dd>
									<dd id="tip_phone" class="info">
										<span class="validatorMsg validatorValid">请输入你的手机号码</span>
									</dd>
									
									<dd class="">
										<label id="label_email" class="labeltips"
											style="display: block;">
											邮箱(可选项)
										</label>
										<input id="email" class="input-reg" type="text" name="email" />
									</dd>
									<dd id="tip_email" class="info">
										<span class="validatorMsg validatorInit">邮箱可选填写</span>
									</dd>
									
								</dl>
								<div class="clear"></div>
								<div id="tip_checkcode" style="margin-top: 5px;"></div>
								<p style="width: 340px; float: left; margin-top: 20px;">
									<input id="affirm" type="checkbox" name="affirm" />
									我同意
									<a target="_blank" href="#">《短租网服务协议》</a>
									及
									<a target="_blank"
										href="#">《隐私条款》</a>
									<span id="tip_affirm"
										style="display: inline-block; height: 25px; padding: 5px 0"></span>
								</p>
								<p id="register">
									<a class="reg-button" href="#"><input type="submit" value="立刻注册!"></a>
								</p>
								
							</form>
							
						</div>
						<div class="reg-right">
							<dl>
								<dt class="font18">
									已有短租网账号，请直接登录
								</dt>
								<dd>
									<a class="reg-log" href="login.jsp">登录短租网</a>
								</dd>
							</dl>
						</div>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>	
	</div>
</body>
</html>