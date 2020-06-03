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
public class UpdateStudentServlet extends HttpServlet { //�޸�

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ���޸ĵ��˵�ѧ��
		System.out.print("ok:");
		String strno=request.getParameter("sno");
		strno=strno.trim();
		System.out.print(strno.length());
		int no=Integer.parseInt(strno);
		System.out.print("ok:");
		System.out.print(no);
		//��ȡ�޸ĺ������
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		//���޸ĺ�����ݷ�װ��һ��ʵ������
		Student student=new Student(name,age,address);
		
		StudentService service=new StudentService();
		boolean result=service.updateStudentBySno(no, student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if(result) {
			//response.getWriter().print("�޸ĳɹ���");
			response.sendRedirect("QueryAllStudentServlet"); //request��û������ ���ض���QueryAllStudentServlet����ʾ����
		}else {
			//response.getWriter().print("�޸�ʧ��");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}