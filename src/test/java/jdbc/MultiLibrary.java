package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MultiLibrary {
	public static void main(String[] args) throws Throwable {
		String sarr [] [] = {
				{"admin1", "manager2"},
				{"trainee", "trainee"},
				{"Rahul2", "Rahul123"},
				{"Rakesh2", "Rakesh123"}
		};
		String dbUrl = "jdbc:mysql://localhost:3306/details";
		String un = "root";
		String pwd = "root";

		Connection con = DriverManager.getConnection(dbUrl, un, pwd);
		String query = "insert into d1(un, pwd) values(?, ?);";

		DataBaseLibrary db = new DataBaseLibrary(query);
		db.insertData(query, sarr);
		System.out.println("Done");
	}
}

