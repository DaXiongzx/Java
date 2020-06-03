package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentService;

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ɾ��
		request.setCharacterEncoding("utf-8");
		//����ǰ�˴�����ѧ��
		int no=Integer.parseInt(request.getParameter("sno"));
		StudentService service =new StudentService();
		boolean result=service.deleteStudentBySno(no);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if (result) {
			//response.getWriter().println("ɾ���ɹ�!");
			response.sendRedirect("QueryAllStudentServlet");//���²�ѯ
		}else {
			//response.getWriter().print("ɾ��ʧ��");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}