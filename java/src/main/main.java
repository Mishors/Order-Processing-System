package main;

import java.sql.*;

import dbManager.Authenticator;
import dbManager.Connector;
import dbManager.IAuthenticator;
import dbManager.IConnector;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub



			IConnector connector = Connector.getInstance();
			connector.connect();
			
			IAuthenticator authenticator = Authenticator.getInstance(); 
//			String [] temp = {"a@c.o", "aa", "1234", "a", "b", "alexs"};
//			authenticator.addNewUser(temp);
			
			System.out.println(authenticator.authenticate("a@c.o", "12304"));
//			
//			Class.forName("com.mysql.jdbc.Driver");
//			connect = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/book_store?useSSL=false",
//					"root", "admin");
//			// Statements allow to issue SQL queries to the database
//			statement = connect.createStatement();
//			// Result set get the result of the SQL query
//			resultSet = statement.executeQuery("select * from users");
//			while (resultSet.next())
//				System.out.println(resultSet.getString(3));
//
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
