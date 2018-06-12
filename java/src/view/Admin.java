package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dbManager.Connector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import operations.IAdmin;
import operations.IUser;
import operations.Operations;

public class Admin extends JFrame {

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
	private JTextField textField_14;
	private JTextField textField_author;
	private JTextField phoneTF;
	private static String email;
	private String[] bookHeader = { "isbn", "title", "pblisher name",
			"publishing year", "price", "category", "threshold",
			"number of copies", "athors" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(null);
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
	public Admin(String email) {
		this.email = email;

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
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
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
		panel_3.setPreferredSize(new Dimension(550, 300));
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setBackground(Color.WHITE);

		JLabel lblUserProfile = new JLabel("Admin Profile");
		lblUserProfile.setFont(new Font("Calibri", Font.BOLD, 17));
		lblUserProfile.setBounds(36, 11, 157, 31);
		panel_2.add(lblUserProfile);

		JLabel lblNewLabel_1 = new JLabel("Get the admin info\r\n");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 42, 167, 23);
		panel_2.add(lblNewLabel_1);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel lblGetUserInfo_1 = new JLabel("Get the user info");
				lblGetUserInfo_1.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo_1.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo_1);

				JLabel lblEmail_1 = new JLabel("Email");
				lblEmail_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblEmail_1.setBounds(44, 53, 191, 37);
				panel_3.add(lblEmail_1);

				JLabel lblUserName_1 = new JLabel("Admin Name");
				lblUserName_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblUserName_1.setBounds(44, 103, 191, 37);
				panel_3.add(lblUserName_1);

				JLabel lblUserPassword_1 = new JLabel("Admin Password");
				lblUserPassword_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblUserPassword_1.setBounds(44, 155, 191, 37);
				panel_3.add(lblUserPassword_1);

				JLabel lblFirstName_1 = new JLabel("First name");
				lblFirstName_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblFirstName_1.setBounds(44, 203, 191, 37);
				panel_3.add(lblFirstName_1);

				JLabel lblLastName_1 = new JLabel("Last Name\r\n");
				lblLastName_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblLastName_1.setBounds(44, 253, 191, 37);
				panel_3.add(lblLastName_1);

				JLabel lblAddress_1 = new JLabel("Address");
				lblAddress_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblAddress_1.setBounds(44, 301, 191, 37);
				panel_3.add(lblAddress_1);

				textField = new JTextField();
				textField.setBounds(255, 54, 178, 37);
				textField.setEditable(false);
				panel_3.add(textField);
				textField.setColumns(10);

				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(255, 104, 178, 37);
				textField_1.setEditable(false);
				panel_3.add(textField_1);

				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(255, 156, 178, 37);
				textField_2.setEditable(false);
				panel_3.add(textField_2);

				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(255, 204, 178, 37);
				textField_3.setEditable(false);
				panel_3.add(textField_3);

				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(255, 254, 178, 37);
				textField_4.setEditable(false);
				panel_3.add(textField_4);

				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(255, 302, 178, 37);
				textField_5.setEditable(false);
				panel_3.add(textField_5);

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 270, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				IAdmin user = new Operations();
				String[] data;
				data = user.getUserInfo(Admin.email);
				textField.setText(data[0]);
				textField_1.setText(data[1]);
				textField_2.setText(data[2]);
				textField_3.setText(data[3]);
				textField_4.setText(data[4]);
				textField_5.setText(data[5]);

				phoneTF = new JTextField();
				phoneTF.setColumns(10);
				phoneTF.setBounds(255, 348, 178, 37);
				panel_3.add(phoneTF);
				phoneTF.setEditable(false);

				String phones = "";
				for (int i = 6; i < data.length - 1; i++) {
					phones += data[i] + " - ";
				}
				if (data.length > 6)
					phones += data[data.length - 1];
				phoneTF.setText(phones);
			}
		});
		btnOk.setBounds(289, 43, 89, 23);
		panel_2.add(btnOk);

		JLabel lblEditInfo = new JLabel("Edit info");
		lblEditInfo.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEditInfo.setBounds(36, 76, 82, 23);
		panel_2.add(lblEditInfo);

		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel lblGetUserInfo = new JLabel("Edit info");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblEmail = new JLabel("Email\r\n");
				lblEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblEmail.setBounds(44, 53, 191, 37);
				panel_3.add(lblEmail);

				JLabel lblUserName = new JLabel("Admin Name");
				lblUserName.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblUserName.setBounds(44, 103, 191, 37);
				panel_3.add(lblUserName);

				JLabel lblUserPassword = new JLabel("Admin Password\r\n");
				lblUserPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblUserPassword.setBounds(44, 155, 191, 37);
				panel_3.add(lblUserPassword);

				JLabel lblFirstName = new JLabel("First name");
				lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblFirstName.setBounds(44, 203, 191, 37);
				panel_3.add(lblFirstName);

				JLabel lblLastName = new JLabel("Last Name\r\n");
				lblLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblLastName.setBounds(44, 253, 191, 37);
				panel_3.add(lblLastName);

				JLabel lblAddress = new JLabel("Address");
				lblAddress.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblAddress.setBounds(44, 301, 191, 37);
				panel_3.add(lblAddress);

				JLabel phoneInfoLabel = new JLabel("Phone Numbers");
				phoneInfoLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
				phoneInfoLabel.setBounds(44, 349, 191, 37);
				panel_3.add(phoneInfoLabel);

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

				phoneTF = new JTextField();
				phoneTF.setColumns(10);
				phoneTF.setBounds(255, 348, 178, 37);
				panel_3.add(phoneTF);

				IAdmin user = new Operations();
				String[] data;
				data = user.getUserInfo(Admin.email);
				String phones = "";
				for (int i = 6; i < data.length - 1; i++) {
					phones += data[i] + " , ";
				}
				if (data.length > 6)
					phones += data[data.length - 1];
				phoneTF.setText(phones);

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 270, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 15));

				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ArrayList<String> data = new ArrayList<>();
						ArrayList<String> att = new ArrayList<>();
						int i = 0;
						String oldEmail = Admin.email;
						if (!textField.getText().trim().isEmpty()) {
							data.add(textField.getText());
							att.add("email");
							i++;
							Admin.email = textField.getText();
							label.setText("Hi: " + Admin.email);
						}
						if (!textField_1.getText().trim().isEmpty()) {
							data.add(textField_1.getText());
							att.add("user_name");
							i++;
						}
						if (!textField_2.getText().trim().isEmpty()) {
							data.add(textField_2.getText());
							att.add("user_password");
							i++;
						}
						if (!textField_3.getText().trim().isEmpty()) {
							data.add(textField_3.getText());
							att.add("first_name");
							i++;
						}
						if (!textField_4.getText().trim().isEmpty()) {
							data.add(textField_4.getText());
							att.add("last_name");
							i++;
						}
						if (!textField_5.getText().trim().isEmpty()) {
							data.add(textField_5.getText());
							att.add("shipping_add");
							i++;
						}

						String temp = phoneTF.getText().trim();
						String[] phonesArr = temp.split(",");
						if (temp.isEmpty() || phonesArr.length < 1) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You Must leave at least 1 phone number!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						String[] dataArr = data
								.toArray(new String[data.size()]);
						String[] attArr = att.toArray(new String[att.size()]);
						IAdmin u = new Operations();
						if (phonesArr[0].isEmpty())
							phonesArr = null;
						boolean success = u.editUserInfo(oldEmail, attArr,
								dataArr, phonesArr);
						if (!success)
							JOptionPane.showMessageDialog(new JFrame(),
									"Failed on editing the user info", "Dialog",
									JOptionPane.ERROR_MESSAGE);
						else {
							JOptionPane.showMessageDialog(new JFrame(),
									"Your information is successfully updated!",
									"Dialog", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnConfirm.setBounds(450, 315, 89, 23);
				panel_3.add(btnConfirm);
			}
		});
		button.setBounds(289, 77, 89, 23);
		panel_2.add(button);

		JLabel lblSearchForBook = new JLabel("Search for book\r\n");
		lblSearchForBook.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSearchForBook.setBounds(36, 110, 139, 23);
		panel_2.add(lblSearchForBook);

		JButton button_1 = new JButton("OK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi: " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblGetUserInfo = new JLabel("Search for book");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				JRadioButton rdbtnNewRadioButton = new JRadioButton("Isbn");
				rdbtnNewRadioButton
						.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnNewRadioButton.setBounds(44, 43, 191, 31);
				rdbtnNewRadioButton.setActionCommand("isbn");
				panel_3.add(rdbtnNewRadioButton);

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 44, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);

				JRadioButton rdbtnTitle = new JRadioButton("Title");
				rdbtnTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnTitle.setBounds(44, 87, 191, 31);
				panel_3.add(rdbtnTitle);
				rdbtnTitle.setActionCommand("title");

				JRadioButton rdbtnPublisherName = new JRadioButton(
						"Publisher name");
				rdbtnPublisherName.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnPublisherName.setBounds(44, 131, 191, 31);
				panel_3.add(rdbtnPublisherName);
				rdbtnPublisherName.setActionCommand("publisher_name");

				JRadioButton rdbtnPublishingYear = new JRadioButton(
						"Publishing year");
				rdbtnPublishingYear
						.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnPublishingYear.setBounds(44, 175, 191, 31);
				panel_3.add(rdbtnPublishingYear);
				rdbtnPublishingYear.setActionCommand("publishing_year");

				JRadioButton rdbtnPrice = new JRadioButton("Price");
				rdbtnPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnPrice.setBounds(44, 216, 191, 31);
				panel_3.add(rdbtnPrice);
				rdbtnPrice.setActionCommand("price");

				JRadioButton rdbtnCategory = new JRadioButton("Category");
				rdbtnCategory.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnCategory.setBounds(44, 256, 191, 31);
				panel_3.add(rdbtnCategory);
				rdbtnCategory.setActionCommand("category");

				JRadioButton rdbtnThreshold = new JRadioButton("Threshold");
				rdbtnThreshold.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnThreshold.setBounds(44, 295, 191, 31);
				panel_3.add(rdbtnThreshold);
				rdbtnThreshold.setActionCommand("threshold");

				JRadioButton rdbtnNoOfCopies = new JRadioButton("No of copies");
				rdbtnNoOfCopies.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbtnNoOfCopies.setBounds(44, 335, 191, 31);
				panel_3.add(rdbtnNoOfCopies);
				rdbtnNoOfCopies.setActionCommand("no_of_copies");

				JRadioButton rdbauthors = new JRadioButton("author");
				rdbauthors.setFont(new Font("Calibri", Font.PLAIN, 15));
				rdbauthors.setBounds(44, 375, 191, 31);
				panel_3.add(rdbauthors);
				rdbauthors.setActionCommand("authors");

				ButtonGroup group = new ButtonGroup();
				group.add(rdbtnNewRadioButton);
				group.add(rdbtnNoOfCopies);
				group.add(rdbtnThreshold);
				group.add(rdbtnCategory);
				group.add(rdbtnPrice);
				group.add(rdbtnPublishingYear);
				group.add(rdbtnPublisherName);
				group.add(rdbtnTitle);
				group.add(rdbauthors);

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

				textField_author = new JTextField();
				textField_author.setPreferredSize(new Dimension(6, 23));
				textField_author.setColumns(10);
				textField_author.setBounds(255, 375, 178, 31);
				panel_3.add(textField_author);

				JButton btnConfirm_1 = new JButton("Search");
				btnConfirm_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String value = null, attribute = group.getSelection()
								.getActionCommand();
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
						case "authors":
							value = textField_author.getText();
							break;
						default:
							System.out.println(
									"Unexpected Error in radio buttons!");
							JOptionPane.showMessageDialog(new JFrame(),
									"Unexpected Error in radio buttons!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
						}
						IAdmin user = new Operations();
						String[][] result = user.searchForBooks(attribute,
								value);

						Table t = new Table(bookHeader, result);
					}
				});
				btnConfirm_1.setBounds(466, 343, 89, 23);
				panel_3.add(btnConfirm_1);
			}
		});
		button_1.setBounds(289, 111, 89, 23);
		panel_2.add(button_1);

		JLabel lblSearchForBook_1 = new JLabel("Search for book Advanced\r\n");
		lblSearchForBook_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblSearchForBook_1.setBounds(36, 144, 227, 23);
		panel_2.add(lblSearchForBook_1);

		JButton button_2 = new JButton("OK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblYouCanUse = new JLabel(
						"You can use and , or and brackets\r\n");
				lblYouCanUse.setFont(new Font("Calibri", Font.BOLD, 15));
				lblYouCanUse.setBounds(44, 51, 478, 31);
				panel_3.add(lblYouCanUse);

				JLabel lblForExample = new JLabel("For example :");
				lblForExample.setFont(new Font("Calibri", Font.BOLD, 15));
				lblForExample.setBounds(44, 86, 478, 31);
				panel_3.add(lblForExample);

				JLabel lblisbnAndTitlec = new JLabel(
						"(Isbn=2 and title=\"C Programming\") or Price<50");
				lblisbnAndTitlec.setFont(new Font("Calibri", Font.BOLD, 15));
				lblisbnAndTitlec.setBounds(44, 119, 478, 31);
				panel_3.add(lblisbnAndTitlec);

				JLabel lblCondition = new JLabel("Condition");
				lblCondition.setFont(new Font("Calibri", Font.BOLD, 15));
				lblCondition.setBounds(44, 217, 94, 31);
				panel_3.add(lblCondition);

				textField_13 = new JTextField();
				textField_13.setBounds(148, 218, 452, 31);
				panel_3.add(textField_13);
				textField_13.setColumns(10);

				JButton btnConfirm_2 = new JButton("Confirm");
				btnConfirm_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textField_13.getText() != "") {
							IAdmin u = new Operations();
							String[][] result = u.searchForBooksAdvanced(
									textField_13.getText());
							Table table = new Table(bookHeader, result);
						}
					}
				});
				btnConfirm_2.setBounds(469, 329, 89, 23);
				panel_3.add(btnConfirm_2);
			}
		});
		button_2.setBounds(289, 145, 89, 23);
		panel_2.add(button_2);

		JLabel lblAddNewBook = new JLabel("Add new book\r\n");
		lblAddNewBook.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblAddNewBook.setBounds(36, 178, 227, 23);
		panel_2.add(lblAddNewBook);

		JButton button_3 = new JButton("OK");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblGetUserInfo = new JLabel("Add new book");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblIsbn = new JLabel("ISBN");
				lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblIsbn.setBounds(44, 44, 191, 31);
				panel_3.add(lblIsbn);

				JLabel lblTitle = new JLabel("Title");
				lblTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblTitle.setBounds(44, 86, 191, 31);
				panel_3.add(lblTitle);

				JLabel lblPublisherName = new JLabel("Publisher name");
				lblPublisherName.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblPublisherName.setBounds(44, 131, 191, 31);
				panel_3.add(lblPublisherName);

				JLabel lblPublishingYear = new JLabel("Publishing year");
				lblPublishingYear.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblPublishingYear.setBounds(44, 175, 191, 31);
				panel_3.add(lblPublishingYear);

				JLabel lblPrice = new JLabel("Price");
				lblPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblPrice.setBounds(44, 216, 191, 31);
				panel_3.add(lblPrice);

				JLabel lblCategory = new JLabel("Category");
				lblCategory.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblCategory.setBounds(44, 256, 191, 31);
				panel_3.add(lblCategory);

				JLabel lblThreshold = new JLabel("Threshold");
				lblThreshold.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblThreshold.setBounds(44, 295, 191, 31);
				panel_3.add(lblThreshold);

				JLabel lblNoOfCopies = new JLabel("No of copies");
				lblNoOfCopies.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblNoOfCopies.setBounds(44, 335, 191, 31);
				panel_3.add(lblNoOfCopies);

				JLabel lblAuthors = new JLabel("Authors");
				lblAuthors.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblAuthors.setBounds(44, 375, 191, 31);
				panel_3.add(lblAuthors);

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

				textField_author = new JTextField();
				textField_author.setPreferredSize(new Dimension(6, 23));
				textField_author.setColumns(10);
				textField_author.setBounds(255, 375, 178, 31);
				panel_3.add(textField_author);

				JButton btnConfirm_1 = new JButton("Confirm");
				btnConfirm_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IAdmin a = new Operations();
						String[] authors = textField_author.getText().trim()
								.split(",");
						String[] info = { textField.getText(),
								textField_6.getText(), textField_7.getText(),
								textField_8.getText(), textField_9.getText(),
								textField_10.getText(), textField_11.getText(),
								textField_12.getText() };
						if (authors.length < 1 || authors[0].isEmpty()) {
							JOptionPane.showMessageDialog(new JFrame(),
									"You Must put at least 1 author name!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						for (String s : info) {
							if (s == null || s.isEmpty()) {
								JOptionPane.showMessageDialog(new JFrame(),
										"You must fill all fields!", "Dialog",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
						boolean success = a.addNewBook(info, authors);
						if (!success) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Error while adding book, may be isbn is already exists, "
											+ "or publisher is not in the database!",
									"Dialog", JOptionPane.ERROR_MESSAGE);
							return;
						}
						JOptionPane.showMessageDialog(new JFrame(),
								"Book is added successfully!", "Dialog",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
				btnConfirm_1.setBounds(466, 343, 89, 23);
				panel_3.add(btnConfirm_1);
			}
		});
		button_3.setBounds(289, 179, 89, 23);
		panel_2.add(button_3);

		JLabel lblEditBookInfo = new JLabel("Edit book info");
		lblEditBookInfo.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblEditBookInfo.setBounds(36, 212, 227, 23);
		panel_2.add(lblEditBookInfo);

		JButton button_4 = new JButton("OK");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Enter ISBN: ");
				label.setBounds(44, 216, 191, 31);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.PLAIN, 17));

				textField = new JTextField();
				textField.setPreferredSize(new Dimension(6, 23));
				textField.setBounds(255, 216, 178, 31);
				panel_3.add(textField);
				textField.setColumns(10);

				JButton button_edit = new JButton("edit");
				button_edit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						String isbn = textField.getText().trim();
						IAdmin user = new Operations();
						String[][] data;
						data = user.searchForBooks("isbn", isbn);
						if (data.length < 1) {
							JOptionPane.showMessageDialog(new JFrame(),
									"This book doesn't exist!", "Dialog",
									JOptionPane.ERROR_MESSAGE);
							return;
						}

						panel_3.removeAll();
						panel_3.repaint();

						JLabel label = new JLabel("Hi : " + Admin.email);
						label.setBounds(450, 363, 250, 23);
						panel_3.add(label);
						label.setFont(new Font("Calibri", Font.BOLD, 17));

						JLabel lblGetUserInfo = new JLabel("Edit book info");
						lblGetUserInfo
								.setFont(new Font("Calibri", Font.BOLD, 17));
						lblGetUserInfo.setBounds(20, 11, 182, 31);
						panel_3.add(lblGetUserInfo);

						JLabel lblIsbn = new JLabel("Isbn");
						lblIsbn.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblIsbn.setBounds(44, 44, 191, 31);
						panel_3.add(lblIsbn);

						JLabel lblTitle = new JLabel("Title");
						lblTitle.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblTitle.setBounds(44, 86, 191, 31);
						panel_3.add(lblTitle);

						JLabel lblPublisherName = new JLabel("Publisher name");
						lblPublisherName
								.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblPublisherName.setBounds(44, 131, 191, 31);
						panel_3.add(lblPublisherName);

						JLabel lblPublishingYear = new JLabel(
								"Publishing year");
						lblPublishingYear
								.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblPublishingYear.setBounds(44, 175, 191, 31);
						panel_3.add(lblPublishingYear);

						JLabel lblPrice = new JLabel("Price");
						lblPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblPrice.setBounds(44, 216, 191, 31);
						panel_3.add(lblPrice);

						JLabel lblCategory = new JLabel("Category");
						lblCategory
								.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblCategory.setBounds(44, 256, 191, 31);
						panel_3.add(lblCategory);

						JLabel lblThreshold = new JLabel("Threshold");
						lblThreshold
								.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblThreshold.setBounds(44, 295, 191, 31);
						panel_3.add(lblThreshold);

						JLabel lblNoOfCopies = new JLabel("No of copies");
						lblNoOfCopies
								.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblNoOfCopies.setBounds(44, 335, 191, 31);
						panel_3.add(lblNoOfCopies);

						JLabel lblAuthors = new JLabel("Authors");
						lblAuthors.setFont(new Font("Calibri", Font.PLAIN, 15));
						lblAuthors.setBounds(44, 375, 191, 31);
						panel_3.add(lblAuthors);

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

						textField_author = new JTextField();
						textField_author.setPreferredSize(new Dimension(6, 23));
						textField_author.setColumns(10);
						textField_author.setBounds(255, 375, 178, 31);
						panel_3.add(textField_author);

						String authors = data[0][8];
						textField_author.setText(authors);

						JButton btnConfirm_1 = new JButton("Confirm");
						btnConfirm_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								IAdmin a = new Operations();
								ArrayList<String> data = new ArrayList<>();
								ArrayList<String> att = new ArrayList<>();
								int i = 0;
								if (!textField.getText().trim().isEmpty()) {
									data.add(textField.getText());
									att.add("isbn");
									i++;
								}
								if (!textField_6.getText().trim().isEmpty()) {
									data.add(textField_6.getText());
									att.add("title");
									i++;
								}
								if (!textField_7.getText().trim().isEmpty()) {
									data.add(textField_7.getText());
									att.add("publisher_name");
									i++;
								}
								if (!textField_8.getText().trim().isEmpty()) {
									data.add(textField_8.getText());
									att.add("publishingYear");
									i++;
								}
								if (!textField_9.getText().trim().isEmpty()) {
									data.add(textField_9.getText());
									att.add("price");
									i++;
								}
								if (!textField_10.getText().trim().isEmpty()) {
									data.add(textField_10.getText());
									att.add("category");
									i++;
								}
								if (!textField_11.getText().trim().isEmpty()) {
									data.add(textField_11.getText());
									att.add("threshold");
									i++;
								}
								if (!textField_12.getText().trim().isEmpty()) {
									data.add(textField_12.getText());
									att.add("no_of_copies");
									i++;
								}

								String temp = textField_author.getText().trim();
								String[] authorsArr = temp.split(",");
								if (temp.isEmpty() || authorsArr.length < 1) {
									JOptionPane.showMessageDialog(new JFrame(),
											"You Must leave at least 1 author for book!",
											"Dialog",
											JOptionPane.ERROR_MESSAGE);
									return;
								}

								String[] dataArr = data
										.toArray(new String[data.size()]);
								String[] attArr = att
										.toArray(new String[att.size()]);
								IAdmin u = new Operations();
								if (authorsArr[0].isEmpty())
									authorsArr[0] = null;
								boolean success = u.editBookInfo(attArr,
										dataArr, isbn, authorsArr);

								if (!success) {
									JOptionPane.showMessageDialog(new JFrame(),
											"Failed on editing the user info",
											"Dialog",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								JOptionPane.showMessageDialog(new JFrame(),
										"Book Info edited successfully!",
										"Dialog",
										JOptionPane.INFORMATION_MESSAGE);
							}
						});
						btnConfirm_1.setBounds(466, 343, 89, 23);
						panel_3.add(btnConfirm_1);

					}
				});
				button_edit.setBounds(289, 179, 89, 23);
				panel_3.add(button_edit);

			}
		});
		button_4.setBounds(289, 213, 89, 23);
		panel_2.add(button_4);

		JLabel lblOrderBook = new JLabel("Order book");
		lblOrderBook.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblOrderBook.setBounds(36, 246, 227, 23);
		panel_2.add(lblOrderBook);

		JButton button_5 = new JButton("OK");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblGetUserInfo = new JLabel("Order book");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
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

				JLabel lblNoOfCopies_1 = new JLabel("No of copies");
				lblNoOfCopies_1.setFont(new Font("Calibri", Font.PLAIN, 15));
				lblNoOfCopies_1.setBounds(44, 173, 191, 31);
				panel_3.add(lblNoOfCopies_1);

				textField_14 = new JTextField();
				textField_14.setPreferredSize(new Dimension(6, 23));
				textField_14.setColumns(10);
				textField_14.setBounds(255, 173, 178, 31);
				panel_3.add(textField_14);

				JButton btnConfirm_3 = new JButton("Confirm");
				btnConfirm_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						IAdmin a = new Operations();
						boolean success = a.orderBook(textField.getText(),
								textField_14.getText());
						if (!success)
							JOptionPane.showMessageDialog(new JFrame(),
									"Failed on ordering book", "Dialog",
									JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
			}
		});
		button_5.setBounds(289, 247, 89, 23);
		panel_2.add(button_5);

		JLabel lblConfirmOrder = new JLabel("Confirm Order");
		lblConfirmOrder.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblConfirmOrder.setBounds(36, 280, 227, 23);
		panel_2.add(lblConfirmOrder);

		JButton button_6 = new JButton("OK");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblGetUserInfo = new JLabel("Confirm order");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 182, 31);
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
						IAdmin a = new Operations();
						boolean success = a.confirmOrder(textField.getText());
						if (!success)
							JOptionPane.showMessageDialog(new JFrame(),
									"Failed on Confirming order ", "Dialog",
									JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
			}
		});
		button_6.setBounds(289, 281, 89, 23);
		panel_2.add(button_6);

		JLabel lblPromoteCustomer = new JLabel("Promote Customer");
		lblPromoteCustomer.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPromoteCustomer.setBounds(36, 314, 227, 23);
		panel_2.add(lblPromoteCustomer);

		JButton button_7 = new JButton("OK");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.removeAll();
				panel_3.repaint();

				JLabel label = new JLabel("Hi : " + Admin.email);
				label.setBounds(450, 363, 250, 23);
				panel_3.add(label);
				label.setFont(new Font("Calibri", Font.BOLD, 17));

				JLabel lblGetUserInfo = new JLabel("promote Customer");
				lblGetUserInfo.setFont(new Font("Calibri", Font.BOLD, 17));
				lblGetUserInfo.setBounds(20, 11, 240, 31);
				panel_3.add(lblGetUserInfo);

				JLabel lblIsbn = new JLabel("Customer Email");
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
						IAdmin a = new Operations();
						boolean success = a
								.promoteCustomer(textField.getText());
						if (!success)
							JOptionPane.showMessageDialog(new JFrame(),
									"Customer Email isn`t correct !!! ",
									"Dialog", JOptionPane.ERROR_MESSAGE);
					}
				});
				btnConfirm_3.setBounds(440, 329, 89, 23);
				panel_3.add(btnConfirm_3);
			}
		});
		button_7.setBounds(289, 315, 89, 23);
		panel_2.add(button_7);

		JLabel lblTotalSalesIn = new JLabel("Total sales in previous month");
		lblTotalSalesIn.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTotalSalesIn.setBounds(413, 42, 257, 23);
		panel_2.add(lblTotalSalesIn);

		JButton button_9 = new JButton("OK");
		button_9.setBounds(661, 43, 89, 23);
		panel_2.add(button_9);
		button_9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Connection con = null;
				try {
					if (con == null)
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/book_store?useSSL=false",
								"root", "admin");
				} catch (Exception ex) {
					// Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
				}

				String myreport = "Month_Sales_report.jrxml";

				try {
					JasperReport jasper = JasperCompileManager
							.compileReport(myreport);
					JasperPrint jasperPrint = JasperFillManager
							.fillReport(jasper, null, con);
					JasperViewer jv = new JasperViewer(jasperPrint, false);
					jv.viewReport(jasperPrint, false);

				} catch (JRException exc) {
					Logger.getLogger(Admin.class.getName()).log(Level.SEVERE,
							null, exc);

				}
			}
		});

		JLabel lblTopFiveCustomers = new JLabel("Top five customers");
		lblTopFiveCustomers.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTopFiveCustomers.setBounds(413, 76, 257, 23);
		panel_2.add(lblTopFiveCustomers);

		JButton button_10 = new JButton("OK");
		button_10.setBounds(661, 77, 89, 23);
		panel_2.add(button_10);
		button_10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = null;
				try {
					if (con == null)
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/book_store?useSSL=false",
								"root", "admin");
				} catch (Exception ex) {
					// Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
				}

				String myreport = "Top Customers.jrxml";

				try {
					JasperReport jasper = JasperCompileManager
							.compileReport(myreport);
					JasperPrint jasperPrint = JasperFillManager
							.fillReport(jasper, null, con);
					JasperViewer jv = new JasperViewer(jasperPrint, false);
					jv.viewReport(jasperPrint, false);

				} catch (JRException exc) {
					Logger.getLogger(Admin.class.getName()).log(Level.SEVERE,
							null, exc);

				}
			}
		});

		JLabel lblTopTenSold = new JLabel("Top ten sold books");
		lblTopTenSold.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTopTenSold.setBounds(413, 115, 257, 23);
		panel_2.add(lblTopTenSold);

		JButton button_11 = new JButton("OK");
		button_11.setBounds(661, 111, 89, 23);
		panel_2.add(button_11);
		button_11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Connection con = null;
				try {
					if (con == null)
						con = DriverManager.getConnection(
								"jdbc:mysql://localhost:3306/book_store?useSSL=false",
								"root", "admin");
				} catch (Exception ex) {
					// Logger.getLogger(main.class.getName()).log(Level.SEVERE,null,ex);
				}

				String myreport = "Top Selling Books.jrxml";

				try {
					JasperReport jasper = JasperCompileManager
							.compileReport(myreport);
					JasperPrint jasperPrint = JasperFillManager
							.fillReport(jasper, null, con);
					JasperViewer jv = new JasperViewer(jasperPrint, false);
					jv.viewReport(jasperPrint, false);
				} catch (JRException exc) {
					Logger.getLogger(Admin.class.getName()).log(Level.SEVERE,
							null, exc);

				}
			}
		});

		JButton btnLogOut = new JButton("Log Out\r\n");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				WelcomeWindow s = new WelcomeWindow();
				s.setVisible(true);
			}
		});
		btnLogOut.setBounds(475, 352, 89, 23);
		panel_2.add(btnLogOut);

		JButton button_8 = new JButton("Shopping Cart");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ShoppingCartView s = new ShoppingCartView(Admin.email, true);
				s.setVisible(true);
			}
		});
		button_8.setBounds(357, 352, 108, 23);
		panel_2.add(button_8);

		JLabel label = new JLabel("Hi : " + Admin.email);
		label.setBounds(450, 363, 250, 23);
		panel_3.add(label);
		label.setFont(new Font("Calibri", Font.BOLD, 17));
	}
}