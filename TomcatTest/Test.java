package jdbctest;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import java.lang.Class;
public class Test {
	public static void main(String[] args) {
		Connection con=ConnectionManager.getconnection();
		Statement statement=con.createStatement();
		String sql="select * from emp";
		ResultSet rs=statement.executeQuery(sql);
		String job=null;
		String id=null;
	}
}
