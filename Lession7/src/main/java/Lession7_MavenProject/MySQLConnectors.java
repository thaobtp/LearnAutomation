package Lession7_MavenProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @date 02/08/2016
 * @author ThaoBTP
 * @create connector to database localhost, query data
 */
public class MySQLConnectors {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/sactory";

	// Database
	static final String USER = "root";
	static final String PASS = "";

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	//query data from table and return resultSet
	public static ResultSet executeQuery(String myQueries) throws SQLException {
		try {
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query
			stmt = conn.createStatement();
			rs = stmt.executeQuery(myQueries);
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		}
		return rs;
	}

	//Close connection
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {

		}
	}
}
