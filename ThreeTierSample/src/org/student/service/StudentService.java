package org.student.service;

import java.util.List;

import org.student.dao.StudentDao;
import org.student.entity.Student;

//ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨������+���� ����dao����е���װ
public class StudentService {
	StudentDao studentDao=new StudentDao();
	
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	public Student queryStudentBysno(int sno){ //����ѧ�Ų�ѯѧ��
		return studentDao.queryStudentBySno(sno);
	}
	
	public boolean updateStudentBySno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}
		return false;
		
	}
	
	
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
		return false;
	}
	
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSno())) { //������
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("����ʧ�ܣ������Ѵ���");
			return false;
		}
	}
}