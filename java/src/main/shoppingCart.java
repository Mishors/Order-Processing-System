package main;

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

public class shoppingCart extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shoppingCart frame = new shoppingCart(null , (Boolean) null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public shoppingCart(String email , boolean admin) {
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
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 50));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel , BorderLayout.CENTER);
		
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
		lblUserProfile.setFont(new Font("Calibri", Font.BOLD, 25));
		lblUserProfile.setBounds(36, 11, 157, 31);
		panel_2.add(lblUserProfile);
		
		JLabel lblNewLabel_1 = new JLabel("Add Item\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 65, 157, 23);
		panel_2.add(lblNewLabel_1);
		
		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Add Item");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);
				
				JLabel lblIsbn = new JLabel("Isbn");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblIsbn.setBounds(44, 44, 191, 31);
				panel_3.add(lblIsbn);
				
				JLabel lblTitle = new JLabel("Title");
				lblTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblTitle.setBounds(44, 86, 191, 31);
				panel_3.add(lblTitle);
				
				JLabel lblPublisherName = new JLabel("Publisher name");
				lblPublisherName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblPublisherName.setBounds(44, 131, 191, 31);
				panel_3.add(lblPublisherName);
				
				JLabel lblPublishingYear = new JLabel("Publishing year");
				lblPublishingYear.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblPublishingYear.setBounds(44, 175, 191, 31);
				panel_3.add(lblPublishingYear);
				
				JLabel lblPrice = new JLabel("Price");
				lblPrice.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblPrice.setBounds(44, 216, 191, 31);
				panel_3.add(lblPrice);
				
				JLabel lblCategory = new JLabel("Category");
				lblCategory.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblCategory.setBounds(44, 256, 191, 31);
				panel_3.add(lblCategory);
				
				JLabel lblThreshold = new JLabel("Threshold");
				lblThreshold.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblThreshold.setBounds(44, 295, 191, 31);
				panel_3.add(lblThreshold);
				
				JLabel lblNoOfCopies = new JLabel("No of copies");
				lblNoOfCopies.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblNoOfCopies.setBounds(44, 335, 191, 31);
				panel_3.add(lblNoOfCopies);
				
				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 44, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				
				textField_6 = new JTextField();
				textField_6.setPreferredSize(new Dimension(6, 23));
				textField_6.setColumns(10);
				textField_6.setBounds(255, 86, 178, 31);
				panel_3.add(textField_6);
				
				textField_7 = new JTextField();
				textField_7.setPreferredSize(new Dimension(6, 23));
				textField_7.setColumns(10);
				textField_7.setBounds(255, 131, 178, 31);
				panel_3.add(textField_7);
				
				textField_8 = new JTextField();
				textField_8.setPreferredSize(new Dimension(6, 23));
				textField_8.setColumns(10);
				textField_8.setBounds(255, 175, 178, 31);
				panel_3.add(textField_8);
				
				textField_9 = new JTextField();
				textField_9.setPreferredSize(new Dimension(6, 23));
				textField_9.setColumns(10);
				textField_9.setBounds(255, 216, 178, 31);
				panel_3.add(textField_9);
				
				textField_10 = new JTextField();
				textField_10.setPreferredSize(new Dimension(6, 23));
				textField_10.setColumns(10);
				textField_10.setBounds(255, 256, 178, 31);
				panel_3.add(textField_10);
				
				textField_11 = new JTextField();
				textField_11.setPreferredSize(new Dimension(6, 23));
				textField_11.setColumns(10);
				textField_11.setBounds(255, 295, 178, 31);
				panel_3.add(textField_11);
				
				textField_12 = new JTextField();
				textField_12.setPreferredSize(new Dimension(6, 23));
				textField_12.setColumns(10);
				textField_12.setBounds(255, 335, 178, 31);
				panel_3.add(textField_12);
				
				JButton btnConfirm_1 = new JButton("Confirm");
				btnConfirm_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IShoppingCart s = new ShoppingCart(email);
						String[] info = { textField.getText(), textField_6.getText(),textField_7.getText(), textField_8.getText(),textField_9.getText(), textField_10.getText(), textField_11.getText(), textField_12.getText() };
						s.addItem(info);
					}
				});
				btnConfirm_1.setBounds(466, 343, 89, 23);
				panel_3.add(btnConfirm_1);
			}
		});
		button_1.setBounds(289, 66, 89, 23);
		panel_2.add(button_1);
		
		JLabel lblGetItem = new JLabel("Get Item\r\n");
		lblGetItem.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetItem.setBounds(36, 103, 157, 23);
		panel_2.add(lblGetItem);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Get Items");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);
				
				IShoppingCart s = new ShoppingCart(email);
				String[][] data = s.getItems();
				
			}
		});
		button.setBounds(289, 104, 89, 23);
		panel_2.add(button);
		
		JLabel lblGetTotalPrice = new JLabel("Get total price\r\n");
		lblGetTotalPrice.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetTotalPrice.setBounds(36, 145, 157, 23);
		panel_2.add(lblGetTotalPrice);
		
		JButton button_2 = new JButton("OK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Get total price");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);
				
				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 79, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				
				IShoppingCart s = new ShoppingCart(email);
				textField.setText(Float.toString(s.getTotalPrices()));
			}
		});
		button_2.setBounds(289, 146, 89, 23);
		panel_2.add(button_2);
		
		JLabel lblRemoveItem = new JLabel("Remove Item");
		lblRemoveItem.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblRemoveItem.setBounds(36, 180, 157, 23);
		panel_2.add(lblRemoveItem);
		
		JButton button_3 = new JButton("OK");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Remove Item");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);
				
				JLabel lblIsbn = new JLabel("Isbn");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 20));
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
						IShoppingCart s = new ShoppingCart(email);
						boolean success = s.removeItem(textField.getText());
						if(!success)
							JOptionPane.showMessageDialog(new JFrame(), "Failed to remove the book", "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
			}
		});
		button_3.setBounds(289, 181, 89, 23);
		panel_2.add(button_3);
		
		JLabel lblEmptyCart = new JLabel("Empty Cart");
		lblEmptyCart.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblEmptyCart.setBounds(36, 215, 157, 23);
		panel_2.add(lblEmptyCart);
		
		JButton button_4 = new JButton("OK");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Empty cart");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);
				
				IShoppingCart s =  new ShoppingCart(email);
				s.emptyCart();
			}
		});
		button_4.setBounds(289, 216, 89, 23);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("OK");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    panel_3.removeAll();
					
					JLabel label = new JLabel(email);
					label.setBounds(350, 363, 250, 23);
					panel_3.add(label);
					label.setFont(new Font("Calibri", Font.PLAIN, 20));
					
					JLabel lblGetUserInfo = new JLabel("Get cart size");
					lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
					lblGetUserInfo.setBounds(20, 11, 240, 31);
					panel_3.add(lblGetUserInfo);
					
					textField = new JTextField();
					textField.setPreferredSize(new Dimension(6, 23));
					textField.setBounds(255, 79, 178, 31);
					panel_3.add(textField);
					textField.setColumns(10);
					
					IShoppingCart s = new ShoppingCart(email);
					textField.setText(String.valueOf(s.getCartSize()));
			}
		});
		button_5.setBounds(289, 250, 89, 23);
		panel_2.add(button_5);
		
		JLabel lblGetCartSize = new JLabel("Get cart size");
		lblGetCartSize.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetCartSize.setBounds(36, 254, 157, 23);
		panel_2.add(lblGetCartSize);
		
		JButton button_6 = new JButton("OK");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Checkout");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);
				
				JLabel lblIsbn = new JLabel("Card number");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblIsbn.setBounds(44, 110, 191, 31);
				panel_3.add(lblIsbn);
				
				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 111, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				
				JLabel lblNoOfCopies_1 = new JLabel("Date");
				lblNoOfCopies_1.setFont(new Font("Calibri", Font.PLAIN, 20));
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
						IShoppingCart s = new ShoppingCart(email);
						DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
						Date date = null;
						try {
							date = (Date) format.parse(textField_14.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						boolean success = s.checkout(textField.getText(), date);
						if(!success)
							JOptionPane.showMessageDialog(new JFrame(), "checkout failed !!!!", "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
				
				JLabel lblShouldBeA = new JLabel("should be a MasterCard with 16 length and starts with 2221, 2720, 51, 55");
				lblShouldBeA.setFont(new Font("Calibri", Font.BOLD, 16));
				lblShouldBeA.setBounds(44, 52, 513, 31);
				panel_3.add(lblShouldBeA);
			}
		});
		button_6.setBounds(289, 284, 89, 23);
		panel_2.add(button_6);
		
		JLabel lblCheckout = new JLabel("Checkout\r\n");
		lblCheckout.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCheckout.setBounds(36, 288, 157, 23);
		panel_2.add(lblCheckout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IShoppingCart s = new ShoppingCart(email);
				s.logOut();
				setVisible(false);
				if(admin){
					Admin a = new Admin(email);
					a.setVisible(true);
				} else {
					User u = new User(email);
					u.setVisible(true);
				}
				
			}
		});
		btnBack.setBounds(385, 336, 89, 23);
		panel_2.add(btnBack);
		
		JLabel label = new JLabel(email);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(1127, 363, 233, 23);
		panel_2.add(label);
		
	}
}
