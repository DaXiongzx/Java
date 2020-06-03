<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	request1.jsp
	<%
	out.print(request.getAttribute("hello"));
	//request.getRequestDispatcher("b.jsp").forward(request,response);
	%>
	
</body>
</html>