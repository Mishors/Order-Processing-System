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
	 * @param takes a sql command as string
	 * @return the result set of the table being changed
	 */
	public ResultSet run(String command);
	
}
