package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;


public class QueryAllStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.print("1");
		StudentService service=new StudentService();
		List<Student> students=service.queryAllStudents();
		System.out.println(students);
		request.setAttribute("students", students);
		//因为requests域中有数据，因此需要通过请求转发的方式跳转（重定向会丢失request域  把数据放到request域中
		//pageContext<request<session<application
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
