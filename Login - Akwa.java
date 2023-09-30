package Login;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	
	String username = "admin";
	String password = "password";
	int attempts = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(68, 57, 126, 37);
		frmLogin.getContentPane().add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String inputUsername = textField.getText();
				String inputPassword = String.valueOf(passwordField.getPassword());
				
				if(inputUsername.equals(username) && inputPassword.equals(password)) {
					JOptionPane.showMessageDialog(null, "Welcome...", "Login successful", JOptionPane.INFORMATION_MESSAGE);
					frmLogin.dispose();
				}
				else if(!inputUsername.equals(username) && !inputPassword.equals(password) && attempts == 3) {
					JOptionPane.showMessageDialog(null, "Max attempts of "+attempts+" reached!! Terminating...  ", "Locked", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				else {
					JOptionPane.showMessageDialog(null, "Denied! Try again \nAttempts: "+attempts+"/3", "Error", JOptionPane.ERROR_MESSAGE);
					attempts++;
				}
			}
		});
		btnNewButton.setBounds(138, 188, 157, 37);
		frmLogin.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(194, 57, 167, 37);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(68, 112, 126, 37);
		frmLogin.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(194, 105, 167, 35);
		frmLogin.getContentPane().add(passwordField);
	}
}
