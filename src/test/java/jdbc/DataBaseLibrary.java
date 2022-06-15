package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseLibrary {
	static String dbUrl = "jdbc:mysql://localhost:3306/";
	static String dbUn = "root";
	static String dbPwd = "root";
	Connection con;
	Statement stmt;
	
	public DataBaseLibrary(String dbName) {
		try {
			con = DriverManager.getConnection(dbUrl+dbName, dbUn, dbPwd);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getData(String query) {
		try {
			return stmt.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertData(String query, String [][] sarr) {
		try {
			PreparedStatement prp = con.prepareStatement(query);
			
			for(int i=0; i<=sarr.length-1; i++) {
				prp.setString(1, sarr[i][0]);
				prp.setString(2, sarr[i][1]);
				prp.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
