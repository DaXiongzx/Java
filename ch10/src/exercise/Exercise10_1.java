package exercise;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exercise10_1 {
    public void Menu()
    {
        System.out.println("############Menu###########");
        System.out.println("1.View");
        System.out.println("2.Insert");
        System.out.println("3.Update");
        System.out.println("4.Detele");
        System.out.println("5.Exit");
        System.out.println("Please enter your choice:");
    }
    public static void main(String[] args) {
        // TODO ?????????????
        Exercise10_1 obj=new Exercise10_1();
        Scanner s=new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?&useSSL=false&serverTimezone=UTC","root","112233");
            String str1="select *from authors where au_id=?";
            String str2="insert into authors values(?,?,?,?,?,?,?)";
            String str3="update authors set city=? where au_id=?";
            String str4="delete from authors where au_id=?";
            PreparedStatement stmt;
            ResultSet rs;
            int choice,r;
            while(true)
            {
                obj.Menu();
                choice=s.nextInt();
                switch(choice)
                {
                    case 1:
                        stmt=con.prepareStatement(str1);
                        stmt.setString(1,"1");
                        rs=stmt.executeQuery();
                        while(rs.next())
                        {
                            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7));
                        }
                        break;
                    case 2:
                        stmt=con.prepareStatement(str2);
                        stmt.setString(1, "4");
                        stmt.setString(2, "aaa");
                        stmt.setString(3, "bbb");
                        stmt.setString(4, "ccc");
                        stmt.setString(5, "ddd");
                        stmt.setString(6, "eee");
                        stmt.setString(7, "fff");
                        r=stmt.executeUpdate();
                        if(r==1)
                        {
                            System.out.println("Insert successfully!");
                        }
                        break;
                    case 3:
                        stmt=con.prepareStatement(str3);
                        stmt.setString(1, "fdsgsdfg");
                        stmt.setString(2, "A001");
                        r=stmt.executeUpdate();
                        if(r==1)
                        {
                            System.out.println("Update successfully!");
                        }
                        break;
                    case 4:
                        stmt=con.prepareStatement(str4);
                        stmt.setString(1,"A001");
                        r=stmt.executeUpdate();
                        if(r==1)
                        {
                            System.out.println("Delete successfully!");
                        }
                        break;
                    case 5:
                        System.out.println("Exit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice!Please your choice again!");
                }
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