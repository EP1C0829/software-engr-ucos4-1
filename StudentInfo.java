package Lab03;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtFillUpThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfo frame = new StudentInfo();
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
	public StudentInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Civil Engineering", "Computer Engineering", "Computer Science"}));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(166, 114, 219, 33);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(123, 219, 166, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Course:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 114, 86, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 71, 86, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSection.setBounds(55, 161, 86, 33);
		contentPane.add(lblSection);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(166, 67, 219, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel txtFillUpThe = new JLabel("STUDENT INFORMATION");
		txtFillUpThe.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFillUpThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtFillUpThe.setBounds(-11, 0, 463, 43);
		txtFillUpThe.setOpaque(true);
		txtFillUpThe.setBackground(new Color(178, 34, 34));
		txtFillUpThe.setForeground(Color.WHITE);
		contentPane.add(txtFillUpThe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = comboBox_1.getSelectedItem().toString();
                    if ("".equals(selectedValue)) {
                    	JOptionPane.showMessageDialog(null, "Please fill up all the fields!");
                    } else {
                    	
                    }
				}
			}
		});
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(166, 158, 219, 33);
		contentPane.add(comboBox_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
                String course = comboBox.getSelectedItem().toString();
                String section = comboBox_1.getSelectedItem().toString();
                StudentTable studentTable = new StudentTable();
                studentTable.addStudent(name, course, section);
                studentTable.setVisible(true);
                dispose();
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = comboBox.getSelectedItem().toString();
                    if ("Civil Engineering".equals(selectedValue)) {
                        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"", "1-1", "2-2", "2-1"}));
                    } else if("Computer Engineering".equals(selectedValue)) {
                        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"","1-1", "1-2", "1-3"}));
                    }else if("Computer Science".equals(selectedValue)) {
                        comboBox_1.setModel(new DefaultComboBoxModel<>(new String[]{"","2-1", "2-2", "2-3"}));
                    }
                }
			}
		});
	}
	
}
