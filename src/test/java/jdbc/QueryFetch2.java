package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class QueryFetch2 {
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "SELECT * FROM D1;";
			ResultSet res = con.createStatement().executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString(1)+" "+res.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
