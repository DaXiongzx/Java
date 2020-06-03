package GameConsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectionManager {
	int i=0;
	Connection conn = null;
	public static String driver="com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.Driver
	public static String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";//jdbc:mysql://localhost:3306/testdb(testdb为数据库的名字)  
	public static String user="root";
	public static String password="112233";
	public void add(String id,String Player_Name,int Number_Pressed,int Result) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		//应该先创建statement 在创建sql
		//stmt=connection.createStatement();
		//String sql=null;
		//stmt.execuateUpdate(sql);
		 String sql = "insert into gameconsole (ID,Player_Name,Number_Pressed,Result) values(?,?,?,?)";
		 PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql); //prepareStatement()需要以sql作为参数 预编译
	    pstmt.setString(1, id);
	    pstmt.setString(2,Player_Name);
	    pstmt.setInt(3, Number_Pressed);
	    pstmt.setInt(4, Result);
	    i=pstmt.executeUpdate();//没有sql
	    pstmt.close();
	   // conn.close();
	}
	public String show() throws ClassNotFoundException, SQLException {
		String name="Kobe";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		String sql="select * from gameconsole where result=1 order by Number_Pressed";
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		if(rs.next()) {
			//rs.get
			name=rs.getString("Player_Name");
			System.out.println(name);
		}
		else name="Kobe";
	    System.out.println(name);
	    return name;
	}

}
