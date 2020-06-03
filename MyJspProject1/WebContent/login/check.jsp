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
		out.print(name);
		out.print(pwd);
		if(name.equals("zs")&&pwd.equals("abc")){
			//response.sendRedirect("success.jsp"); 重定向可能会导致数据丢失
			
			request.getRequestDispatcher("success.jsp").forward(request,response);  //请求转发，可以获取到数据，地址栏没有改变，任然保留转发时的页面 
		}else{
			out.print("用户名或者密码有问题");
		}
	%>
</body>
</html>