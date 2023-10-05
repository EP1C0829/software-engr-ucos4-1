package lab03;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StudentInfo {
	private JFrame inputWindow;

	private JTextField nameField;
	private JComboBox<String> courseComboBox;
	private JComboBox<String> sectionComboBox;
	private JTextField txtStudentInfo;

	public StudentInfo() {
		createInputWindow();
	}

	private void createInputWindow() {
		inputWindow = new JFrame();
		inputWindow.setTitle("Input Window");
		inputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputWindow.setBounds(100, 100, 450, 320);
		inputWindow.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(50, 72, 115, 37);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setBounds(50, 124, 115, 37);
		courseLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel sectionLabel = new JLabel("Section:");
		sectionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sectionLabel.setBounds(50, 176, 115, 37);

		nameField = new JTextField(20);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameField.setBounds(164, 72, 186, 37);

		courseComboBox = new JComboBox<>(
				new String[] { "", "Civil Engineering", "Computer Engineering", "Computer Science" });
		courseComboBox.setBounds(164, 120, 186, 41);
		sectionComboBox = new JComboBox<>(new String[] { "", "1-1", "2-2", "2-1" });
		sectionComboBox.setBounds(164, 172, 186, 37);
		panel.setLayout(null);

		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(courseLabel);
		panel.add(courseComboBox);
		panel.add(sectionLabel);
		panel.add(sectionComboBox);

		courseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedValue = courseComboBox.getSelectedItem().toString();
					if ("Civil Engineering".equals(selectedValue)) {
						sectionComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "", "1-1", "2-2", "2-1" }));
					} else if ("Computer Engineering".equals(selectedValue)) {
						sectionComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "", "1-1", "1-2", "1-3" }));
					} else if ("Computer Science".equals(selectedValue)) {
						sectionComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "", "2-1", "2-2", "2-3" }));
					}
				}
			}
		});

		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new SubmitButtonListener());
		submitButton.setForeground(new Color(192, 192, 192));
		submitButton.setBackground(new Color(178, 34, 34));
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		submitButton.setBounds(140, 228, 131, 37);

		panel.add(submitButton);

		txtStudentInfo = new JTextField();
		txtStudentInfo.setBounds(0, 0, 424, 52);
		txtStudentInfo.setForeground(new Color(204, 204, 204));
		txtStudentInfo.setBackground(new Color(178, 34, 34));
		txtStudentInfo.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtStudentInfo.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentInfo.setText("STUDENT INFO");
		panel.add(txtStudentInfo);

		inputWindow.getContentPane().add(panel);
		inputWindow.setVisible(true);
	}

	private void createTableWindow(String name, String course, String section) {
		JFrame tableWindow = new JFrame();
		tableWindow.setTitle("Table Window");
		tableWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tableWindow.setBounds(100, 100, 450, 320);
		tableWindow.setLocationRelativeTo(null);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		JTextField txtStudentTable = new JTextField();
		txtStudentTable.setBounds(10, 11, 414, 52);
		txtStudentTable.setForeground(new Color(204, 204, 204));
		txtStudentTable.setBackground(new Color(178, 34, 34));
		txtStudentTable.setFont(new Font("Tahoma", Font.BOLD, 21));
		txtStudentTable.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentTable.setText("STUDENT TABLE");
		contentPane.add(txtStudentTable);

		JTable table = new JTable();
		DefaultTableModel tableModel = new DefaultTableModel();
		table.setModel(tableModel);

		tableModel.addColumn("Name");
		tableModel.addColumn("Course");
		tableModel.addColumn("Section");

		tableModel.addRow(new Object[] { name, course, section });

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 74, 414, 277);

		contentPane.add(scrollPane);
		tableWindow.setContentPane(contentPane);
		tableWindow.setVisible(true);
	}

	private class SubmitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String course = courseComboBox.getSelectedItem().toString();
			String section = sectionComboBox.getSelectedItem().toString();

			if (!name.isEmpty() && !course.isEmpty() && !section.isEmpty()) {
				createTableWindow(name, course, section);
				inputWindow.dispose();
			} else {
				JOptionPane.showMessageDialog(inputWindow, "Please fill in all fields.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StudentInfo();
			}
		});
	}

	public void setLocationRelativeTo(Login login) {
		// TODO Auto-generated method stub

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}