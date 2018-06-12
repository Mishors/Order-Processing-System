package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dbManager.Authenticator;
import dbManager.IAuthenticator;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Point;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JButton;

public class WelcomeWindow extends JFrame {

	private JPanel contentPane;
	private JPasswordField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField phonesTextFiled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeWindow frame = new WelcomeWindow();
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
	public WelcomeWindow() {
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
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setPreferredSize(new Dimension(1400, 150));
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel(null);
		panel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.setPreferredSize(new Dimension(700, 150));
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.WEST);

		JLabel label = new JLabel("Sign In\r\n");
		label.setLocation(new Point(20, 20));
		label.setBounds(new Rectangle(60, 25, 118, 50));
		label.setFont(new Font("Calibri", Font.PLAIN, 22));
		label.setBackground(Color.BLACK);
		panel_2.add(label);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setLocation(new Point(23, 86));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setSize(new Dimension(84, 30));
		lblEmail.setPreferredSize(new Dimension(50, 20));
		lblEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 15));
		panel_2.add(lblEmail);

		textField = new JPasswordField();
		textField.setBounds(44, 255, 206, 30);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setSize(new Dimension(84, 30));
		lblPassword.setPreferredSize(new Dimension(50, 20));
		lblPassword.setLocation(new Point(23, 86));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblPassword.setAlignmentX(0.5f);
		lblPassword.setBounds(44, 202, 84, 30);
		panel_2.add(lblPassword);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(44, 141, 206, 30);
		panel_2.add(textField_1);

		Panel panel_3 = new Panel(null);
		panel_3.setPreferredSize(new Dimension(700, 150));
		contentPane.add(panel_3, BorderLayout.CENTER);

		JButton btnNewButton_1 = new JButton("Log In\r\n");
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signIn(textField_1.getText(), textField.getText());
			}
		});
		btnNewButton_1.setBounds(340, 325, 155, 36);
		panel_2.add(btnNewButton_1);

		JLabel lblSignUp = new JLabel("Sign Up\r\n\r\n");
		lblSignUp.setLocation(new Point(20, 20));
		lblSignUp.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSignUp.setBounds(new Rectangle(60, 25, 118, 50));
		lblSignUp.setBackground(Color.BLACK);
		lblSignUp.setBounds(64, 21, 131, 50);
		panel_3.add(lblSignUp);

		JLabel label_1 = new JLabel("Email");
		label_1.setSize(new Dimension(84, 30));
		label_1.setPreferredSize(new Dimension(50, 20));
		label_1.setLocation(new Point(23, 86));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		label_1.setAlignmentX(0.5f);
		label_1.setBounds(74, 73, 84, 30);
		panel_3.add(label_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 111, 206, 30);
		panel_3.add(textField_2);

		JLabel lblUserName = new JLabel("User Name\r\n");
		lblUserName.setSize(new Dimension(84, 30));
		lblUserName.setPreferredSize(new Dimension(50, 20));
		lblUserName.setLocation(new Point(23, 86));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblUserName.setAlignmentX(0.5f);
		lblUserName.setBounds(94, 152, 100, 30);
		panel_3.add(lblUserName);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 194, 206, 30);
		panel_3.add(textField_3);

		JLabel lblUserPassword = new JLabel("User Password\r\n");
		lblUserPassword.setSize(new Dimension(84, 30));
		lblUserPassword.setPreferredSize(new Dimension(50, 20));
		lblUserPassword.setLocation(new Point(23, 86));
		lblUserPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblUserPassword.setAlignmentX(0.5f);
		lblUserPassword.setBounds(94, 235, 131, 30);
		panel_3.add(lblUserPassword);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(84, 276, 206, 30);
		panel_3.add(passwordField);

		JLabel lblFirstName = new JLabel("First Name\r\n");
		lblFirstName.setSize(new Dimension(84, 30));
		lblFirstName.setPreferredSize(new Dimension(50, 20));
		lblFirstName.setLocation(new Point(23, 86));
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblFirstName.setAlignmentX(0.5f);
		lblFirstName.setBounds(382, 73, 100, 30);
		panel_3.add(lblFirstName);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(374, 111, 206, 30);
		panel_3.add(textField_4);

		JLabel lblLastName = new JLabel("Last Name\r\n");
		lblLastName.setSize(new Dimension(84, 30));
		lblLastName.setPreferredSize(new Dimension(50, 20));
		lblLastName.setLocation(new Point(23, 86));
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblLastName.setAlignmentX(0.5f);
		lblLastName.setBounds(382, 152, 100, 30);
		panel_3.add(lblLastName);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(374, 194, 206, 30);
		panel_3.add(textField_5);

		JLabel lblShippingAddress = new JLabel("Shipping Address\r\n");
		lblShippingAddress.setSize(new Dimension(84, 30));
		lblShippingAddress.setPreferredSize(new Dimension(50, 20));
		lblShippingAddress.setLocation(new Point(23, 86));
		lblShippingAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblShippingAddress.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblShippingAddress.setAlignmentX(0.5f);
		lblShippingAddress.setBounds(382, 235, 155, 30);
		panel_3.add(lblShippingAddress);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(374, 276, 206, 30);
		panel_3.add(textField_6);

		JLabel phonesLabel = new JLabel("User Phones\r\n");
		phonesLabel.setSize(new Dimension(84, 30));
		phonesLabel.setPreferredSize(new Dimension(50, 20));
		phonesLabel.setLocation(new Point(23, 86));
		phonesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonesLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		phonesLabel.setAlignmentX(0.5f);
		phonesLabel.setBounds(94, 238 + 83, 100, 30);
		panel_3.add(phonesLabel);

		phonesTextFiled = new JTextField();
		phonesTextFiled.setColumns(10);
		phonesTextFiled.setBounds(84, 358, 206, 30);
		panel_3.add(phonesTextFiled);

		JButton btnNewButton = new JButton("SIgn Up\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] info = { textField_2.getText(), textField_3.getText(),
						passwordField.getText(), textField_4.getText(),
						textField_5.getText(), textField_6.getText() };
				String[] phones;
				String temp = phonesTextFiled.getText();
				temp = temp.trim();
				phones = temp.split(",");
				
				signUp(info, phones);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.setBounds(463, 325, 155, 36);
		panel_3.add(btnNewButton);

	}

	protected void signUp(String[] info, String[] phones) {

		if (phones[0].length() == 0) {
			System.out.println("Empty phone! Please enter at least 1 phone.");
			JOptionPane.showMessageDialog(new JFrame(),
					"Please enter at least 1 phone.", "Dialog",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		for (String string : info) {
			if (string.isEmpty()) {
				System.out.println("Empty field!");
				JOptionPane.showMessageDialog(new JFrame(),
						"You must fill all fields!", "Dialog",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		IAuthenticator Authenticator = new Authenticator();
		int success = Authenticator.addNewUser(info, phones);
		String email = info[0];
		if (success == 1) {
			System.out.println(email + " has been successfully signed up.");
			JOptionPane.showMessageDialog(new JFrame(),
					email + " has been successfully signed up.", "Dialog",
					JOptionPane.INFORMATION_MESSAGE);
			User u = new User(email);
			u.setVisible(true);
			setVisible(false);
		} else if (success == -1) {
			System.out.println("Failure in signing up user : " + email);
			JOptionPane.showMessageDialog(new JFrame(),
					email + "Error in signing up, email already exists! ",
					"Dialog", JOptionPane.ERROR_MESSAGE);
		} else if (success == -2) {
			System.out.println("Failure in signing up user : " + email);
			JOptionPane.showMessageDialog(new JFrame(), email
					+ "Error in signing up, Phone numbers must be digits only"
					+ " separated by ',' ! ", "Dialog",
					JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(
					"It shouldn't reach hear in code ! , program fatal error!!");
		}
	}

	protected void signIn(String email, String password) {
		IAuthenticator Authenticator = new Authenticator();
		int type = Authenticator.authenticate(email, password);
		if (type == 1) {
			System.out.println(
					email + " has been logged in successfully as admin!");
			Admin u = new Admin(email);
			u.setVisible(true);
			setVisible(false);
		} else if (type == 0) {
			System.out.println(
					email + " has been logged in successfully as user!");
			User u = new User(email);
			u.setVisible(true);
			setVisible(false);
		} else {
			String message;
			if (type == -1)
				message = "Invalid Email !";
			else if (type == -2)
				message = "Invalid Password!";
			else
				message = "Error while accessing database !";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
