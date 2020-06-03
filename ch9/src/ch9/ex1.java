package ch9;

import java.sql.SQLException;

public class ex1 {
	public static void main(String[] args) {
		ConnectionManager connection=new ConnectionManager();
		try {
			connection.show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection.show();
			connection.update("kobe1", 100, 1,90);
			connection .show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
