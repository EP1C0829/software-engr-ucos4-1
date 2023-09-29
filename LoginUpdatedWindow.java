package lab03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUpdatedWindow {
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	private static int loginAttempts = 0;
	private String username = "admin";
	private String password = "password";

	private JFrame loginWindow;
	private JFrame inputWindow;
	private JFrame tableWindow;

	private JTextField usernameField;
	private JPasswordField passwordField;

	private JTextField nameField;
	private JComboBox<String> courseComboBox;
	private JComboBox<String> sectionComboBox;

	private DefaultTableModel tableModel;

	public LoginUpdatedWindow() {
		createLoginWindow();
	}

	private void createLoginWindow() {
		loginWindow = new JFrame();
		loginWindow.setTitle("LOGIN PAGE");
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setSize(300, 213);
		loginWindow.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Password.setBounds(65, 59, 78, 20);
		usernameField = new JTextField(20);
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(65, 32, 165, 25);
		passwordField = new JPasswordField(20);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(64, 79, 166, 26);
		panel.setLayout(null);

		panel.add(Password);
		panel.add(usernameField);
		panel.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(0, 0, 0));
		loginButton.setBounds(65, 116, 165, 41);
		loginButton.addActionListener(new LoginButtonListener());

		panel.add(loginButton);

		loginWindow.getContentPane().add(panel);

		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Username.setBounds(65, 11, 78, 20);
		panel.add(Username);
		loginWindow.setVisible(true);
	}

	private void createInputWindow() {
		inputWindow = new JFrame();
		inputWindow.setTitle("Input Window");
		inputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputWindow.setSize(300, 213);
		inputWindow.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(4, 2));

		JLabel nameLabel = new JLabel("Name:");
		JLabel courseLabel = new JLabel("Course:");
		JLabel sectionLabel = new JLabel("Section:");

		nameField = new JTextField(20);
		courseComboBox = new JComboBox<>();
		courseComboBox.setModel(new DefaultComboBoxModel(new String[] {"Available Courses", "Computer Engineering", "Computer Science", "Civil Engineering"}));
		sectionComboBox = new JComboBox<>();
		courseComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = courseComboBox.getSelectedItem().toString();
		        
		        if (selectedItem.equals("Computer Engineering")) {
		        	sectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "1-1", "2-2", "2-1" }));
		        } else 
		        if (selectedItem.equals("Computer Science")) {
		        	sectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "1-1", "1-2", "1-3" }));
		        } else 
		        if (selectedItem.equals("Civil Engineering")) {
		        	sectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "2-1", "2-2", "2-3" }));
		        } else 
		        if (selectedItem.equals("Available Courses")) {
		 	      sectionComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Available Sections", "1-1", "1-2", "1-3", "2-1", "2-2", "2-3"}));
		        }
			}
		});

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(courseLabel);
		panel.add(courseComboBox);
		panel.add(sectionLabel);
		panel.add(sectionComboBox);

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonListener());

		panel.add(submitButton);

		inputWindow.getContentPane().add(panel);
		inputWindow.setVisible(true);
	}

	private class LoginButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String enteredUsername = usernameField.getText();
			String enteredPassword = new String(passwordField.getPassword());

			if (validateCredentials(enteredUsername, enteredPassword)) {
				loginWindow.dispose();
				createInputWindow();
			} else {
				loginAttempts++;
				if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
					JOptionPane.showMessageDialog(loginWindow, "Maximum login attempts exceeded. Exiting application.");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(loginWindow, "Invalid username or password. Please try again.");
				}
			}
		}

		private boolean validateCredentials(String enteredUsername, String enteredPassword) {
			return enteredUsername.equals(username) && enteredPassword.equals(password);
		}
	}

	private void createTableWindow() {
		tableWindow = new JFrame();
		tableWindow.setTitle("Table Window");
		tableWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableWindow.setSize(400, 300);
		tableWindow.setLocationRelativeTo(null);

		// Create a table with default table model
		JTable table = new JTable();
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		table.setDefaultEditor(Object.class, null);

		// Add table columns
		tableModel.addColumn("Name");
		tableModel.addColumn("Course");
		tableModel.addColumn("Section");

		// Get the data from the input fields
		String name = nameField.getText();
		String course = courseComboBox.getSelectedItem().toString();
		String section = sectionComboBox.getSelectedItem().toString();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		// Add the data to the table model
		tableModel.addRow(new Object[] { name, course, section });

		// Create a scroll pane for the table
		JScrollPane scrollPane = new JScrollPane(table);

		tableWindow.getContentPane().add(scrollPane);
		tableWindow.setVisible(true);
	}

	private class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String course = (String) courseComboBox.getSelectedItem();
			String section = (String) sectionComboBox.getSelectedItem();

			if (name.isEmpty() || course.isEmpty() || section.isEmpty()) {
				JOptionPane.showMessageDialog(inputWindow, "Fill up all the fields", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				nameField.setText("");
				courseComboBox.setSelectedIndex(0);
				sectionComboBox.setSelectedIndex(0);

				inputWindow.dispose(); // Close the input window
				createTableWindow(); // Open the table window
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Login();
			}
		});
	}
}