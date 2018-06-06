package main;

import java.sql.*;

import dbManager.*;
import operations.*;

public class main {
	private static Connection connect = null;
	private static Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IConnector connector = Connector.getInstance();
		connector.connect();
		IUser user = new opertaions();
		try {
			
			System.out.println(
					"------------test selecting all books-----------------");
			System.out.println(connector.run("select * from books"));
			while (connector.getResultSet().next()) {
				for (int i = 0; i < 6; i++) {
					System.out.print(
							connector.getResultSet().getString(i + 1) + " -- ");
				}
				System.out.println();
			}
			System.out.println(
					"\n------------test search for books advanced-----------------");
			ResultSet resultSet = user.searchForBooksAdvanced(
					"category='art' or publisher_name='pub'");
			while (resultSet.next()) {
				for (int i = 0; i < 6; i++) {
					System.out.print(
							connector.getResultSet().getString(i + 1) + " -- ");
				}
				System.out.println();
			}

			System.out.println(
					"\n-------------test search for books----------------");
			String attribute = "category";
			String value = "art";
			resultSet = user.searchForBooks(attribute, value);
			while (resultSet.next()) {
				for (int i = 0; i < 6; i++) {
					System.out.print(resultSet.getString(i + 1) + " -- ");
				}
				System.out.println();
			}

			System.out
					.println("\n-------------test connector run----------------");
			connector.run("select * from users");
			while (connector.getResultSet().next()) {
				for (int i = 0; i < 6; i++)
					System.out.print(
							connector.getResultSet().getString(i + 1) + " ");
				System.out.println();
			}

			System.out.println(
					"\n------------test get and edit user info-----------------");
			for (int i = 0; i < 6; i++)
				System.out
						.println(user.getUserInfo("yousefzook@outlook.com")[i]);

			System.out.println("-----------------------------");
			String[] attributes = { "first_name", "last_name",
					"user_password" };
			String[] values = { "yousef2", "zook2", "1234" };
			user.editUserInfo("yousefzook@outlook.com", attributes, values);
			for (int i = 0; i < 6; i++)
				System.out
						.println(user.getUserInfo("yousefzook@outlook.com")[i]);

			System.out.println("\n------------------------------------");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
