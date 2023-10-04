 package Lab03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LbUsername = new JLabel("USERNAME:");
		LbUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LbUsername.setBounds(75, 50, 115, 37);
		contentPane.add(LbUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(75, 102, 115, 37);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("");
				}else {
					txtUsername.selectAll();
				}
			}
		});
		
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setBounds(200, 50, 152, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(200, 102, 152, 37);
		contentPane.add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(loginAttempts < 3) {
					if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin123")) {
						StudentInfo();
						dispose();
					}else if(txtUsername.getText().equals("") && txtPassword.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Fill up the Text Fields!");
					}else {
						JOptionPane.showMessageDialog(null, "Username & Password didn't match!");
						loginAttempts++;
					}
				}else {
					btnLogin.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Maximum login attempts reached. Exiting.");
                    // Force dispose after 3 wrong attempts
                    dispose();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(146, 181, 137, 44);
		contentPane.add(btnLogin);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	private void StudentInfo() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setLocationRelativeTo(this);
        studentInfo.setVisible(true);
    }
}
