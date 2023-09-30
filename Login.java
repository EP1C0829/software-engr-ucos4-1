package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Login extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame frame =new JFrame ("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(new Rectangle(101, 156, 208, 46));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = textField_1.getText();
				 String password = textField_2.getText();
				 
				 int error =1;

	             
				 if (!name.equals("admin") || !password.equals("12345")) {

					 JOptionPane.showMessageDialog(frame, "Incorrect field inputs!!", "Error", JOptionPane.ERROR_MESSAGE);
	                    error++;
	                    
	                    if(error == 3) {
	                    	JOptionPane.showMessageDialog(frame, "3 attempts failed!! Exiting...", "Error", JOptionPane.ERROR_MESSAGE);
	                    	System.exit(0);
	                    }

	                }
	             if(name.equals("admin") && password.equals("12345")) {
	                	JOptionPane.showMessageDialog(frame, "Login successful", "Welcome", JOptionPane.INFORMATION_MESSAGE);
	                } 
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 31, 182, 30);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 89, 182, 30);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(54, 31, 100, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(54, 89, 100, 30);
		getContentPane().add(lblPassword);

	}
}
