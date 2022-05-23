package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MultiQuery {
	public static void main(String[] args) throws Throwable {
		Connection con = null;
		try {
			String sarr [] [] = {
					{"admin1", "manager2"},
					{"trainee", "trainee"},
					{"Rahul2", "Rahul123"},
					{"Rakesh2", "Rakesh123"}
			};
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "insert into d1(un, pwd) values(?, ?);";
			PreparedStatement prp = con.prepareStatement(query);
			
			for(int i=0; i<=sarr.length-1; i++) {
				prp.setString(1, sarr[i][0]);
				prp.setString(2, sarr[i][1]);
				prp.execute();
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
