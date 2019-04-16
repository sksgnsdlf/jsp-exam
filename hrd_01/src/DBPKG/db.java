package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	 public static Connection getConnection() throws Exception{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","hr","hr");
			return con;
	 }
	 public static void close(Connection conn) {
			try {
				if( conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
