package main;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import operations.IUser;
import operations.Operations;
import javax.swing.JRadioButton;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User(null);
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
				panel_3.removeAll();
				
				JLabel lblGetUserInfo_1 = new JLabel("Get the user info");
				lblGetUserInfo_1.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo_1.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo_1);
				
				JLabel lblEmail_1 = new JLabel("Email");
				lblEmail_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblEmail_1.setBounds(44, 53, 191, 37);
				panel_3.add(lblEmail_1);
				
				JLabel lblUserName_1 = new JLabel("User Name");
				lblUserName_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserName_1.setBounds(44, 103, 191, 37);
				panel_3.add(lblUserName_1);
				
				JLabel lblUserPassword_1 = new JLabel("User Password");
				lblUserPassword_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserPassword_1.setBounds(44, 155, 191, 37);
				panel_3.add(lblUserPassword_1);
				
				JLabel lblFirstName_1 = new JLabel("First name");
				lblFirstName_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblFirstName_1.setBounds(44, 203, 191, 37);
				panel_3.add(lblFirstName_1);
				
				JLabel lblLastName_1 = new JLabel("Last Name\r\n");
				lblLastName_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblLastName_1.setBounds(44, 253, 191, 37);
				panel_3.add(lblLastName_1);
				
				JLabel lblAddress_1 = new JLabel("Address");
				lblAddress_1.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblAddress_1.setBounds(44, 301, 191, 37);
				panel_3.add(lblAddress_1);
				
				textField = new JTextField();
				textField.setBounds(255, 54, 178, 37);
				panel_3.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(255, 104, 178, 37);
				panel_3.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(255, 156, 178, 37);
				panel_3.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(255, 204, 178, 37);
				panel_3.add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(255, 254, 178, 37);
				panel_3.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(255, 302, 178, 37);
				panel_3.add(textField_5);
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 270, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				IUser user = new Operations();
				String[] data;
				data = user.getUserInfo(email);
				textField.setText(data[0]);
				textField_1.setText(data[1]);
				textField_2.setText(data[2]);
				textField_3.setText(data[3]);
				textField_4.setText(data[4]);
				textField_5.setText(data[5]);
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
				panel_3.removeAll();
				
				JLabel lblGetUserInfo = new JLabel("Edit info");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);
				
				JLabel lblEmail = new JLabel("Email\r\n");
				lblEmail.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblEmail.setBounds(44, 53, 191, 37);
				panel_3.add(lblEmail);
				
				JLabel lblUserName = new JLabel("User Name");
				lblUserName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserName.setBounds(44, 103, 191, 37);
				panel_3.add(lblUserName);
				
				JLabel lblUserPassword = new JLabel("User Password\r\n");
				lblUserPassword.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblUserPassword.setBounds(44, 155, 191, 37);
				panel_3.add(lblUserPassword);
				
				JLabel lblFirstName = new JLabel("First name");
				lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblFirstName.setBounds(44, 203, 191, 37);
				panel_3.add(lblFirstName);
				
				JLabel lblLastName = new JLabel("Last Name\r\n");
				lblLastName.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblLastName.setBounds(44, 253, 191, 37);
				panel_3.add(lblLastName);
				
				JLabel lblAddress = new JLabel("Address");
				lblAddress.setFont(new Font("Calibri", Font.PLAIN, 20));
				lblAddress.setBounds(44, 301, 191, 37);
				panel_3.add(lblAddress);
				
				textField = new JTextField();
				textField.setBounds(255, 54, 178, 37);
				panel_3.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(255, 104, 178, 37);
				panel_3.add(textField_1);
				
				textField_2 = new JPasswordField();
				textField_2.setColumns(10);
				textField_2.setBounds(255, 156, 178, 37);
				panel_3.add(textField_2);
				
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(255, 204, 178, 37);
				panel_3.add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(255, 254, 178, 37);
				panel_3.add(textField_4);
				
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(255, 302, 178, 37);
				panel_3.add(textField_5);
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 270, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						IUser user = new Operations();
						String[] data = null;
						String[] att = null;
						int i = 0;
						if(textField.getText() != ""){
						    data[i] = textField.getText();
						    att[i] = "email";
						    i++;
						}
						if(textField_1.getText() != ""){
							data[i] = textField_1.getText();
							att[i] = "userName";
							i++;
						}
						if(textField_2.getText() != ""){
							data[i] = textField_2.getText();
							att[i] = "userPassword";
							i++;
						}
						if(textField_3.getText() != ""){
							data[i] = textField_3.getText();
							att[i] = "firstName";
							i++;
						}
						if(textField_4.getText() != ""){
							data[i] = textField_4.getText();
							att[i] = "lastName";
							i++;
						}
						if(textField_5.getText() != ""){
							data[i] = textField_5.getText();
							att[i] = "shippingAdd";
							i++;
						}
						IUser u = new Operations();
						boolean success = u.editUserInfo(email, att, data);
						if(!success)
							JOptionPane.showMessageDialog(new JFrame(), "Failed on editing the user info", "Dialog",JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm.setBounds(450, 315, 89, 23);
				panel_3.add(btnConfirm);	
				
			}
		});
		button.setBounds(289, 135, 89, 23);
		panel_2.add(button);
		
		JLabel lblSearchForBook = new JLabel("Search for book");
		lblSearchForBook.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSearchForBook.setBounds(36, 209, 139, 23);
		panel_2.add(lblSearchForBook);
		
		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                panel_3.removeAll();
                
                JLabel label = new JLabel(email);
        		label.setBounds(350, 363, 250, 23);
        		panel_3.add(label);
        		label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblGetUserInfo = new JLabel("Search for book");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 25));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Isbn");
				rdbtnNewRadioButton.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnNewRadioButton.setBounds(44, 43, 191, 31);
				panel_3.add(rdbtnNewRadioButton);
				
				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 44, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);
				
				JRadioButton rdbtnTitle = new JRadioButton("Title");
				rdbtnTitle.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnTitle.setBounds(44, 87, 191, 31);
				panel_3.add(rdbtnTitle);
				
				JRadioButton rdbtnPublisherName = new JRadioButton("Publisher name");
				rdbtnPublisherName.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnPublisherName.setBounds(44, 131, 191, 31);
				panel_3.add(rdbtnPublisherName);
				
				JRadioButton rdbtnPublishingYear = new JRadioButton("Publishing year");
				rdbtnPublishingYear.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnPublishingYear.setBounds(44, 175, 191, 31);
				panel_3.add(rdbtnPublishingYear);
				
				JRadioButton rdbtnPrice = new JRadioButton("Price");
				rdbtnPrice.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnPrice.setBounds(44, 216, 191, 31);
				panel_3.add(rdbtnPrice);
				
				JRadioButton rdbtnCategory = new JRadioButton("Category");
				rdbtnCategory.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnCategory.setBounds(44, 256, 191, 31);
				panel_3.add(rdbtnCategory);
				
				JRadioButton rdbtnThreshold = new JRadioButton("Threshold");
				rdbtnThreshold.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnThreshold.setBounds(44, 295, 191, 31);
				panel_3.add(rdbtnThreshold);
				
				JRadioButton rdbtnNoOfCopies = new JRadioButton("No of copies");
				rdbtnNoOfCopies.setFont(new Font("Calibri", Font.PLAIN, 20));
				rdbtnNoOfCopies.setBounds(44, 335, 191, 31);
				panel_3.add(rdbtnNoOfCopies);
				
				ButtonGroup group = new ButtonGroup();
				group.add(rdbtnNewRadioButton);
				group.add(rdbtnNoOfCopies);
				group.add(rdbtnThreshold);
				group.add(rdbtnCategory);
				group.add(rdbtnPrice);
				group.add(rdbtnPublishingYear);
				group.add(rdbtnPublisherName);
				group.add(rdbtnTitle);
				
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
						String value = null, attribute = group.getSelection().getActionCommand();
						switch (attribute) {
						case "isbn":
							value = textField.getText();
							break;
						case "title":
							value = textField_6.getText();
							break;
						case "publisher_name":
							value = textField_7.getText();
							break;
						case "publishing_year":
							value = textField_8.getText();
							break;
						case "price":
							value = textField_9.getText();
							break;
						case "category":
							value = textField_10.getText();
							break;
						case "threshold":
							value = textField_11.getText();
							break;
						case "no_of_copies":
							value = textField_12.getText();
							break;
						default:
							JOptionPane.showMessageDialog(new JFrame(), "Unexpected Error in radio buttons!", "Dialog",JOptionPane.ERROR_MESSAGE);
						}
						IUser user = new Operations();
						String[][] result = user.searchForBooks(attribute,value);
						
					}
				});
				btnConfirm_1.setBounds(466, 343, 89, 23);
				panel_3.add(btnConfirm_1);
				
			}
		});
		button_1.setBounds(289, 210, 89, 23);
		panel_2.add(button_1);
		
		JLabel lblSearchForBook_1 = new JLabel("Search for book Advanced\r\n");
		lblSearchForBook_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblSearchForBook_1.setBounds(36, 281, 227, 23);
		panel_2.add(lblSearchForBook_1);
		
		JButton button_2 = new JButton("OK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.removeAll();
				
				JLabel label = new JLabel(email);
				label.setBounds(350, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 20));
				
				JLabel lblYouCanUse = new JLabel("You can use and , or and brackets\r\n");
				lblYouCanUse.setFont(new Font("Calibri", Font.BOLD, 20));
				lblYouCanUse.setBounds(44, 51, 478, 31);
				panel_3.add(lblYouCanUse);
				
				JLabel lblForExample = new JLabel("For example :");
				lblForExample.setFont(new Font("Calibri", Font.BOLD, 20));
				lblForExample.setBounds(44, 86, 478, 31);
				panel_3.add(lblForExample);
				
				JLabel lblisbnAndTitlec = new JLabel("(Isbn=2 and title=\"C Programming\") or Price<50");
				lblisbnAndTitlec.setFont(new Font("Calibri", Font.BOLD, 20));
				lblisbnAndTitlec.setBounds(44, 119, 478, 31);
				panel_3.add(lblisbnAndTitlec);
				
				JLabel lblCondition = new JLabel("Condition");
				lblCondition.setFont(new Font("Calibri", Font.BOLD, 20));
				lblCondition.setBounds(44, 217, 94, 31);
				panel_3.add(lblCondition);
				
				textField_13 = new JTextField();
				textField_13.setBounds(148, 218, 452, 31);
				panel_3.add(textField_13);
				textField_13.setColumns(10);
				
				JButton btnConfirm_2 = new JButton("Confirm");
				btnConfirm_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField_13.getText() != "")
						{
							IUser u = new Operations();
							String[][] result = u.searchForBooksAdvanced(textField_13.getText());
						}
					}
				});
				btnConfirm_2.setBounds(469, 329, 89, 23);
				panel_3.add(btnConfirm_2);
			}
		});
		button_2.setBounds(289, 282, 89, 23);
		panel_2.add(button_2);
		
		JButton btnLogOut = new JButton("Log Out\r\n");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				GUI s = new GUI();
				s.setVisible(true);
			}
		});
		btnLogOut.setBounds(475, 338, 89, 23);
		panel_2.add(btnLogOut);
		
		JButton btnShoppingCart = new JButton("Shopping Cart");
		btnShoppingCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				shoppingCart s = new shoppingCart(email , false);
				s.setVisible(true);
			}
		});
		btnShoppingCart.setBounds(346, 338, 108, 23);
		panel_2.add(btnShoppingCart);
		
		JLabel label = new JLabel(email);
		label.setBounds(350, 363, 250, 23);
		panel_3.add(label);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
	}
}
