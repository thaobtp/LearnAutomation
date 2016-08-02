package Lession7_MavenProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.annotations.Test;

/**
 * @date 02/08/2016
 * @author ThaoBTP
 * @connect to database, query user name from user table
 */
public class Lession7_ConnectToDataBase {

	@Test
	public void getUserNameInDatabase() throws SQLException {
		String mySql = String
				.format(" SELECT username FROM sactory.user limit 10; ");
		// get data from database
		ResultSet rs = MySQLConnectors.executeQuery(mySql);
		while (rs.next()) {
			String listItem = rs.getString("username");
			System.out.println(listItem);
		}
		//Close connection
		MySQLConnectors.close();
	}
}
