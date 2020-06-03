<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		//客户端
		
		Cookie[] cookies=request.getCookies();
	for(Cookie cookie:cookies){
		out.print(cookie.getName()+"--"+cookie.getValue()+"<br/>");
	}
	%>

</body>
</html>