package operations;

import java.util.ArrayList;
import java.util.Date;

import dbManager.Connector;
import dbManager.IConnector;

public class ShoppingCart implements IShoppingCart {

	private ArrayList<String[]> books;
	private String activeUserEmail;

	// must use constructor with the email parameter
	private ShoppingCart() {
	};

	public ShoppingCart(String email) {
		books = new ArrayList<>();
		activeUserEmail = email;
	}

	@Override
	public void addItem(String[] book) {
		books.add(book);
	}

	@Override
	public String[][] getItems() {

		String[][] res = new String[books.size()][books.get(0).length];
		for (int i = 0; i < books.size(); i++)
			for (int j = 0; j < books.get(0).length; j++)
				res[i][j] = books.get(i)[j];

		return res;
	}

	@Override
	public float getTotalPrices() {
		float price = 0;
		final int PRICE_INDEX = 4;
		for (int i = 0; i < books.size(); i++)
			price += Float.parseFloat(books.get(i)[PRICE_INDEX]);
		return price;
	}

	@Override
	public boolean removeItem(String isbn) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i)[0].equals(isbn)) {
				books.remove(i);
				return true;
			}
		}
		return false;

	}

	@Override
	public void emptyCart() {
		books = new ArrayList<>();
	}

	@Override
	public int getCartSize() {
		return books.size();
	}

	@Override
	public boolean checkout(String cardNumber, Date expiryDate) {

		if (cardNumber.length() != 16)
			return false;

		Date now = new Date();
		if (now.after(expiryDate))
			return false;

		String firstTwoDigits = cardNumber.substring(0, 2);
		String firstFourDigits = cardNumber.substring(0, 4);
		if (!firstTwoDigits.equals("51") && !firstTwoDigits.equals("55")
				&& !firstFourDigits.equals("2720")
				&& !firstFourDigits.equals("2221"))
			return false;

		IConnector connector = Connector.getInstance();
		for (int i = 0; i < books.size(); i++) {
			String[] book = books.get(i);
			connector.run(
					"insert into customer_orders (isbn, cstmr_email, no_of_copies, sale_date) "
							+ "values(" + book[0] + "," + activeUserEmail + ","
							+ book[book.length - 1] + "," + new Date());
		}
		this.emptyCart();
		return true;
	}

	public void logOut() {
		this.emptyCart();
		Connector.getInstance().closeConnection();
	}
}