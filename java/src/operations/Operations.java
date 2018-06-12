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
		try {
			connector.run("select * from users where email='" + email + "'");
		} catch (SQLException e1) {
			System.out.println(
					"Database getting information of user with email = " + email
							+ " !");
			e1.printStackTrace();
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

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		if (attributes.length != values.length) {
			System.out.println(
					"Error in editing user info, attributes and values lengths don't match");
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}

		String command = "update users set ";
		String newEmail = null;
		// adding values in command
		if (attributes.length > 0) {
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
				if (attributes.length > 0
						&& attributes[attributes.length - 1] == "email")
					newEmail = values[attributes.length - 1];

			}
			// adding where condition
			command += " where email='" + email + "'";
			System.out.println(command);
			try {
				connector.run(command);
			} catch (SQLException e) {
				// error while updating
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return false;
			}

		}

		if (newEmail != null)
			email = newEmail;

		command = "delete from user_phones where email='" + email + "'";
		try {
			connector.run(command);
		} catch (SQLException e) {
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Error while excuting : " + command);
			e.printStackTrace();
			return false;
		}
		if (phones == null) // this mean he removed all his phones
			return true;

		// insert new phones
		for (int i = 0; i < phones.length; i++) {
			command = "insert into user_phones values('" + email + "','"
					+ phones[i] + "')";
			try {
				connector.run(command);
			} catch (SQLException e) {
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Error while excuting : " + command);
				e.printStackTrace();
				return false;
			}
		}

		// commit transaction
		try {
			connector.run("commit;");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// success
		return true;
	}

	@Override
	public String[][] searchForBooks(String attribute, Object value) {

		String command = "";
		if (attribute == "authors") {
			command = "select * from books where isbn in (select isbn "
					+ "from authors where author='" + value + "')";

		} else {
			command = "select * from books where ";
			command += attribute;
			if (attribute == "price") {
				command += "<='";
			} else {
				command += "='";
			}
			command += value.toString() + "'";
		}

		IConnector connector = Connector.getInstance();
		try {
			connector.run(command);
		} catch (SQLException e) {
			System.out.println("Error while excuting : " + command);
			e.printStackTrace();
		}

		ResultSet rSet = connector.getResultSet();

		return convertResultSet(rSet);
	}

	@Override
	public String[][] searchForBooksAdvanced(String condition) {
		IConnector connector = Connector.getInstance();
		String command = "select * from books where " + condition;
		try {
			connector.run(command);
		} catch (SQLException e) {
			System.out.println("Error while excuting : " + command);
			e.printStackTrace();
		}

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

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// insert the book into database
		String values = "";
		for (int i = 0; i < bookInfo.length - 1; i++)
			values += "'" + bookInfo[i] + "', ";
		values += "'" + bookInfo[bookInfo.length - 1] + "'";
		try {
			connector.run("insert into books values(" + values + ")");
		} catch (SQLException e) {
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}

		if (connector.getUpdatedCount() < 0) // an error while inserting
			return false;

		// insert into authors table
		for (int i = 0; i < authors.length; i++)
			try {
				connector.run("insert into authors values('" + bookInfo[0]
						+ "','" + authors[i] + "')");
			} catch (SQLException e) {
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return false;
			}

		// commit transaction
		try {
			connector.run("commit;");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

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

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		String command;

		if (attributes.length != 0) {

			command = "update books set ";

			// adding values in command
			for (int i = 0; i < attributes.length; i++) {
				command += attributes[i] + "='" + values[i] + "'";
				if (i != attributes.length - 1)
					command += ", ";
			}

			// adding where condition
			command += " where isbn=" + isbn;

			try {
				connector.run(command);
			} catch (SQLException e) {
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Error while excuting : " + command);
				e.printStackTrace();
				return false;
			}
		}

		command = "delete from authors where isbn=" + isbn;
		try {
			connector.run(command);
		} catch (SQLException e) {
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Error while excuting : " + command);
			e.printStackTrace();
			return false;
		}

		// insert new authors
		for (int i = 0; i < authors.length; i++) {
			command = "insert into authors values(" + isbn + ",'" + authors[i]
					+ "')";
			try {
				connector.run(command);
			} catch (SQLException e) {
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Error while excuting : " + command);
				e.printStackTrace();
				return false;
			}
		}

		// commit transaction
		try {
			connector.run("commit;");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// success
		return true;
	}

	@Override
	public boolean orderBook(String isbn, String noOfCopies) {

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		try {
			connector.run("select * from store_orders where isbn = " + isbn);
			if (connector.getResultSet().first()) {
				connector.run(
						"update store_orders set no_of_copies = no_of_copies + "
								+ noOfCopies + " where isbn = " + isbn);
			} else {
				connector.run("insert into store_orders values(" + isbn + ", "
						+ noOfCopies + ")");
			}
			if (connector.getUpdatedCount() < 1) { // if failed
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Error while inserting order!");
				return false;
			}

			// commit transaction
			try {
				connector.run("commit;");
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}

			// success
			return true;
		} catch (SQLException e) {
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Error while ordering book!");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean confirmOrder(String isbn) {

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		try {
			connector.run("delete from store_orders where isbn = " + isbn);
		} catch (SQLException e) {
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Error in confirming order");
			e.printStackTrace();
			return false;
		}

		if (connector.getUpdatedCount() < 1) { // if failed
			System.out.println(
					"Error while confirming order for book with isbn = " + isbn
							+ " !");
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}

		// commit transaction
		try {
			connector.run("commit;");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		// success
		return true;
	}

	public boolean promoteCustomer(String customerEmail) {

		IConnector connector = Connector.getInstance();
		try {
			connector.run(
					"insert into managers values('" + customerEmail + "')");
		} catch (SQLException e) {

			System.out.println(
					"Error while promoting customer: " + customerEmail + " !");
			e.printStackTrace();
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}

		// success
		return true;
	}

	@Override
	public int addPublisher(String name, String add, String[] phones) {
		IConnector connector = Connector.getInstance();
		try {
			connector.run("insert into publishers values('" + name + "','" + add
					+ "')");
		} catch (SQLException e) {
			System.out.println(
					"Error in add publisher in publisher name may be already exist "
							+ "or address may be null !");
			e.printStackTrace();
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return -1;
		}

		for (int i = 0; i < phones.length; i++) {
			try {
				connector.run("insert into publisher_phones values('" + name
						+ "','" + phones[i] + "')");
			} catch (SQLException e) {
				System.out.println("Error in add publisher in phnes numbers !");
				e.printStackTrace();
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return -2;
			}

		}
		return 1;

	}
}
