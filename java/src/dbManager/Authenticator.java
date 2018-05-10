package dbManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator implements IAuthenticator {

	private Authenticator authenticator;

	@Override
	public Authenticator getInstance() {

		if (this.authenticator == null)
			this.authenticator = new Authenticator();
		return this.authenticator;
	}

	@Override
	public boolean authenticate(String email, String password) {

		Connector connector = Connector.getInstance();
		ResultSet resultSet = connector
				.run("select * from users where " + "email = " + email);
		
		try {
			// check for the given user name
			if (!resultSet.first()) { // no result from sql select
				System.out.println("Authentication failed for user: " + email
						+ " >> Invalid user name !");
				return false;
			}

			// check for the given password
			String passHashed = hashPass(password);
			String userPassHashed = resultSet.getString("user_password");
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
		Connector connector = Connector.getInstance();
		String values = "";
		for (int i = 0; i < userInfo.length - 1; i++)
			values += userInfo[i] + ", ";
		values += userInfo[userInfo.length - 1];
		ResultSet resultSet = connector
				.run("inesrt into users values(" + values + ")");

		if (resultSet == null) // fail
			return false;
		// success
		return true;
	}

	/**
	 * hash the given password using MD5
	 * 
	 * @param string
	 *            password
	 * @return
	 */
	private String hashPass(String pass) {
		
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
