package jdbctest;
import java.lang.*;
import java.sql.*;
public class ConnectionManager {
	public static Connection con;
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
	public static String user="root";
	public static String password="112233";
	public static Connection getconnection() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return con;
	}


}
