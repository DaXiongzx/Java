package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;

/**
 * Servlet implementation class QueryStudentBySno
 */
public class QueryStudentBySno extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String strno=request.getParameter("sno");
		int no=Integer.parseInt(strno);
		StudentService service=new StudentService();
		Student student=service.queryStudentBysno(no);
		//System.out.print(student);
		//�����˵���Ϣͨ��ǰ̨jsp��ʾ
		request.setAttribute("student", student); //����ѯ����ѧ���ŵ�request����
	    //���request��û�����ݣ�ʹ���ض�����תresponse.sendRedirect();
		//��������� ʹ������ת����ת request.setAttribute()
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}