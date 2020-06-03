<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	欢迎您：
	<%
		String name = (String)session.getAttribute("uname");
		
		if(name!=null){
			out.print(name);
			
			System.out.println();
	%>
	<a href="invalidate.jsp">注销</a>		
	<% 
		}else{
			response.sendRedirect("login.jsp");
		}
	%>
	welcome to the  welcome.jsp!
	<%
		
	%>

</body>
</html>