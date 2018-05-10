/**
 * 
 */
package dbManager;

import java.sql.ResultSet;

/**
 * @author yousef
 *
 */
public interface IConnector {

	/**
	 * connect to book store database, print an error if an error happen
	 */
	public void connect();

	/**
	 * 
	 * execute a given order, print an error if exists and return null
	 * 
	 * @param takes
	 *            a sql command as string
	 * @return true if the command was select and the result is not empty
	 */
	public boolean run(String command);

	/**
	 * close connection and statement
	 * 
	 * @return true if closed correctly, false if not
	 */
	public boolean closeConnection();

	/**
	 * 
	 * @return the number of updated count for the last executed statement if
	 *         there was an error while getting count, it returns -1
	 */
	public int getUpdatedCount();

	/**
	 * 
	 * @return the result set for the last executed statement if the last
	 *         statement was query, it returns null
	 */
	public ResultSet getResultSet();

}
