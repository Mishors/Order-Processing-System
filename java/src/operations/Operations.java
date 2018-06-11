package operations;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbManager.Authenticator;
import dbManager.Connector;
import dbManager.IConnector;

public class Operations implements IAdmin, IUser {

	@Override
	public String[] getUserInfo(String email) {
		IConnector connector = Connector.getInstance();
		boolean success = connector
				.run("select * from users where email='" + email + "'");
		if (!success) {
			System.out
					.println("Database getting information of user with email=!"
							+ email);
			return null;
		}
		try {
			boolean isUser = connector.getResultSet().first();
			if (!isUser) { // if no user with this email in data
				System.out.println(
						"Database getting information of user with email=!"
								+ email);
				return null;
			}
			ArrayList<String> info = new ArrayList<>();
			ResultSet resultSet = connector.getResultSet();
			for (int i = 1; i <= 6; i++)
				info.add(resultSet.getString(i));

			connector.run("select phone from user_phones where email='"
					+ info.get(0) + "'");

			resultSet = connector.getResultSet();
			while (resultSet.next())
				info.add(resultSet.getString(1));

			return info.toArray(new String[info.size()]);

		} catch (SQLException e) {
			System.out
					.println("Error in getting user info with eamil: " + email);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editUserInfo(String email, String[] attributes,
			String[] values, String[] phones) {
		if (attributes.length != values.length) {
			System.out.println(
					"Error in editing user info, attributes and values lengths don't match");
			return false;
		}

		IConnector connector = Connector.getInstance();
		String command = "update users set ";
		String newEmail = null;
		// adding values in command
		for (int i = 0; i < attributes.length - 1; i++) {
			if (attributes[i] == "user_password") {
				String hashedPass = Authenticator.getInstance()
						.hashPass(values[i]);
				command += attributes[i] + "='" + hashedPass + "', ";
			} else {
				command += attributes[i] + "='" + values[i] + "', ";
				if (attributes[i] == "email")
					newEmail = values[i];
			}
		}
		if (attributes[attributes.length - 1] == "user_password") {
			String hashedPass = Authenticator.getInstance()
					.hashPass(values[attributes.length - 1]);
			command += attributes[attributes.length - 1] + "='" + hashedPass
					+ "'";
		} else {
			command += attributes[attributes.length - 1] + "='"
					+ values[attributes.length - 1] + "'";
			if (attributes[attributes.length - 1] == "email")
				newEmail = values[attributes.length - 1];
		}

		// adding where condition
		command += " where email='" + email + "'";

		connector.run(command);
		if (connector.getUpdatedCount() < 0) // error while updating
			return false;

		if (newEmail != null)
			email = newEmail;

		command = "delete from user_phones where email='" + email + "'";
		connector.run(command);
		if (phones == null) // this mean he removed all his phones
			return true;

		// insert new phones
		for (int i = 0; i < phones.length; i++) {
			command = "insert into user_phones values('" + email + "','"
					+ phones[i] + "')";
			connector.run(command);
		}

		// success
		return true;
	}

	@Override
	public String[][] searchForBooks(String attribute, Object value) {

		ArrayList<String> authors = new ArrayList<>();
		String command = "";
		if (attribute == "authors") {
			command = "select * from books where isbn in (select isbn "
					+ "from authors where author='" + value + "')";
		} else {
			command = "select * from books where ";
			command += attribute + "='" + value.toString() + "'";
		}

		IConnector connector = Connector.getInstance();
		connector.run(command);

		ResultSet rSet = connector.getResultSet();

		return convertResultSet(rSet);
	}

	@Override
	public String[][] searchForBooksAdvanced(String condition) {
		IConnector connector = Connector.getInstance();
		connector.run("select * from books where " + condition);

		ResultSet rSet = connector.getResultSet();
		return convertResultSet(rSet);
	}

	// convert result set to array of strings 2d
	private String[][] convertResultSet(ResultSet rSet) {
		ArrayList<String[]> arr = new ArrayList<>();
		String[][] result = null;
		try {
			String command = "";

			IConnector connector = Connector.getInstance();
			ArrayList<String> isbns = new ArrayList<>();
			while (rSet.next()) {
				String[] row = new String[9];
				for (int i = 0; i < 8; i++)
					row[i] = rSet.getString(i + 1);
				isbns.add(rSet.getString(1));
				arr.add(row);
			}
			for (int i = 0; i < isbns.size(); i++) {

				command = "select * from authors where isbn=" + isbns.get(i);
				connector.run(command);
				String authors = "";
				while (connector.getResultSet().next())
					authors += connector.getResultSet().getString(2) + " , ";
				arr.get(i)[8] = authors;
			}

			result = arr.toArray(new String[arr.size()][]);

		} catch (SQLException e) {
			System.out.println(
					"Error while getting result set after searching for book!");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addNewBook(String[] bookInfo, String[] authors) {

		// insert the book into database
		IConnector connector = Connector.getInstance();
		String values = "";
		for (int i = 0; i < bookInfo.length - 1; i++)
			values += "'" + bookInfo[i] + "', ";
		values += "'" + bookInfo[bookInfo.length - 1] + "'";
		connector.run("insert into books values(" + values + ")");

		if (connector.getUpdatedCount() < 0) // an error while inserting
			return false;

		// insert into authors table
		for (int i = 0; i < authors.length; i++)
			connector.run("insert into authors values('" + bookInfo[0] + "','"
					+ authors[i] + "')");
		return true;
	}

	@Override
	public boolean editBookInfo(String[] attributes, String[] values,
			String isbn, String[] authors) {

		if (attributes.length != values.length) {
			System.out.println(
					"Error in editing book info, attributes and values lengths don't match");
			return false;
		}

		IConnector connector = Connector.getInstance();
		String command = "update books set ";

		// adding values in command
		for (int i = 0; i < attributes.length; i++) {
			command += attributes[i] + "='" + values[i] + "'";
			if (i != attributes.length - 1)
				command += ", ";
		}

		// adding where condition
		command += " where isbn=" + isbn;

		connector.run(command);

		if (connector.getUpdatedCount() < 0) // error while updating
			return false;

		command = "delete from authors where isbn=" + isbn;
		connector.run(command);

		// insert new authors
		for (int i = 0; i < authors.length; i++) {
			command = "insert into authors values(" + isbn + ",'" + authors[i]
					+ "')";
			connector.run(command);
		}

		// success
		return true;
	}

	@Override
	public boolean orderBook(String isbn, String noOfCopies) {
		IConnector connector = Connector.getInstance();
		connector.run("select * from store_orders where isbn = " + isbn);
		try {
			if (connector.getResultSet().first()) {
				connector.run(
						"update store_orders set no_of_copies = no_of_copies + "
								+ noOfCopies + " where isbn = " + isbn);
			} else {
				connector.run("insert into store_orders values(" + isbn + ", "
						+ noOfCopies + ")");
			}
			if (connector.getUpdatedCount() < 1) { // if failed
				System.out.println("Error while inserting order!");
				return false;
			}
			// success
			return true;
		} catch (SQLException e) {
			System.out.println("Error while ordering book!");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean confirmOrder(String isbn) {
		IConnector connector = Connector.getInstance();
		connector.run("delete from store_orders where isbn = " + isbn);

		if (connector.getUpdatedCount() < 1) { // if failed
			System.out.println(
					"Error while confirming order for book with isbn = " + isbn
							+ " !");
			return false;
		}
		// success
		return true;
	}

	public boolean promoteCustomer(String customerEmail) {

		IConnector connector = Connector.getInstance();
		connector.run("insert into managers values('" + customerEmail + "')");

		if (connector.getUpdatedCount() < 1) { // if failed
			System.out.println(
					"Error while promoting customer: " + customerEmail + " !");
			return false;
		}
		// success
		return true;
	}

	@Override
	public boolean addPublisher(String name, String add, String[] phones) {
		IConnector connector = Connector.getInstance();
		connector.run(
				"insert into publishers values('" + name + "','" + add + "')");

		if (connector.getUpdatedCount() < 0)
			return false;

		for (int i = 0; i < phones.length; i++) {
			connector.run("insert into publisher_phones values('" + name + "','"
					+ phones[i] + "')");
			if (connector.getUpdatedCount() < 0)
				return false;
		}
		return true;

	}
}
