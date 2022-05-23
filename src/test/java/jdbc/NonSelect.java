package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class NonSelect {
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		int res=0;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "INSERT INTO D1 (UN,PWD) VALUES('X123', 'Y123');";
			res = con.createStatement().executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			if (res==1) {
				System.out.println("Successfully Inserted");
			} else {
				System.out.println("Not Inserted");
			}
		}
	}
}
