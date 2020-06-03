package exercise;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exercise10_2 {

	public static void main(String[] args) {
		// TODO ??????????????
		// TODO ??????????????
		Scanner s=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC","root","112233");
			System.out.println("Please select table name(1.shuffle 2.authors):");
			int choice=s.nextInt();
			String name="";
			String id="";
			PreparedStatement stmt;
			ResultSet rs;
			if(choice==1)
			{
				name="shuffle";
				System.out.println("Please enter the id:");
				id=s.next();
				stmt=con.prepareStatement("select *from "+name+" where id=?");
				stmt.setString(1,id);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" ");
				}
			}
			else if(choice==2)
			{
				name="authors";
				System.out.println("Please enter the id:");
				id=s.next();
				stmt=con.prepareStatement("select *from "+name+" where au_id=?");
				stmt.setString(1,id);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				}
			}
			else
			{
				System.out.println("Can not find the table!");
				System.exit(0);
			}
			
			} catch (ClassNotFoundException e) {
			// TODO ???????? catch ??
			e.printStackTrace();
			} catch (SQLException e) {
			// TODO ???????? catch ??
			e.printStackTrace();
		}		
	}

}