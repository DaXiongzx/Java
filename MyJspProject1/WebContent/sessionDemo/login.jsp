<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
		String uname;
	%>
	<%
		Cookie [] cookies=request.getCookies();
	for(Cookie cookie:cookies){
		if(cookie.getName().equals("uname")){
			uname=cookie.getValue();
		}
		
	}
	%>

	<form action="check.jsp" method="post">
		用户名：<input type="text" name="uname" value="<%=(uname==null?"":uname)%>"> <br/>
		密码： <input type="password" name="upwd"><br/>
		<input type="submit" value="登录"><br/>		
	</form>
	
</body>
</html>