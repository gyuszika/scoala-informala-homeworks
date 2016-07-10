package eshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection(String type, String host, int port, String dataBase, String user,
			String password){
		Connection connection = null;
		DriverManager.setLoginTimeout(60);
		try {
			String url = new StringBuilder().append("jdbc:").append(type).append("://").append(host).append(":")
					.append(port).append("/").append(dataBase).append("?user=").append(user).append("&password=")
					.append(password).toString();

			// System.out.println("URL: " + url);
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.err.println("Cannot connect to the database: " + e.getMessage());
		}
		return connection;
	}
	

}
