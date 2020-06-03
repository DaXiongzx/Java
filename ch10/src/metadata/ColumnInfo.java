package metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class ColumnInfo {

	public static void main(String[] args) {
		// TODO ??????????????
		Scanner sc=new Scanner(System.in);
		String tablename;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC","root","112233"))
			{
				System.out.println("Enter the table name:");
				tablename=sc.nextLine();
				String str="select *from "+tablename+" ";
				try(Statement stmt=con.createStatement();)
				{
					ResultSet rs=stmt.executeQuery(str);
					ResultSetMetaData rsmd=rs.getMetaData();
					rs.next();
					System.out.println("=============================================================================");
					System.out.println("Number of Attributes in the "+tablename+"table: "+rsmd.getColumnCount());
					System.out.println("");
					System.out.println("-----------------------------------------------------------------------------");
					for(int i=1;i<=rsmd.getColumnCount();i++)
					{
						System.out.println(rsmd.getColumnName(i)+" : "+rsmd.getColumnTypeName(i));
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
	}

}