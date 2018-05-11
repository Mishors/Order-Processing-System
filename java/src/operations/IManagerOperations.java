package operations;

public interface IManagerOperations extends IUserOperations {

	/**
	 * 
	 * @param values
	 *            the book info to insert
	 * @return true if added successfully
	 */
	public boolean addNewBook(String[] bookInfo);

	/**
	 * Editing books info with given isbns values
	 * 
	 * @param attributes
	 *            , cols name to be updated
	 * @param values
	 *            , values with the same length of attributes
	 * @return true if updated successfully, false if not
	 */
	boolean editBookInfo(String[] attributes, String[] values, String[] isbns);

	/**
	 * 
	 * @param isbn
	 * @param noOfCopies
	 * @return true if successfully added to orders list
	 */
	boolean orderBook(String isbn, String noOfCopies);
	
	/**
	 * 
	 * @param isbn
	 * @return true if successfully finished
	 */
	boolean confirmOrder(String isbn);
	
	/**
	 * promote custmoer to be a manager
	 * @param customerEmail
	 * @return true if successfully finished
	 */
	public boolean promoteCustomer(String customerEmail);

}
