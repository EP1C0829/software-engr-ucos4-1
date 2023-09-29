package lab03;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputWindow {

private JFrame inputWindow;
private JFrame tableWindow;
private JTextField nameField;
private JComboBox<String> courseComboBox;
private JComboBox<String> sectionComboBox;

private DefaultTableModel tableModel;

public InputWindow() {
	createInputWindow();
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InputWindow();
			}
		});
	}
}

