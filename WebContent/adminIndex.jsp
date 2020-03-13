<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
</head>
<body>

<center>   
   <table width="1200" height="700" >
	   <tr height="100" ><td colspan="2"><jsp:include page="adminHeader.jsp" /></td></tr>	
	
	   <tr height="500">   
	   <td width="200" ><jsp:include page="adminMenu.jsp"></jsp:include></td>
	   <td>
		<iframe src="http://localhost:8080/ShortRent/welcome.jsp" name="in" width="1000" height="500"></iframe> 
	   </td>
	   </tr>
	    
	   <tr height="100" ><td colspan="2" ><jsp:include page="footer.jsp"></jsp:include></td></tr>   
	</table>
</center>

</body>
</html>