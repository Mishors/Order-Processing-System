package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import operations.IUser;
import operations.Operations;
import javax.swing.border.CompoundBorder;

public class User extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	/**
	 * Create the frame.
	 */
	public User(String email) {
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

		JLabel lblUserProfile = new JLabel("User Profile");
		lblUserProfile.setFont(new Font("Calibri", Font.BOLD, 25));
		lblUserProfile.setBounds(36, 11, 124, 31);
		panel_2.add(lblUserProfile);

		JLabel lblNewLabel_1 = new JLabel("Get the user info\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 65, 157, 23);
		panel_2.add(lblNewLabel_1);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblGetUserInfo = new JLabel("Get the user info");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(719, 11, 182, 31);
				panel_2.add(lblGetUserInfo);

				JLabel lblEmail = new JLabel("Email\r\n");
				lblEmail.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblEmail.setBounds(845, 40, 191, 37);
				panel_2.add(lblEmail);

				JLabel lblUserName = new JLabel("User Name");
				lblUserName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserName.setBounds(845, 88, 191, 37);
				panel_2.add(lblUserName);

				JLabel lblUserPassword = new JLabel("User Password\r\n");
				lblUserPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserPassword.setBounds(845, 139, 191, 37);
				panel_2.add(lblUserPassword);

				JLabel lblFirstName = new JLabel("First name");
				lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblFirstName.setBounds(845, 187, 191, 37);
				panel_2.add(lblFirstName);

				JLabel lblLastName = new JLabel("Last Name\r\n");
				lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblLastName.setBounds(845, 235, 191, 37);
				panel_2.add(lblLastName);

				JLabel lblAddress = new JLabel("Address");
				lblAddress.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblAddress.setBounds(845, 286, 191, 37);
				panel_2.add(lblAddress);

				textField = new JTextField();
				textField.setBounds(1057, 40, 178, 37);
				panel_2.add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(1057, 88, 178, 37);
				panel_2.add(textField_1);

				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(1057, 136, 178, 37);
				panel_2.add(textField_2);

				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(1057, 187, 178, 37);
				panel_2.add(textField_3);

				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(1057, 236, 178, 37);
				panel_2.add(textField_4);

				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(1057, 287, 178, 37);
				panel_2.add(textField_5);

				table_1 = new JTable();
				table_1.setModel(new DefaultTableModel(
						new Object[][] { { null, null }, { null, null },
								{ null, null }, { null, null }, { null, null },
								{ null, null }, },
						new String[] { "New column", "New column" }));
				table_1.setRowHeight(50);
				table_1.setBounds(845, 32, 400, 300);
				panel_2.add(table_1);

				/*
				 * IUser user = new Operations(); String[] data = null; data =
				 * user.getUserInfo(email); textField.setText(data[0]);
				 * textField_1.setText(data[1]); textField_2.setText(data[2]);
				 * textField_3.setText(data[3]); textField_4.setText(data[4]);
				 * textField_5.setText(data[5]);
				 */
			}
		});
		btnOk.setBounds(289, 66, 89, 23);
		panel_2.add(btnOk);

		JLabel lblEditInfo = new JLabel("Edit info");
		lblEditInfo.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblEditInfo.setBounds(36, 134, 82, 23);
		panel_2.add(lblEditInfo);

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JLabel lblGetUserInfo = new JLabel("Edit info");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(719, 11, 182, 31);
				panel_2.add(lblGetUserInfo);

				JLabel lblEmail = new JLabel("Email\r\n");
				lblEmail.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblEmail.setBounds(845, 40, 191, 37);
				panel_2.add(lblEmail);

				JLabel lblUserName = new JLabel("User Name");
				lblUserName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserName.setBounds(845, 88, 191, 37);
				panel_2.add(lblUserName);

				JLabel lblUserPassword = new JLabel("User Password\r\n");
				lblUserPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserPassword.setBounds(845, 139, 191, 37);
				panel_2.add(lblUserPassword);

				JLabel lblFirstName = new JLabel("First name");
				lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblFirstName.setBounds(845, 187, 191, 37);
				panel_2.add(lblFirstName);

				JLabel lblLastName = new JLabel("Last Name\r\n");
				lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblLastName.setBounds(845, 235, 191, 37);
				panel_2.add(lblLastName);

				JLabel lblAddress = new JLabel("Address");
				lblAddress.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblAddress.setBounds(845, 286, 191, 37);
				panel_2.add(lblAddress);

				textField = new JTextField();
				textField.setBounds(1057, 40, 178, 37);
				panel_2.add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(1057, 88, 178, 37);
				panel_2.add(textField_1);

				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(1057, 136, 178, 37);
				panel_2.add(textField_2);

				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(1057, 187, 178, 37);
				panel_2.add(textField_3);

				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(1057, 236, 178, 37);
				panel_2.add(textField_4);

				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(1057, 287, 178, 37);
				panel_2.add(textField_5);

				table_1 = new JTable();
				table_1.setModel(new DefaultTableModel(
						new Object[][] { { null, null }, { null, null },
								{ null, null }, { null, null }, { null, null },
								{ null, null }, },
						new String[] { "New column", "New column" }));
				table_1.setRowHeight(50);
				table_1.setBounds(845, 32, 400, 300);
				panel_2.add(table_1);

				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						IUser user = new Operations();
						String[] data = null;
						String[] att = null;
						int i = 0;
						if (textField.getText() != "") {
							data[i] = textField.getText();
							att[i] = "email";
							i++;
						}
						if (textField_1.getText() != "") {
							data[i] = textField_1.getText();
							att[i] = "userName";
							i++;
						}
						if (textField_2.getText() != "") {
							data[i] = textField_2.getText();
							att[i] = "userPassword";
							i++;
						}
						if (textField_3.getText() != "") {
							data[i] = textField_3.getText();
							att[i] = "firstName";
							i++;
						}
						if (textField_4.getText() != "") {
							data[i] = textField_4.getText();
							att[i] = "lastName";
							i++;
						}
						if (textField_5.getText() != "") {
							data[i] = textField_5.getText();
							att[i] = "shippingAdd";
							i++;
						}
						IUser u = new Operations();
						u.editUserInfo(email, att, data);
					}
				});
				btnConfirm.setBounds(1208, 338, 89, 23);
				panel_2.add(btnConfirm);

			}
		});
		button.setBounds(289, 135, 89, 23);
		panel_2.add(button);

		JLabel lblSearchForBook = new JLabel("Search for book\r\n");
		lblSearchForBook.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSearchForBook.setBounds(36, 209, 139, 23);
		panel_2.add(lblSearchForBook);

		JButton button_1 = new JButton("OK");
		button_1.setBounds(289, 210, 89, 23);
		panel_2.add(button_1);

		JLabel lblSearchForBook_1 = new JLabel("Search for book Advanced\r\n");
		lblSearchForBook_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSearchForBook_1.setBounds(36, 281, 227, 23);
		panel_2.add(lblSearchForBook_1);

		JButton button_2 = new JButton("OK");
		button_2.setBounds(289, 282, 89, 23);
		panel_2.add(button_2);

		JButton btnLogOut = new JButton("Log Out\r\n");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				WelcomeWindow s = new WelcomeWindow();
				s.setVisible(true);
			}
		});
		btnLogOut.setBounds(475, 338, 89, 23);
		panel_2.add(btnLogOut);

		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ShoppingCart s = new ShoppingCart(email);
				s.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(346, 338, 108, 23);
		panel_2.add(btnShoppingCart);

		JLabel label = new JLabel(email);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		label.setBounds(1127, 363, 233, 23);
		panel_2.add(label);

	}
}