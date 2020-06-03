package org.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import org.test.entity.Login;

//ģ�Ͳ� ���ڴ����¼ model
public class LoginDao {
	public static int login(Login login) {
		String driver="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.Driver
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";//jdbc:mysql://localhost:3306/testdb(testdbΪ���ݿ������)  
		String user="root";
	    String password="112233";
		int flag=-1;//-1:ϵͳ�쳣 0���û������������� 1���ɹ�
		//boolean flag=false;//��־
		int result=-1;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//��¼
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url, user, password);
			String sql="select * from login where UNAME=? and UPWD=?";
			pstmt=connection.prepareStatement(sql);
			System.out.println("this is name "+login.getUname());
			System.out.println("this is pwd"+login.getUpwd());
			
			pstmt.setString(1, login.getUname());
			pstmt.setString(2, login.getUpwd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
			if(result>0) {
				flag=1;
			}else {
				flag=0;
			}
		}catch(ClassNotFoundException e) {
			flag=-1; //��¼ʧ�� ϵͳ�쳣
			e.printStackTrace();
		}catch(SQLException e) {
			flag=-1;
			e.printStackTrace();
		}catch(Exception e) {
			flag=-1;
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(connection!=null) connection.close();
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}

}
