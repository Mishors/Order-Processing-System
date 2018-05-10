package dbManager;

import java.sql.*;

public class Connector implements IConnector {

	private static Connector connector;
	private Connection connection;
	private Statement statement;
	private final String DB_NAME, DB_USER_NAME, DB_USER_PASS;
	
	private Connector() {
		connector  = null;
		connection = null;
		DB_NAME = "book_store";
		DB_USER_NAME = "root";
		DB_USER_PASS = "admin";
	}
	
	public static Connector getInstance() {
		if(connector == null)
			connector = new Connector();
		return connector;
	}
	
	@Override
	public void connect() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false"
					, DB_USER_NAME, DB_USER_PASS);
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error while connecting to database !");
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet run(String command) {
		try {
			return statement.executeQuery(command);
		} catch (SQLException e) {
			System.out.println("Error while executing query:");
			System.out.println("\"" + command + "\"");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
