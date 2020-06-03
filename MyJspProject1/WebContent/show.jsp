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
		request.setCharacterEncoding("utf-8"); //只设置post方式的请求编码 
		String name=request.getParameter("uname");
		int age=Integer.parseInt(request.getParameter("uage"));
		String pwd=request.getParameter("upwd");
		String [] hobbies=request.getParameterValues("uhobbies");
	%>
	祖册成功，信息如下：<br/>
	姓名:<%=name %>
	年龄:<%=age %>
	爱好:<br/>
	<%
	if(hobbies!=null){
		for(String hobby:hobbies){ 
			out.print(hobby+"&nbsp");
		}
	}
	%>
</body>
</html>