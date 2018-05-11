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
	 * @return true if the authentication pass, false if failed
	 */
	public boolean authenticate(String email, String password);

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
