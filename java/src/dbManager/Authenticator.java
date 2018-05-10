package dbManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator implements IAuthenticator {

	private static IAuthenticator authenticator;

	public static IAuthenticator getInstance() {

		if (authenticator == null)
			authenticator = new Authenticator();
		return authenticator;
	}

	@Override
	public boolean authenticate(String email, String password) {

		IConnector connector = Connector.getInstance();
		boolean isUser = connector
				.run("select * from users where " + "email = '" + email + "'");

		try {
			// check for the given user name
			if (!isUser) { // no result from sql select
				System.out.println("Authentication failed for user: " + email
						+ " >> Invalid user name !");
				return false;
			}

			// check for the given password
			String passHashed = hashPass(password);
			String userPassHashed = connector.getResultSet()
					.getString("user_password");
			if (!passHashed.equals(userPassHashed)) {
				System.out.println("Authentication failed for user: " + email
						+ " >> Invalid password !");
				return false;
			}
			// success
			return true;

		} catch (SQLException e) {
			System.out.println(
					"Database acess error while authenticating an user!");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNewUser(String[] userInfo) {

		// hash the given user password
		userInfo[2] = hashPass(userInfo[2]);

		// insert the user into database
		IConnector connector = Connector.getInstance();
		String values = "";
		for (int i = 0; i < userInfo.length - 1; i++)
			values += "'" + userInfo[i] + "', ";
		values += "'" + userInfo[userInfo.length - 1] + "'";
		connector.run("inesrt into users values(" + values + ")");

		if (connector.getUpdatedCount() < 0) // an error while inserting
			return false;

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

}
