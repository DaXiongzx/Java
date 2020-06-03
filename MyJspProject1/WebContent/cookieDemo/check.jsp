<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		
		Cookie cookie=new Cookie("uname",name);
		response.addCookie(cookie);
		
		response.sendRedirect("result.jsp");
		 
		
	%>
</body>
