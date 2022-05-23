package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class QueryFetch {
	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		try {
			//STEP-1 Register to the database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			//STEP-2 get the connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			//STEP-3 write the query
			Statement stat = conn.createStatement();
			String query = "select * from S1";
			//STEP-4 execute the query
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//STEP-5 close the connection
			conn.close();
		}	
	}
}
