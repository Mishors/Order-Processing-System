package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShoppingCart extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ShoppingCart(String email) {
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
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setPreferredSize(new Dimension(1400, 150));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel(null);
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);

		JLabel lblUserProfile = new JLabel("Shopping Cart");
		lblUserProfile.setFont(new Font("Calibri", Font.BOLD, 25));
		lblUserProfile.setBounds(36, 11, 157, 31);
		panel_2.add(lblUserProfile);

		JLabel lblNewLabel_1 = new JLabel("Add Item\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 65, 157, 23);
		panel_2.add(lblNewLabel_1);

		JButton button_1 = new JButton("OK");
		button_1.setBounds(289, 66, 89, 23);
		panel_2.add(button_1);

		JLabel lblGetItem = new JLabel("Get Item\r\n");
		lblGetItem.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetItem.setBounds(36, 103, 157, 23);
		panel_2.add(lblGetItem);

		JButton button = new JButton("OK");
		button.setBounds(289, 104, 89, 23);
		panel_2.add(button);

		JLabel lblGetTotalPrice = new JLabel("Get total price\r\n");
		lblGetTotalPrice.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetTotalPrice.setBounds(36, 145, 157, 23);
		panel_2.add(lblGetTotalPrice);

		JButton button_2 = new JButton("OK");
		button_2.setBounds(289, 146, 89, 23);
		panel_2.add(button_2);

		JLabel lblRemoveItem = new JLabel("Remove Item");
		lblRemoveItem.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblRemoveItem.setBounds(36, 180, 157, 23);
		panel_2.add(lblRemoveItem);

		JButton button_3 = new JButton("OK");
		button_3.setBounds(289, 181, 89, 23);
		panel_2.add(button_3);

		JLabel lblEmptyCart = new JLabel("Empty Cart");
		lblEmptyCart.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblEmptyCart.setBounds(36, 215, 157, 23);
		panel_2.add(lblEmptyCart);

		JButton button_4 = new JButton("OK");
		button_4.setBounds(289, 216, 89, 23);
		panel_2.add(button_4);

		JButton button_5 = new JButton("OK");
		button_5.setBounds(289, 250, 89, 23);
		panel_2.add(button_5);

		JLabel lblGetCartSize = new JLabel("Get cart size");
		lblGetCartSize.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblGetCartSize.setBounds(36, 254, 157, 23);
		panel_2.add(lblGetCartSize);

		JButton button_6 = new JButton("OK");
		button_6.setBounds(289, 284, 89, 23);
		panel_2.add(button_6);

		JLabel lblCheckout = new JLabel("Checkout\r\n");
		lblCheckout.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblCheckout.setBounds(36, 288, 157, 23);
		panel_2.add(lblCheckout);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(385, 336, 89, 23);
		panel_2.add(btnBack);

		JLabel label = new JLabel(email);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(1127, 363, 233, 23);
		panel_2.add(label);
	}
}
