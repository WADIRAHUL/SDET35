package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UnitTesting {
	public static void main(String[] args) throws Throwable {
		String projectName = "rahul";
		Connection con = null;
		ResultSet res;
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/details";
			String un = "root";
			String pwd = "root";
			
			con = DriverManager.getConnection(dbUrl, un, pwd);
			String query = "select un from d1;";
			res = con.createStatement().executeQuery(query);
			while (res.next()) {
				String actProjectName = res.getString(1);
				if (actProjectName.equalsIgnoreCase(projectName)) {
					System.out.println("Pass:: The project name is correct");
					break;
				}else {
					System.out.println("Fail:: The project name is not correct");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}

	}
}
