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
	 * authenticate if the given user name and password are exist or not
	 * 
	 * @return 0 if the authentication pass as user, 1 if manager and -1 if not
	 *         authorized
	 */
	public int authenticate(String email, String password);

	/**
	 * 
	 * @param userInfo:
	 *            an array of strings with first values in order: email userName
	 *            userPassword firstName lastName shippingAdd
	 * @return true if the user added successfully , false if not
	 */
	public boolean addNewUser(String[] userInfo);

	/**
	 * hash the given password using MD5
	 * 
	 * @param string
	 *            password
	 * @return
	 */
	public String hashPass(String pass);
}
