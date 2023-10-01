package Lab01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtAbc;
	private JTextField txtLoginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(189, 78, 183, 37);
		txtUser.setForeground(new Color(192, 192, 192));
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtAbc = new JTextField();
		txtAbc.setBounds(189, 134, 183, 37);
		txtAbc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAbc.setForeground(new Color(192, 192, 192));
		txtAbc.setHorizontalAlignment(SwingConstants.LEFT);
		txtAbc.setColumns(10);
		panel.add(txtAbc);
		
		JButton LOGIN = new JButton("LOGIN");
		LOGIN.setBounds(131, 192, 131, 37);
		LOGIN.setForeground(new Color(192, 192, 192));
		LOGIN.setBackground(new Color(178, 34, 34));
		LOGIN.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(LOGIN);
		
		txtLoginPage = new JTextField();
		txtLoginPage.setBounds(0, 0, 424, 52);
		txtLoginPage.setForeground(new Color(204, 204, 204));
		txtLoginPage.setBackground(new Color(178, 34, 34));
		txtLoginPage.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginPage.setText("LOGIN PAGE");
		panel.add(txtLoginPage);
		txtLoginPage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 77, 117, 37);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(55, 133, 117, 37);
		panel.add(lblPassword);
	}
}
