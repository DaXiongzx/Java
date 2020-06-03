package Shuffle;
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
	//Class.forName(driver);
	public static String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
	public static String user="root";
	public static String password="112233";
	public void add(String Player,int Number_pressed,int result) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		 String sql = "insert into shuffle (Player,Number_pressed,Result) values(?,?,?)";
		 PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1, Player);
	    pstmt.setInt(2, Number_pressed);
	    pstmt.setInt(3, result);
	    i=pstmt.executeUpdate();
	    pstmt.close();
	   // conn.close();
	}
	public String show() throws ClassNotFoundException, SQLException {
		String name="Kobe";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		String sql="select * from shuffle where result=1 order by Number_Pressed";
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		if(rs.next()) {
			name=rs.getString("Player_Name");
			System.out.println("ok");
		}
		else name="Kobe";
	    System.out.println(name);
	    return name;
	}
}


