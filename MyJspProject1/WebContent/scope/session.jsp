<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		session.setAttribute("hello","world");
		//request.getsessionDispatcher("session1.jsp").forward(session, response);
		response.sendRedirect("session1.jsp");
		%>

</body>
</html> 