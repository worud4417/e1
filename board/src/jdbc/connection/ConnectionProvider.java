package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException{
		
		String jdbcUrl = "jdbc:mysql://localhost:3307/test1?characterEncoding=utf8&serverTimezone=UTC";
		String username = "test1";
		String pw = "test1";
		
		/*return DriverManager.getConnection("jdbc:apache:commons:dbcp:test1");*/
		return DriverManager.getConnection(jdbcUrl, username, pw);
	}
}
