package ch9;

import java.sql.*;

public class Activity {
	public static void main(String args[])
	{
		try
		{
			String str = "select * from Authors where city like 'S%'";
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC","root","112233");Statement stmt = con.createStatement();)
			{
				ResultSet rs = stmt.executeQuery(str);
				System.out.println("Author ID\tAuthor Name\tCity");
				System.out.println("----------------------------------------------------------------------");
				while(rs.next())
				{
					String id = rs.getString("au_id");
					String name = rs.getString("au_name");
					String city = rs.getString("city");
					System.out.print(id);
					if(name.length()<=7)
					{
						System.out.print(name + "\t\t");
					}
					else
					{
						System.out.print("\t" + name +"\t");
					}
					System.out.println(city);
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error occurred");
			System.out.println("Error:"+ex);
		}
	}

}
