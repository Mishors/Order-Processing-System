package operations;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			String[] info = new String[6];
			ResultSet resultSet = connector.getResultSet();
			for (int i = 1; i <= 6; i++)
				info[i - 1] = resultSet.getString(i);
			return info;

		} catch (SQLException e) {
			System.out
					.println("Error in getting user info with eamil: " + email);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editUserInfo(String email, String[] attributes,
			String[] values) {
		if (attributes.length != values.length) {
			System.out.println(
					"Error in editing user info, attributes and values lengths don't match");
			return false;
		}

		IConnector connector = Connector.getInstance();
		String command = "update users set ";

		// adding values in command
		for (int i = 0; i < attributes.length - 1; i++) {
			if (attributes[i] == "user_password") {
				String hashedPass = Authenticator.getInstance()
						.hashPass(values[i]);
				command += attributes[i] + "='" + hashedPass + "', ";
			} else
				command += attributes[i] + "='" + values[i] + "', ";
		}
		if (attributes[attributes.length - 1] == "user_password") {
			String hashedPass = Authenticator.getInstance()
					.hashPass(values[attributes.length - 1]);
			command += attributes[attributes.length - 1] + "='" + hashedPass
					+ "'";
		} else
			command += attributes[attributes.length - 1] + "='"
					+ values[attributes.length - 1] + "'";

		// adding where condition
		command += " where email='" + email + "'";

		connector.run(command);

		if (connector.getUpdatedCount() < 0) // error while updating
			return false;

		// success
		return true;
	}

	@Override
	public ResultSet searchForBooks(String attribute, Object value) {

		String command = "select * from books where ";

		command += attribute + "='" + value.toString() + "'";

		IConnector connector = Connector.getInstance();
		connector.run(command);

		return connector.getResultSet();
	}

	@Override
	public ResultSet searchForBooksAdvanced(String condition) {
		IConnector connector = Connector.getInstance();
		connector.run("select * from books where " + condition);

		return connector.getResultSet();
	}

	@Override
	public boolean addNewBook(String[] bookInfo) {

		// insert the book into database
		IConnector connector = Connector.getInstance();
		String values = "";
		for (int i = 0; i < bookInfo.length - 1; i++)
			values += "'" + bookInfo[i] + "', ";
		values += "'" + bookInfo[bookInfo.length - 1] + "'";
		connector.run("insert into books values(" + values + ")");

		if (connector.getUpdatedCount() < 0) // an error while inserting
			return false;

		return true;
	}

	@Override
	public boolean editBookInfo(String[] attributes, String[] values,
			String[] isbns) {

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

		command += " where";
		// adding where condition
		for (int i = 0; i < isbns.length; i++) {
			command += " isbn=" + isbns[i];
			if (i != isbns.length - 1)
				command += " or";
		}
		connector.run(command);

		if (connector.getUpdatedCount() < 0) // error while updating
			return false;

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
			System.out
					.println("Error while confirming order for book with isbn = "
							+ isbn + " !");
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
}
