<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello index1你好
	<%="当前项目的虚拟路径" +application.getContextPath()+"<br/>"%>
	<%="当前项目的绝对路径" +application.getRealPath("/MyJspProject1")+"<br/>" %>
	<%!
		public String bookName; 
	    public Date date=new Date();
		public void init(){
			bookName="yes"+date;
		}
		
	%>
	=====hello index1 你好 
	<%
		String name ="zhansgan"; 
		out.print(name+"<br />");
		init();
	%>
	<%="hello" +bookName  %>
</body>
</html>