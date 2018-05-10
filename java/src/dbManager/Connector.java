package dbManager;

import java.sql.*;

public class Connector implements IConnector {

	private static IConnector connector;
	private Connection connection;
	private Statement statement;
	private final String DB_NAME, DB_USER_NAME, DB_USER_PASS;

	private Connector() {
		connector = null;
		connection = null;
		DB_NAME = "book_store";
		DB_USER_NAME = "root";
		DB_USER_PASS = "admin";
	}

	public static IConnector getInstance() {
		if (connector == null)
			connector = new Connector();
		return connector;
	}

	@Override
	public void connect() {
		try {
			if (connection == null) {
				connection = DriverManager
						.getConnection(
								"jdbc:mysql://localhost:3306/" + DB_NAME
										+ "?useSSL=false",
								DB_USER_NAME, DB_USER_PASS);
				statement = connection.createStatement();
			}
		} catch (SQLException e) {
			System.out.println("Error while connecting to database !");
			e.printStackTrace();
		}

	}

	@Override
	public boolean run(String command) {
		try {
			return statement.execute(command);
		} catch (SQLException e) {
			System.out.println("Error while executing query:");
			System.out.println("\"" + command + "\"");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean closeConnection() {
			try {
				if(connection != null)
					connection.close();
				if(statement != null)
					statement.close();
				return true;
			} catch (SQLException e) {
				System.out.println("Error in closing connection!");
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public int getUpdatedCount() {
		try {
			return statement.getUpdateCount();
		} catch (SQLException e) {
			System.out.println("Error while getting update count!");
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public ResultSet getResultSet() {
		try {
			return statement.getResultSet();
		} catch (SQLException e) {
			System.out.println("Error while getting result set!");
			e.printStackTrace();
			return null;
		}
	}

}
