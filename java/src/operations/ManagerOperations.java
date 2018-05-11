package operations;

import dbManager.Authenticator;
import dbManager.Connector;
import dbManager.IConnector;

public class ManagerOperations extends UserOperations
		implements IManagerOperations {

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
			switch (attributes[i]) {
			case "isbn":
			case "publishing_year":
			case "price":
			case "threshold":
			case "no_of_copies":
				command += attributes[i] + "=" + values[i];
				break;
			default:
				command += attributes[i] + "='" + values[i] + "'";
				break;
			}
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
		connector.run("insert into store_orders values(" + isbn + ", "
				+ noOfCopies + ")");

		if (connector.getUpdatedCount() < 1) { // if failed
			System.out.println("Error while inserting order!");
			return false;
		}
		// success
		return true;
	}

	@Override
	public boolean confirmOrder(String isbn) {
		IConnector connector = Connector.getInstance();
		connector.run("delete from store_orders where isbn=" + isbn);

		if (connector.getUpdatedCount() < 1) { // if failed
			System.out
					.println("Error while confirming order for book with isbn="
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
