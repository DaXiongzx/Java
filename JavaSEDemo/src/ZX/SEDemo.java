package ZX;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Class;
class ConnectionManager{
	//private static final Connection con;
	private static  String driver="com.mysql.cj.jdbc.Driver";
	private static  String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
	private static String user="root";
	private static  String password="112233";
	public static Connection getConnection() {
		Connection con=null;
		try {
		Class.forName(driver);
		con=DriverManager.getConnection(url, user, password);
	    }
		catch(Exception e) {
			e.printStackTrace();
		}
	return con;
}
}
public class SEDemo {
	public static void main(String[] args) {
		Connection con=ConnectionManager.getConnection();
		System.out.println(con.getClass());
		Statement statement=con.createStatement();
		String sql="select * from emp";
		ResultSet rs=statement.executeQuery(sql);
		String job=null;
		String id =null;
		while(rs.next()) {
			job=rs.getString("job");
			id=rs.getString("ename");
			System.out.println(job+'\t'+id);
		}
	}
}

		/*public static void main(String[] args) {
			 Connection con;
		     String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
			String user="root";
			String password="112233";
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url, user, password);
				if(!con.isClosed()) 
					System.out.println("Succeeded connecting to the Database!");
					
				Statement statement=con.createStatement();
				String sql="select * from emp";
				ResultSet rs=statement.executeQuery(sql);
				System.out.println("--------");
				System.out.println("执行结果如下：");
				System.out.println("--------");
				String job =null;
				String id=null;
				while (rs.next()) {
					job=rs.getString("job");
					id=rs.getString("ename");
					System.out.println(id+"\t"+job);
				}
				rs.close();
				con.close();
		}catch(ClassNotFoundException e) {
			System.out.println("can not find the driver");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("数据库数据获取成功！");
		}

	}
}*/



