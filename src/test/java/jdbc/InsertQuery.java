package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertQuery {
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "INSERT INTO D1 (UN, PWD) VALUES (?, ?);";
			
			PreparedStatement prp = con.prepareStatement(query);
			prp.setString(1, "Rahul");
			prp.setString(2, "Rakesh");
			prp.execute();
			System.out.println("Successfull Inserted....");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
