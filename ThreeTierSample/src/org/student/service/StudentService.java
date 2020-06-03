package org.student.service;

import java.util.List;

import org.student.dao.StudentDao;
import org.student.entity.Student;

//业务逻辑层：逻辑性的增删改查（增：查+增） ，对dao层进行的组装
public class StudentService {
	StudentDao studentDao=new StudentDao();
	
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
	
	public Student queryStudentBysno(int sno){ //根据学号查询学生
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
		if(!studentDao.isExist(student.getSno())) { //不存在
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("添加失败，此人已存在");
			return false;
		}
	}
}
