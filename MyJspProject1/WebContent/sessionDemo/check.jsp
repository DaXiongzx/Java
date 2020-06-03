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
		
		if (name.equals("zs")&&pwd.equals("abc")){ //只有登录成功，session中才会存在uname,upwd
			session.setAttribute("uname",name);
			session.setAttribute("upwd",pwd);
			System.out.println("sessionId"+session.getId());
			//Cookie cookie=new Cookie("uname",name); 
			//response.addCookie(cookie);服务端在第一次响应客户端时，会发送一个JSESSIONID的cookie
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}else{
			response.sendRedirect("login.jsp");
		}
	
		 
		
	%>
</body>
