package org.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.dao.LoginDao;
import org.test.entity.Login;


public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理登录
		System.out.println("do servlet");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		System.out.println(name);
		System.out.println(pwd);

		Login login=new Login(name,pwd);
		
		//调用模型层的登录功能
		int result=LoginDao.login(login);
		if(result>0) {
			System.out.println("success");
			response.sendRedirect("welcome.jsp");
			
		}else {
			System.out.println("fail");
			response.sendRedirect("index.jsp");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
