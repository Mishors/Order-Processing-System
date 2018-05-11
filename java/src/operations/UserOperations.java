package operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import dbManager.Authenticator;
import dbManager.Connector;
import dbManager.IConnector;

public class UserOperations implements IUserOperations {

	@Override
	public String[] getUserInfo(String email) {
		// TODO Auto-generated method stub
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
	public boolean editUserInfo(String[] attributes, String[] values) {

		if (attributes.length != values.length) {
			System.out.println(
					"Error in editing info, attributes and values lengths don't match");
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
		command += " where email='" + CurrentUser.getInstance().getEmail()
				+ "'";

		connector.run(command);

		if (connector.getUpdatedCount() < 0) // error while updating
			return false;

		// success
		return true;
	}

	@Override
	public ResultSet searchForBooks(String attribute, Object value) {

		String command = "select * from books where ";

		switch (value.getClass().getSimpleName()) {
		case "Integer":
		case "Float":
			command += attribute + "=" + value.toString();
			break;
		case "String":
			command += attribute + "='" + value.toString() + "'";
			break;
		}

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

}
