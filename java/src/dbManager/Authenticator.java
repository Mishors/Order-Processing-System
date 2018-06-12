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

		try {
			IConnector connector = Connector.getInstance();
			connector.run(
					"select * from users where " + "email = '" + email + "'");
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
	public int addNewUser(String[] userInfo, String[] phones) {

		// hash the given user password
		userInfo[2] = hashPass(userInfo[2]);

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}

		// insert the user into database
		String values = "";
		for (int i = 0; i < userInfo.length - 1; i++)
			values += "'" + userInfo[i] + "', ";
		values += "'" + userInfo[userInfo.length - 1] + "'";
		try {
			connector.run("insert into users values(" + values + ")");
		} catch (SQLException e) { // an error while inserting info
			try {
				connector.run("rollback");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return -1;
		}

		String command = "";
		String email = userInfo[0];
		for (int i = 0; i < phones.length; i++) {
			command = "insert into user_phones values('" + email + "','"
					+ phones[i] + "')";
			try {
				connector.run(command);
			} catch (SQLException e) { // an error while inserting phones
				try {
					connector.run("rollback");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return -2;
			}
		}

		// commit transaction
		try {
			connector.run("commit;");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return -1;
		}

		// success
		return 1;
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

		// start transaction
		IConnector connector = Connector.getInstance();
		try {
			connector.run("start transaction");
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		try {
			connector.run("insert into managers values('" + email + "')");
		} catch (SQLException e) {
			System.out.println("Database  error while setting user as admin!");
			e.printStackTrace();
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

		return true;
	}

}
