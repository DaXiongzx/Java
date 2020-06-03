package ch9;
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
	public void add(String Player,int Number_pressed,int result,int id) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		 String sql = "insert into shuffle (Player,Number_pressed,Result,id) values(?,?,?,?)";
		 PreparedStatement pstmt;
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1, Player);
	    pstmt.setInt(2, Number_pressed);
	    pstmt.setInt(3, result);
	    pstmt.setInt(4, id);
	    i=pstmt.executeUpdate();
	    pstmt.close();
	   // conn.close();
	}
	public void update(String Player,int Number_pressed,int result,int id) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		String updatesql="update shuffle set Number_Pressed=?,Result=? where Player=?";
		PreparedStatement stat=conn.prepareStatement(updatesql);
		stat.setInt(1, Number_pressed);
		stat.setInt(2, result);
		stat.setString(3, Player);
		stat.executeUpdate();
	}
	public String show() throws ClassNotFoundException, SQLException {
		String name="Kobe";
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		String sql="select * from shuffle ";//where result=1 order by Number_Pressed";
		Statement statement=conn.createStatement();
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			name=rs.getString("Player");
			System.out.println(rs.getString("Player")+" "+rs.getInt("Number_Pressed")+" "+rs.getInt("Result")+" "+rs.getInt("id"));
			//System.out.println("ok");
		}
		//else name="Kobe";
	 //   conn.close();
	   // System.out.println(name);
	    //System.out.println("no");
	    return name;
	}
}
