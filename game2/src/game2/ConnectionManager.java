package game2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ConnectionManager {
	int i=0;
	Connection conn = null;
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
	public static String user="root";
	public static String password="112233";
	public void add(String name,int score) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		 String sql = "insert into game2 (name,score) values(?,?)";
		 PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1, name);
	    pstmt.setInt(2,score);

	    i=pstmt.executeUpdate();
	    pstmt.close();
	   // conn.close();
	}
	/*public String show() throws ClassNotFoundException, SQLException {
		String name="Kobe";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		String sql="select * from gameconsole where result=1 order by Number_Pressed";
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		if(rs.next()) {
			name=rs.getString("Player_Name");
			System.out.println(name);
		}
		else name="Kobe";
	    System.out.println(name);
	    return name;
	}*/

}