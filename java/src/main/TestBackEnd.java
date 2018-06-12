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
		IAuthenticator aut = new Authenticator();
		String[] userInfo = { "h@c.o", "yz", "1234", "y", "z", "alex" };
		String[] phones2 = { "08", "09", "00", "100" };

		// System.out.println(aut.addNewUser(userInfo, phones2));
		try {

			System.out.println(
					"------------test selecting all books-----------------");
			connector.run("select * from books");
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
			String[][] resultSet = user.searchForBooksAdvanced(
					"category='art' or publisher_name='pub'");
			for (int j = 0; j < resultSet.length; j++) {
				for (int i = 0; i < resultSet[0].length; i++) {
					System.out.print(resultSet[j][i] + " -- ");
				}
				System.out.println();
			}

			System.out.println(
					"\n-------------test search for books----------------");
			String attribute = "isbn";
			String value = "1";
			resultSet = user.searchForBooks(attribute, value);
			for (int j = 0; j < resultSet.length; j++) {
				for (int i = 0; i < resultSet[0].length; i++) {
					System.out.print(resultSet[j][i] + " -- ");
				}
				System.out.println();
			}

			System.out.println(
					"\n-------------test search for books by authors----------------");
			attribute = "authors";
			value = "ta7seen";
			resultSet = user.searchForBooks(attribute, value);
			for (int j = 0; j < resultSet.length; j++) {
				for (int i = 0; i < resultSet[0].length; i++) {
					System.out.print(resultSet[j][i] + " -- ");
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
				System.out.println(user.getUserInfo("f@c.o")[i]);
			boolean temp = user.getUserInfo("f@c.o").length > 6;
			System.out.println("is has phone ? : " + temp);

			System.out.println("-----------------------------");
			String[] attributes = { "first_name", "last_name",
					"user_password" };
			String[] values = { "f2", "z2", "1234" };
			String[] phones = { "011", "012", "013" };
			user.editUserInfo("f@c.o", attributes, values, phones);
			for (int i = 0; i < 9; i++)
				System.out.println(user.getUserInfo("f@c.o")[i]);

			System.out.println(
					"\n----------------test shopping cart--------------------");
			IShoppingCart cart = new ShoppingCart("y@c.o");
			for (int i = 0; i < books.length - 1; i++) {
				books[i][6] = "2";
				cart.addItem(books[i][0], "5");
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
			// admin.addPublisher("publishername", "publisheradd", phones);
			System.out.println("Add new book-------------");
			String[] bookInfo = { "20", "title", "pub", "2019", "8.3", "art",
					"20", "25" };
			String[] authors = { "tawfik", "rafaat", "zook" };
			// admin.addNewBook(bookInfo, authors);
			resultSet = user.searchForBooks("isbn", "20");
			for (int j = 0; j < resultSet.length; j++) {
				for (int i = 0; i < resultSet[0].length; i++) {
					System.out.print(resultSet[j][i] + " -- ");
				}
				System.out.println();
			}
			System.out.println("After eddting-------------");
			String[] attributes2 = { "title", "price" };
			String[] values2 = { "newTitle", "108.3" };
			String isbn = "20";
			String[] authors2 = { "rabei3", "ta7seen" };
			admin.editBookInfo(attributes2, values2, isbn, authors2);
			resultSet = user.searchForBooks("isbn", "20");
			for (int j = 0; j < resultSet.length; j++) {
				for (int i = 0; i < resultSet[0].length; i++) {
					System.out.print(resultSet[j][i] + " -- ");
				}
				System.out.println();
			}
			System.out.println("ordering book id:1 nocopies:15 "
					+ admin.orderBook("1", "15"));
			System.out.println(
					"confrming order of id:1 good " + admin.confirmOrder("1"));
			System.out.println("confrming order of id:2000 bad! "
					+ admin.confirmOrder("2000"));
			// System.out.println(admin.promoteCustomer("a@c.o"));
			connector.run("select * from managers");
			while (connector.getResultSet().next())
				System.out.println(connector.getResultSet().getString(1));
			System.out.println("\n------------------------------------");

		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}

	}

}
