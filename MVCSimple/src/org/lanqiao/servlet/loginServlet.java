package org.lanqiao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.dao.LoginDao;
import org.lanqiao.entity.Login;

/**
 * Servlet implementation class LoginServlet
 */
public class loginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理登录
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("upwd");
		Login login=new Login(name,pwd);
		
		//调用模型层的登录功能
		int result=LoginDao.login(login);
		if(result>0) {
			response.sendRedirect("welcome");
			
		}else {
			System.out.println("fail");
			response.sendRedirect("login.jsp");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

