package main;

import java.sql.*;

import dbManager.*;
import operations.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IConnector connector = Connector.getInstance();
		connector.connect();
		IUser user = new opertaions();
		try {

			System.out.println(
					"------------test selecting all books-----------------");
			System.out.println(connector.run("select * from books"));
			String[][] books = new String[6][6];
			int counter = 0;
			while (connector.getResultSet().next()) {
				for (int i = 0; i < 6; i++) {
					System.out.print(
							connector.getResultSet().getString(i + 1) + " -- ");
					books[counter][i] = connector.getResultSet()
							.getString(i + 1);
				}
				counter++;
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

			System.out.println(
					"\n-------------test connector run----------------");
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

			System.out.println(
					"\n----------------test shopping cart--------------------");
			IShoppingCart cart = new ShoppingCart();
			for (int i = 0; i < books.length; i++)
				cart.addItem(books[i]);
			String[][] res = cart.getItems();
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[0].length; j++)
					System.out.print(res[i][j] + " - ");
				System.out.println();
			}
			System.out.println("total prices = " + cart.getTotalPrices());
			System.out.println("remove bad: " + cart.removeItem("1000"));
			System.out.println("remove good: " + cart.removeItem("19"));
			System.out.println("\n------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
