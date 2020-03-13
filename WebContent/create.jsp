<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建房屋</title>
</head>
<script type="text/javascript">
	function submits (create) {		
		if (create.name.value=="") {			
			alert("房屋名称不能为空！");
			return false;
		} else if (create.area.value=="") {
			alert("面积不能为空！");
			return false;
		} else if (create.minday.value=="") {
			alert("最小天数不能为空！");
			return false;
		} else if (create.maxday.value=="") {
			alert("最大小数不能为空！");
			return false;
		} else if (create.refundday.value=="") {
			alert("全额退款日不能为空！");
			return false;
		} else if (create.dayprice.value=="") {
			alert("日租价不能为空！");
			return false;
		} else if (create.roomdesc.value=="") {
			alert("房屋描述不能为空！");
			return false;
		} else if (create.userule.value=="") {
			alert("使用规则不能为空！");
			return false;
		} else if (create.facility.value=="") {
			alert("设施服务不能为空！");
			return false;
		} else if (create.address.value=="") {
			alert("地址不能为空！");
			return false;
		}				
	}
</script>
<body>
<div id="wrapper">
		<jsp:include page="header.jsp"></jsp:include>

	<div align="center">
		<form action="createHouse" method="post" enctype="multipart/form-data" name="create" onsubmit="return submits(this);">
		<table>
			<tr>
				<td width="10%">房屋名称：</td>
				<td width="35%"><input type="text" name="name"></td>
				<td width="10%">全额退款日：</td>
				<td width="35%"><input type="text" name="refundday"></td>
			</tr>
			<tr>
				<td>发票：</td>
				<td><input type="radio" name="bill" checked="checked" value="1" >提供
					<input type="radio" name="bill" value="2">不提供</td>
				<td>日租价：</td>
				<td><input type="text" name="dayprice"></td>
			</tr>
			<tr>
				<td>出租类型：</td>
				<td><input type="radio" name="renttype" checked="checked" value="1">整租
					<input type="radio" name="renttype" value="2">单间
					<input type="radio" name="renttype" value="3">床位</td>
				<td>房屋描述：</td>	
				<td rowspan="2"><textarea rows="3" cols="30" name="roomdesc"></textarea></td>			
			</tr>
			<tr>
				<td>房屋类型：</td>
				<td><select name="kind">
					<option value="1">酒店
					<option value="2">客栈
					<option value="3">旅馆
					</select></td>		
			</tr>
			<tr>
				<td>面积：</td>
				<td><input type="text" name="area">m²</td>
				<td>使用规则：</td>
				<td rowspan="2"><textarea rows="3" cols="30" name="userule"></textarea></td>
			</tr>
			<tr>
				<td>可住人数：</td>
				<td><select name="guestnum">
					<option value="1">1
					<option value="2">2
					<option value="3">3
					<option value="4">4
					</select></td>				
			</tr>
			<tr>
				<td>床位数：</td>
				<td><select name="bednum">
					<option value="1">1
					<option value="2">2
					<option value="3">3
					<option value="4">4
					</select></td>
				<td>设施服务：</td>
				<td rowspan="2"><textarea rows="3" cols="30" name="facility"></textarea></td>
			</tr>
			<tr>
				<td>卧室数：</td>
				<td><select name="bedroomnum">
					<option value="1">1
					<option value="2">2
					<option value="3">3
					<option value="4">4
					</select></td>				
			</tr>
			<tr>
				<td>房间数：</td>
				<td><select name="roomnum">
					<option value="1">1
					<option value="2">2
					<option value="3">3
					<option value="4">4
					</select></td>
				<td>地址：</td>
				<td rowspan="2"><textarea rows="3" cols="30" name="address"></textarea></td>
			</tr>
			<tr>
				<td>床型：</td>
				<td><select name="bedtype">
					<option value="1">双人床
					<option value="2">单人床
					<option value="3">高低床				
					</select></td>		
			</tr>
			<tr>
				<td>卫生间数：</td>
				<td><select name="toiletnum">
					<option value="1">1
					<option value="2">2
					<option value="3">3
					</select></td>
				<td>付款规则：</td>
				<td><select name="payrule">
					<option value="1">严格
					<option value="2">不严格
					</select></td>
			</tr>
			<tr>
				<td>入住时间：</td>
				<td><select name="checkinTime">
					<option value="1">14:00
					<option value="2">17:00
					<option value="3">9:00					
					</select></td>
				<td>房屋图片：</td>
				<td><input type="file" name="pic"></td>
			</tr>
			<tr>
				<td>退房时间：</td>
				<td><select name="checkoutTime">
					<option value="1">15:00
					<option value="2">19:00
					<option value="3">10:00					
					</select></td>
				<td></td>
				<td><input type="file" name="pic"></td>
			</tr>
			<tr>
				<td>最小天数：</td>
				<td><input type="text" name="minday"></td>
				<td></td>
				<td><input type="file" name="pic"></td>
			</tr>
			<tr>
				<td>最大天数：</td>
				<td><input type="text" name="maxday"></td>
				<td colspan="2"><s:fielderror cssStyle="text-align: center; background-color: gray;"/></td>
			</tr>
			<tr align="center">
				<td colspan="4">
				<input type="submit" value="提交审核">
				<input type="reset" value="清空 ">
				</td>
			</tr>		
		</table>		
		</form>	
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>		
</div>

	<!-- 	
	<div style="width: 1000px; ">
		<s:form action="" method="post" enctype="multipart/form-data">			
		<div style="width: 50%; float: left;">		
		<s:textfield name="name" label="房屋名称"/>
		<s:radio list="#{'1':'提供','2':'不提供'}" name="bill" value="1" label="发票"/>
		<s:radio list="#{'1':'整租','2':'单间','3':'床位'}" name="renttype" value="1" label="出租类型"/>
		<s:select list="#{'1':'酒店','2':'客栈','3':'旅馆'}" name="kind" label="房屋类型"/>
		<s:textfield name="area" label="面积" />
		<s:select list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}" name="guestnum" label="可住人数" />
		<s:select list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}" name="bednum" label="床位数" />
		<s:select list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}" name="bedroomnum" label="卧室数" />
		<s:select list="#{'1':'1','2':'2','3':'3','4':'4','5':'5'}" name="roomnum" label="房间数" />
		<s:select list="#{'1':'双人床','2':'单人床','3':'高低床'}" name="bedtype" label="床型" />
		<s:select list="#{'1':'1','2':'2','3':'3'}" name="toiletnum" label="卫生间数" />
		<s:select list="#{'1':'14:00','2':'17:00','3':'9:00'} " name="checkinTime" label="入住时间"/>
		<s:select list="#{'1':'14:00','2':'17:00','3':'9:00'} " name="checkoutTime" label="退房时间"/>
		<s:textfield name="minday" label="最小天数"/>
		<s:textfield name="maxday" label="最大天数"/>			
		</div>		
		<div style="width: 50%;  float: right;">		
		<s:textfield name="refundday" label="全额退款日" />					
		<s:textfield name="dayprice" label="日租价" />
		<s:textarea name="roomdesc" rows="3" cols="40" label="房屋描述"/>
		<s:textarea name="userule" rows="3" cols="40" label="使用规则"/>
		<s:textarea name="facility" rows="3" cols="40" label="设施服务"/>
		<s:textarea name="address" rows="3" cols="40" label="地址"/>
		<s:select list="#{'1':'严格','2':'不严格'}" name="payrule" label="付款规则"/>
		<s:file name="picture1" label="房屋图片"/>
		<s:file name="picture2" />
		<s:file name="picture3" />
		<s:reset />				
		</div>
		</s:form>								
	</div>
	-->	
</body>
</html>