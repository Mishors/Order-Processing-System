/**
 * 
 */
package dbManager;

/**
 * @author yousef
 *
 */
public interface IAuthenticator {

	/**
	 * authenticate if the given user name and password are exist or not and log
	 * in the user if valid
	 * 
	 * @return 0 if the authentication pass as user, 1 if manager and -1 if not
	 *         authorized emial, -2 if not valid password and -3 if data access
	 *         fail
	 */
	public int authenticate(String email, String password);

	/**
	 * takes an array of strings with values in order: email, userName
	 * userPassword, firstName, lastName and shippingAddress and add the user to
	 * the database
	 * 
	 * @param userInfo
	 * @param user phones 
	 * @return true if the user added successfully , false if not
	 */
	public boolean addNewUser(String[] userInfo, String[] phones);

	/**
	 * hash the given password using MD5
	 * 
	 * @param string
	 *            password
	 * @return
	 */
	public String hashPass(String pass);

	/**
	 * setting an user as admin to have admin previleges
	 * 
	 * @param email
	 * @return true if success, false if any error happened
	 */
	public boolean setAsAdmin(String email);
}