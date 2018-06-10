package main;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dbManager.*;
import operations.*;

public class TestBackEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IConnector connector = Connector.getInstance();
		connector.connect();
		IUser user = new Operations();
		try {

			System.out.println(
					"------------test selecting all books-----------------");
			System.out.println(connector.run("select * from books"));
			String[][] books = new String[7][7];
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
			String attribute = "isbn";
			String value = "1";
			resultSet = user.searchForBooks(attribute, value);
			while (resultSet.next()) {
				for (int i = 0; i < 6; i++)
					System.out.print(resultSet.getString(i + 1) + " -- ");
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
			IShoppingCart cart = new ShoppingCart("y@c.o");
			for (int i = 0; i < books.length; i++) {
				books[i][6] = "2";
				cart.addItem(books[i]);
			}
			String[][] res = cart.getItems();
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res[0].length; j++)
					System.out.print(res[i][j] + " - ");
				System.out.println();
			}
			System.out.println("total prices = " + cart.getTotalPrices());
			System.out.println("remove bad: " + cart.removeItem("1000"));
			System.out.println("remove good: " + cart.removeItem("5"));
			Date now = new Date();
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2019");

			System.out.println(cart.checkout("5112345678901234", date));

			System.out.println(
					"\n----------------test admin operations--------------------");
			IAdmin admin = new Operations();
			String[] bookInfo = { "20", "title", "pub", "2019", "8.3", "art",
					"20", "25" };
			// admin.addNewBook(bookInfo);
			String[] attributes2 = { "title", "price" };
			String[] values2 = { "newTitle", "108.3" };
			String[] isbns = { "20", "19" };
			admin.editBookInfo(attributes2, values2, isbns);
			resultSet = user.searchForBooks(attribute, "19");
			while (resultSet.next()) {
				for (int i = 0; i < 8; i++)
					System.out.print(resultSet.getString(i + 1) + " -- ");
				System.out.println();
			}
			System.out.println("ordering book id:1 nocopies:15    "
					+ admin.orderBook("1", "15"));
			// System.out.println("confrming order of id:1 good " +
			// admin.confirmOrder("1"));
			// System.out.println("confrming order of id:2000 bad! " +
			// admin.confirmOrder("2000"));
			System.out.println(admin.promoteCustomer("a@c.o"));
			connector.run("select * from managers");
			while (connector.getResultSet().next())
				System.out.println(connector.getResultSet().getString(1));
			System.out.println("\n------------------------------------");

		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
