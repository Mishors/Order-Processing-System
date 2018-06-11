package dbManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import operations.IShoppingCart;

public class Authenticator implements IAuthenticator {

	private static IAuthenticator authenticator;

	public static IAuthenticator getInstance() {

		if (authenticator == null)
			authenticator = new Authenticator();
		return authenticator;
	}

	@Override
	public int authenticate(String email, String password) {

		IConnector connector = Connector.getInstance();
		boolean success = connector
				.run("select * from users where " + "email = '" + email + "'");
		if (!success) {
			System.out.println(
					"Database access error while authenticating an user!");
			return -1;
		}
		try {
			boolean isUser = connector.getResultSet().first();
			// check for the given user name
			if (!isUser) { // no result from sql select
				System.out.println("Authentication failed for user: " + email
						+ " >> Invalid user name !");
				return -1;
			}

			// check for the given password
			String passHashed = hashPass(password);
			ResultSet resultSet = connector.getResultSet();
			String userPassHashed = resultSet.getString("user_password");
			if (!passHashed.equals(userPassHashed)) {
				System.out.println("Authentication failed for user: " + email
						+ " >> Invalid password !");
				return -2;
			}

			connector.run(
					"select * from managers where mngr_email='" + email + "'");
			if (connector.getResultSet().first()) // if manager
				return 1;
			// normal user
			return 0;

		} catch (SQLException e) {
			System.out.println(
					"Database acess error while authenticating an user!");
			e.printStackTrace();
			return -3;
		}
	}

	@Override
	public boolean addNewUser(String[] userInfo, String[] phones) {

		// hash the given user password
		userInfo[2] = hashPass(userInfo[2]);

		// insert the user into database
		IConnector connector = Connector.getInstance();
		String values = "";
		for (int i = 0; i < userInfo.length - 1; i++)
			values += "'" + userInfo[i] + "', ";
		values += "'" + userInfo[userInfo.length - 1] + "'";
		connector.run("insert into users values(" + values + ")");

		if (connector.getUpdatedCount() < 0) // an error while inserting
			return false;
		String command = "";
		String email = userInfo[0];
		for (int i = 0; i < phones.length; i++) {
			command = "insert into user_phones values('" + email + "','"
					+ phones[i] + "')";
			connector.run(command);
		}
		return true;
	}

	@Override
	public String hashPass(String pass) {

		MessageDigest messageDigest;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(pass.getBytes());
			byte[] messageDigestMD5 = messageDigest.digest();

			StringBuffer passHashedBuff = new StringBuffer();
			for (byte bytes : messageDigestMD5)
				passHashedBuff.append(String.format("%02x", bytes & 0xff));
			return passHashedBuff.toString();

		} catch (NoSuchAlgorithmException e) {
			System.out.println("Error while hashing password!");
			e.printStackTrace();
			return null;
		}
	}

	public boolean setAsAdmin(String email) {

		IConnector connector = Connector.getInstance();
		boolean success = connector
				.run("insert into managers values('" + email + "')");
		if (!success) {
			System.out.println("Database  error while setting user as admin!");
			return false;
		}
		return true;
	}

}
