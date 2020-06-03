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
	Cookie cookie1=new Cookie("name","zs");
	Cookie cookie2=new Cookie("pwd","abc");
	
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	response.sendRedirect("result.jsp");
		
	%>
</body>
</html>