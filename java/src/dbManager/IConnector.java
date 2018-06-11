/**
 * 
 */
package dbManager;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * @throws SQLException 
	 */
	public void run(String command) throws SQLException;

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
	 *         statement wasn't query, it returns null
	 */
	public ResultSet getResultSet();

}
