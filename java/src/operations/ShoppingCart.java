package operations;

import java.util.ArrayList;

public class ShoppingCart implements IShoppingCart {

	private ArrayList<String[]> books;

	public ShoppingCart() {
		books = new ArrayList<>();
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

}
