package operations;

import java.util.Date;

public interface IShoppingCart {

	/**
	 * add item to the cart
	 * 
	 * @param book,
	 *            array of string representin book info and the last element is
	 *            the number of copies
	 */
	void addItem(String[] book);

	/**
	 * get items currently in the cart
	 * 
	 * @return 2d array of strings represents the books information
	 */
	String[][] getItems();

	/**
	 * get total prices of all books on the cart
	 * 
	 * @return float representing the total cost
	 */
	float getTotalPrices();

	/**
	 * remove item from the cart
	 * 
	 * @return true if successfully removed, false if the isbn not found in the
	 *         cart
	 */
	boolean removeItem(String isbn);

	/**
	 * make cart empty
	 */
	void emptyCart();

	/**
	 * get number of items in the cart
	 * 
	 * @return number of items in the cart
	 */
	int getCartSize();

	/**
	 * Checking out a shopping cart
	 * 
	 * @param cardNumber,
	 *            should be a MasterCard with 16 length and starts with 2221,
	 *            2720, 51, 55
	 * @param expiryDate,
	 *            The expiry date of the Card, should be in the future
	 * @return true if checkout correctly, false otherwise
	 */
	boolean checkout(String cardNumber, Date expiryDate);
	
}
