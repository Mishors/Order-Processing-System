package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import operations.IAdmin;
import operations.IShoppingCart;
import operations.Operations;
import operations.ShoppingCart;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class ShoppingCartView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private String[] bookHeader = { "isbn", "no. of copies", "total price" };
	IShoppingCart shoppingCart;

	/**
	 * Create the frame.
	 */
	public ShoppingCartView(String email, boolean admin, IShoppingCart sCart,
			JFrame caller) {
		shoppingCart = sCart;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 735);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel(null);
		panel.setPreferredSize(new Dimension(100, 150));
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Welcome to online bookstore ");
		lblNewLabel.setBounds(new Rectangle(146, 35, 700, 61));
		lblNewLabel.setLocation(new Point(350, 50));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setPreferredSize(new Dimension(1400, 150));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel(null);
		panel_2.setPreferredSize(new Dimension(750, 300));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel(null);
		panel_3.setPreferredSize(new Dimension(610, 300));
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setBackground(Color.WHITE);

		JLabel lblUserProfile = new JLabel("Shopping Cart");
		lblUserProfile.setFont(new Font("Calibri", Font.BOLD, 17));
		lblUserProfile.setBounds(36, 11, 157, 31);
		panel_2.add(lblUserProfile);

		JLabel lblNewLabel_1 = new JLabel("Add Item\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 65, 157, 23);
		panel_2.add(lblNewLabel_1);

		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Add Item");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblIsbn = new JLabel("Isbn");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblIsbn.setBounds(44, 44, 191, 31);
				panel_3.add(lblIsbn);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 44, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);

				JLabel lblnoOfCopies = new JLabel("number of copies");
				lblnoOfCopies.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblnoOfCopies.setBounds(44, 84, 191, 31);
				panel_3.add(lblnoOfCopies);

				textField_6 = new JTextField();
				textField_6.setPreferredSize(new Dimension(6, 23));
				textField_6.setBounds(255, 84, 178, 31);
				panel_3.add(textField_6);
				textField_6.setColumns(10);

				JButton btnConfirm_1 = new JButton("Confirm");
				btnConfirm_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String isbn = textField.getText().trim();
						String noOfCopies = textField_6.getText().trim();
						if (isbn.isEmpty()) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You must put a valid isbn!", "Dialog",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (noOfCopies.isEmpty()) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You must put a valid number of copies!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						boolean success = shoppingCart.addItem(isbn,
								noOfCopies);
						if (!success)
							JOptionPane.showMessageDialog(new JFrame(),
									"Eror, this isbn is not exists!", "Dialog",
									JOptionPane.ERROR_MESSAGE);
						else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Book with isbn:" + isbn
											+ " is successfully added to cart!",
									"Dialog", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnConfirm_1.setBounds(466, 343, 89, 23);
				panel_3.add(btnConfirm_1);
			}
		});
		button_1.setBounds(289, 66, 89, 23);
		panel_2.add(button_1);

		JLabel lblGetItem = new JLabel("Get Item\r\n");
		lblGetItem.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGetItem.setBounds(36, 103, 157, 23);
		panel_2.add(lblGetItem);

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Get Items");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				String[][] data = shoppingCart.getItems();
				Table table = new Table(bookHeader, data);
			}
		});
		button.setBounds(289, 104, 89, 23);
		panel_2.add(button);

		JLabel lblGetTotalPrice = new JLabel("Get total price\r\n");
		lblGetTotalPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGetTotalPrice.setBounds(36, 145, 157, 23);
		panel_2.add(lblGetTotalPrice);

		JButton button_2 = new JButton("OK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Get total price");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 79, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				textField
						.setText(Float.toString(shoppingCart.getTotalPrices()));
			}
		});
		button_2.setBounds(289, 146, 89, 23);
		panel_2.add(button_2);

		JLabel lblRemoveItem = new JLabel("Remove Item");
		lblRemoveItem.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblRemoveItem.setBounds(36, 180, 157, 23);
		panel_2.add(lblRemoveItem);

		JButton button_3 = new JButton("OK");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Remove Item");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblIsbn = new JLabel("Isbn");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblIsbn.setBounds(44, 78, 191, 31);
				panel_3.add(lblIsbn);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 79, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);

				JButton btnConfirm_3 = new JButton("Confirm");
				btnConfirm_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String isbn = textField.getText();
						if (isbn.trim().isEmpty()) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You must enter a book isbn to remove",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						boolean success = shoppingCart.removeItem(isbn);
						if (!success) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Failed to remove the book, check that it is in cart first!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Book with isbn:" + isbn
											+ " is successfully removed from cart!",
									"Dialog", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
			}
		});
		button_3.setBounds(289, 181, 89, 23);
		panel_2.add(button_3);

		JLabel lblEmptyCart = new JLabel("Empty Cart");
		lblEmptyCart.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEmptyCart.setBounds(36, 215, 157, 23);
		panel_2.add(lblEmptyCart);

		JButton button_4 = new JButton("empty");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Empty cart");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);

				shoppingCart.emptyCart();
				JOptionPane.showMessageDialog(new JFrame(),
						"Cart is now empty!", "Dialog",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_4.setBounds(289, 216, 89, 23);
		panel_2.add(button_4);

		JButton button_5 = new JButton("OK");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Get cart size");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 79, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				textField.setText(String.valueOf(shoppingCart.getCartSize()));
			}
		});
		button_5.setBounds(289, 250, 89, 23);
		panel_2.add(button_5);

		JLabel lblGetCartSize = new JLabel("Get cart size");
		lblGetCartSize.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblGetCartSize.setBounds(36, 254, 157, 23);
		panel_2.add(lblGetCartSize);

		JButton button_6 = new JButton("OK");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JLabel lblGetUserInfo = new JLabel("Checkout");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblIsbn = new JLabel("Card number");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblIsbn.setBounds(44, 110, 191, 31);
				panel_3.add(lblIsbn);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 111, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);

				JLabel lblNoOfCopies_1 = new JLabel("Date");
				lblNoOfCopies_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblNoOfCopies_1.setBounds(44, 205, 191, 31);
				panel_3.add(lblNoOfCopies_1);

				textField_14 = new JTextField();
				textField_14.setPreferredSize(new Dimension(6, 23));
				textField_14.setColumns(10);
				textField_14.setBounds(255, 206, 178, 31);
				panel_3.add(textField_14);

				JButton btnConfirm_3 = new JButton("Confirm");
				btnConfirm_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String d = textField_14.getText().trim();
						String[] dateSplit = d.split("-");
						if (dateSplit.length != 3 || dateSplit[0].isEmpty()
								|| dateSplit[1].isEmpty()
								|| dateSplit[2].isEmpty()) {

							JOptionPane.showMessageDialog(new JFrame(),
									"Enter a valid date in form 'dd-mm-yyyy",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						int year = Integer.parseInt(dateSplit[2]);
						int month = Integer.parseInt(dateSplit[1]);
						int day = Integer.parseInt(dateSplit[0]);

						Date date = new Date(year, month, day);

						boolean success = shoppingCart
								.checkout(textField.getText(), date);
						if (!success) {
							JOptionPane.showMessageDialog(new JFrame(),
									"checkout failed, put a valid no of copies for books !",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Checked out seccessfully!", "Dialog",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);

				JLabel lblShouldBeA = new JLabel(
						"should be a MasterCard with 16 length and starts with 2221, 2720, 51, 55");
				lblShouldBeA.setFont(new Font("Calibri", Font.BOLD, 12));
				lblShouldBeA.setBounds(44, 52, 513, 31);
				panel_3.add(lblShouldBeA);
			}
		});
		button_6.setBounds(289, 284, 89, 23);
		panel_2.add(button_6);

		JLabel lblCheckout = new JLabel("Checkout\r\n");
		lblCheckout.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCheckout.setBounds(36, 288, 157, 23);
		panel_2.add(lblCheckout);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IShoppingCart s = new ShoppingCart(email);
				s.logOut();
				caller.setVisible(true);
				setVisible(false);

			}
		});
		btnBack.setBounds(385, 336, 89, 23);
		panel_2.add(btnBack);

		JLabel label = new JLabel(email);
		label.setFont(new Font("Calibri", Font.PLAIN, 15));
		label.setBounds(1127, 363, 233, 23);
		panel_2.add(label);

	}
}