package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfo {

	private JFrame frmFeature;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo window = new StudentInfo();
					window.frmFeature.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeature = new JFrame();
		frmFeature.setTitle("Feature 2");
		frmFeature.setBounds(100, 100, 450, 300);
		frmFeature.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeature.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(194, 31, 167, 37);
		frmFeature.getContentPane().add(textField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(70, 31, 126, 37);
		frmFeature.getContentPane().add(lblName);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourse.setBounds(70, 79, 126, 37);
		frmFeature.getContentPane().add(lblCourse);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSection.setBounds(70, 125, 126, 37);
		frmFeature.getContentPane().add(lblSection);
		String[] selectcourse = {"Computer Engineering", "Computer Science", "Civil Engineering"};
		
		JComboBox<String> courses = new JComboBox<String>();
		courses.setModel(new DefaultComboBoxModel<>(selectcourse));
		courses.setSelectedIndex(-1);
		courses.setBounds(194, 79, 167, 37);
		frmFeature.getContentPane().add(courses);
		
		JComboBox<String> sections = new JComboBox<String>();
		sections.setBounds(194, 125, 167, 37);
		frmFeature.getContentPane().add(sections);
		courses.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) {

	            int selection = courses.getSelectedIndex();
	            switch (selection) {
	                case 0:
	            		sections.setModel(new DefaultComboBoxModel<String>(new String[] {"1-1", "2-1","2-2"}));
	            		sections.setSelectedIndex(-1);
	                    break;
	                case 1:
	            		sections.setModel(new DefaultComboBoxModel<String>(new String[] {"1-1", "1-2","1-3"}));
	            		sections.setSelectedIndex(-1);
	                    break;
	                case 2:
	            		sections.setModel(new DefaultComboBoxModel<String>(new String[] {"2-1", "2-2","2-3"}));
	            		sections.setSelectedIndex(-1);
	                    break;
	                default:
	                    break;
	            }
	        }
	    });
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String course = (String) courses.getSelectedItem();
				String section = (String) sections.getSelectedItem();
				
				if(name.isEmpty() || course == null || section == null) {
					JOptionPane.showMessageDialog(null, 
							"Fields connot be left blank", 
							"Notice", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, 
							"   Name: "+name+"\n"+
							" Course: "+course+"\n"+
							"Section: "+section, 
							"Success", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(125, 194, 157, 37);
		frmFeature.getContentPane().add(btnSubmit);
	}
}
