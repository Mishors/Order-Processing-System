/**
 * 
 */
package operations;

import java.sql.ResultSet;

/**
 * @author yousef
 *
 */
public interface IUser {

	/**
	 * @param email
	 * @return information of the user with given email userInfo: an array of
	 *         strings with first values in order: email userName userPassword
	 *         firstName lastName shippingAdd returns null if not valid email
	 */
	String[] getUserInfo(String email);

	/**
	 * 
	 * @param attributes
	 *            , columns name to be updated
	 * @param values
	 *            , values with the same length of attributes
	 * @return true if updated successfully, false if not
	 */
	boolean editUserInfo(String email, String[] attributes, String[] values,
			String[] phonesArr);

	/**
	 * 
	 * @param attribute
	 *            to make condition on it
	 * @param value
	 * @return the books info
	 */
	String[][] searchForBooks(String attribute, Object value);

	/**
	 * same as previous but takes a full string condition from caller
	 * 
	 * @param condition
	 * @return
	 */
	String[][] searchForBooksAdvanced(String condition);
}