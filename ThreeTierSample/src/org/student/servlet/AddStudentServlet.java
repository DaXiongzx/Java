package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("sno"));
		String name=request.getParameter("sname");
		int age=Integer.parseInt(request.getParameter("sage"));
		String address=request.getParameter("saddress");
		Student student=new Student(no,name,age,address);
		
		StudentService studentService=new StudentService();
		boolean result=studentService.addStudent(student);
		/*
		 * out request response session application
		 * out: PrintWriter out=response.getWriter();
		 * session: request.getSession()
		 * application: request.getServletContext()
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		/*PrintWriter out=response.getWriter();
		if(result) {//out Ϊjsp���ö���
			
			//out.print("���ӳɹ���");
			response.sendRedirect("QueryAllStudentServlet");
		}else {
			//response.s
			//out.print("����ʧ��");
		}*/
		if(!result) {
			request.setAttribute("error", "addError"); //�������ʧ�ܣ���request����һ������error
		}else {
			//���ӳɹ�
			request.setAttribute("error","noaddError");
		}
		//response.sendRedirect("QueryAllStudentServlet");
		request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}