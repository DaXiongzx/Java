package jdbctest;
import java.sql.*;

public class Test {
	public static void main(String[] args) {
		Connection con=ConnectionManager.getconnection();
    	Statement statement =con.createStatement();
    	String sql="select * from emp";
    	ResultSet rs=statement.executeQuery(sql);
    	String job=rs.getString("job");
    	String id=rs.getString("ename");
    	System.out.println(job+' '+id);
	}
}
