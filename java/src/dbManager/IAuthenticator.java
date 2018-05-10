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
	 * @return the authenticator instance
	 */
	public Authenticator getInstance();

	/**
	 * authenticate if the given user name and password are exist or not
	 * 
	 * @return true if the authentication pass, false if failed
	 */
	public boolean authenticate(String userName, String password);

	/**
	 * 
	 * @param userInfo:
	 *            an array of strings with first values in order: email userName
	 *            userPassword firstName lastName shippingAdd
	 * @return true if the user added successfully , false if not
	 */
	public boolean addNewUser(String[] userInfo);
}
