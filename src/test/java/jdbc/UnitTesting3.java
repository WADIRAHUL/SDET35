package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UnitTesting3 {
	public static void main(String[] args) throws Throwable {
		String projectName = "rahul";
		Connection con = null;
		ResultSet res;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			
			System.out.println(pwd);
			
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "select un from d1;";
			res = con.createStatement().executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
