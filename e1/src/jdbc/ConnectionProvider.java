package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost:3307/test1?characterEncoding=utf8&serverTimezone=UTC";
		String id = "test1";
		String password="test1";
		
		Connection conn = DriverManager.getConnection(jdbcUrl, id, password);
		return conn;
	}
}
