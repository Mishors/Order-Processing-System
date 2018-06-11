package operations;

public interface IAdmin extends IUser {

	/**
	 * 
	 * @param values
	 *            the book info to insert
	 * @param authors,
	 *            array of book authors
	 * @return true if added successfully
	 */
	public boolean addNewBook(String[] bookInfo, String[] authors);

	/**
	 * Editing book info with given isbn value
	 * 
	 * @param attributes
	 *            , cols name to be updated
	 * @param values
	 *            , values with the same length of attributes
	 * @return true if updated successfully, false if not
	 */
	boolean editBookInfo(String[] attributes, String[] values, String isbn,
			String[] authors);

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
	 * promote customer to be a manager
	 * 
	 * @param customerEmail
	 * @return true if successfully finished
	 */
	public boolean promoteCustomer(String customerEmail);

	/**
	 * 
	 * @param name
	 *            of publisher
	 * @param address
	 *            of pulbisher
	 * @param phones
	 *            of publisher
	 * @return 1 if successfully added, -2 if problem in phones, -1 if problem in other info
	 */
	public int addPublisher(String name, String add, String[] phones);

}
