package operations;

public interface IShoppingCart {

	/**
	 * add item to the cart
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
}
