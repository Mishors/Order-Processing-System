package main;

import java.sql.*;

import dbManager.Authenticator;
import dbManager.Connector;
import dbManager.IAuthenticator;
import dbManager.IConnector;
import operations.CurrentUser;
import operations.IUserOperations;
import operations.UserOperations;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IConnector connector = Connector.getInstance();
		connector.connect();
		IUserOperations user = new UserOperations();

		IUserOperations operator = new UserOperations();
		connector.run("select * from books");
		try {
			do {
				for (int i = 0; i < 6; i++) {
					System.out.print(
							connector.getResultSet().getString(i + 1) + " -- ");
				}
				System.out.println();
			} while (connector.getResultSet().next());
			System.out.println("-----------------------------");
			String[] attributes = { "category" };
			String[] values = { "art" };
			ResultSet resultSet = operator.searchForBooksAdvanced("category='art' and publisher_name='pub'");
			// connector.run("select * from users");
			do {
				for (int i = 0; i < 6; i++) {
					System.out.print(
							connector.getResultSet().getString(i + 1) + " -- ");
				}
				System.out.println();
			} while (connector.getResultSet().next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// do {
		// for (int i = 0; i < 6; i++) {
		// System.out.print(connector.getResultSet().getString(i+1) + " ");
		// }
		// System.out.println();
		// } while (connector.getResultSet().next());
		//
		// connector.run("update users set first_name='zook' where
		// email='a@c.o'");
		//
		// connector.run("select * from users");
		// do {
		// for (int i = 0; i < 6; i++) {
		// System.out.print(connector.getResultSet().getString(i+1) + " ");
		// }
		// System.out.println();
		// }while (connector.getResultSet().next());
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// CurrentUser u = CurrentUser.getInstance();
		// u.setEmail("a@c.o");
		// for (int i = 0; i < 6; i++)
		// System.out.println(user.getUserInfo("a@c.o")[i]);
		// String[] attributes = { "first_name", "last_name", "user_password" };
		// String[] values = { "zook", "zook Bardo", "4321" };
		//
		// user.editUserInfo(attributes, values);
		// System.out.println("---------------------------------");
		// for (int i = 0; i < 6; i++)
		// System.out.println(user.getUserInfo("a@c.o")[i]);

		// IAuthenticator authenticator = Authenticator.getInstance();
		// String [] temp = {"a@c.o", "aa", "1234", "a", "b", "alexs"};
		// authenticator.addNewUser(temp);

		// System.out.println(authenticator.authenticate("a@c.o", "12304"));
		//
		// Class.forName("com.mysql.jdbc.Driver");
		// connect = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/book_store?useSSL=false",
		// "root", "admin");
		// // Statements allow to issue SQL queries to the database
		// statement = connect.createStatement();
		// // Result set get the result of the SQL query
		// resultSet = statement.executeQuery("select * from users");
		// while (resultSet.next())
		// System.out.println(resultSet.getString(3));
		//
		// } catch (ClassNotFoundException | SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
