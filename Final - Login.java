package lab03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private int loginAttempts = 0;
	private JTextField txtLoginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLoginPage = new JTextField();
		txtLoginPage.setBounds(0, 0, 424, 52);
		txtLoginPage.setForeground(new Color(204, 204, 204));
		txtLoginPage.setBackground(new Color(178, 34, 34));
		txtLoginPage.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginPage.setText("LOGIN PAGE");
		contentPane.add(txtLoginPage);
		txtLoginPage.setColumns(10);

		JLabel LbUsername = new JLabel("Username:");
		LbUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LbUsername.setBounds(52, 85, 115, 37);
		contentPane.add(LbUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(52, 137, 115, 37);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("");
				} else {
					txtUsername.selectAll();
				}
			}
		});

		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setBounds(166, 85, 186, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(166, 137, 186, 37);
		contentPane.add(txtPassword);

		btnLogin = new JButton("LOGIN");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (loginAttempts < 3) {
					if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin123")) {
						openStudentInfo();
						dispose();
					} else if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
						loginAttempts++;
						if (loginAttempts == 3) { // Check if it's the third attempt
							showErrorMessage("Maximum login attempts reached. Exiting.");
							// Force exit after 3 wrong attempts
							System.exit(0);
						} else {
							showErrorMessage("Please Fill up the Text Fields!");
						}
					} else {
						loginAttempts++;
						if (loginAttempts == 3) { // Check if it's the third attempt
							showErrorMessage("Maximum login attempts reached. Exiting.");
							// Force exit after 3 wrong attempts
							System.exit(0);
						} else {
							showErrorMessage("Incorrect Username or Password!");
						}
					}
				} else {
					btnLogin.setEnabled(false);
					showErrorMessage("Maximum login attempts reached. Exiting.");
					// Force exit after 3 wrong attempts
					System.exit(0);
				}
			}
		});

		btnLogin.setForeground(new Color(192, 192, 192));
		btnLogin.setBackground(new Color(178, 34, 34));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(141, 202, 131, 37);
		contentPane.add(btnLogin);
	}

	private void openStudentInfo() {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setLocationRelativeTo(this);
		studentInfo.setVisible(true);
	}

	private void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}