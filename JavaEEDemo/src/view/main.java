package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
	/*public static Statement stt;
	public void add(String Player,int Number_pressed) {
		try {
		String sql="insert into shuffle values("+Player+",'"+Number_pressed+"');";
		Connection conn=getConnection();
		stt=conn.createStatement();
		stt.executeQuery(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}*/
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//Statement stt;
		int i=0;
		Connection conn = null;
		String driver="com.mysql.cj.jdbc.Driver";
		//Class.forName(driver);
		String url="jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC";
		String user="root";
		String password="112233";
		String Player="zxzxzccc";
		int Number_pressed=63;
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		 String sql = "insert into shuffle (Player,Number_pressed) values(?,?)";
		 PreparedStatement pstmt;
		//String sql="insert into shuffle values("+Player+",'"+Number_pressed+"');";
	    Statement statement=conn.createStatement();
	    pstmt=(PreparedStatement) conn.prepareStatement(sql);
	    pstmt.setString(1, Player);
	    pstmt.setInt(2, Number_pressed);
	    i=pstmt.executeUpdate();
	    pstmt.close();
	   // statement.executeUpdate(sql);
	    conn.close();

		//try {
			//Class.forName(driver);
			//con=DriverManager.getConnection(url, user, password);
			//if(!con.isClosed()) 
				//System.out.println("Succeeded connecting to the Database!");
				
			//Statement statement=con.createStatement();
			//String sql="select * from shuffle";
			//ResultSet rs=statement.executeQuery(sql);
			/*System.out.println("--------");
			System.out.println("执行结果如下：");
			System.out.println("--------");
			String job =null;
			String id=null;
			while (rs.next()) {
				job=rs.getString("Player");
				//id=rs.getString("ename");
				System.out.println(job);
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
	}*/

}
}
