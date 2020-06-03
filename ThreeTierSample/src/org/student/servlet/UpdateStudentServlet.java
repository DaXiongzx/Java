package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet { //修改

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取待修改的人的学号
		System.out.print("ok:");
		String strno=request.getParameter("sno");
		strno=strno.trim();
		System.out.print(strno.length());
		int no=Integer.parseInt(strno);
		System.out.print("ok:");
		System.out.print(no);
		//获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		//将修改后的内容封装到一个实体类中
		Student student=new Student(name,age,address);
		
		StudentService service=new StudentService();
		boolean result=service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(result) {
			//response.getWriter().print("修改成功！");
			response.sendRedirect("QueryAllStudentServlet"); //request域没有数据 用重定向到QueryAllStudentServlet来显示数据
		}else {
			//response.getWriter().print("修改失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
