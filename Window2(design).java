package Lab03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class Window2 extends JFrame {

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
					Window2 frame = new Window2();
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
	public Window2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Civil Engineering", "Computer Engineering ", "Computer Science"}));
		comboBox.setForeground(new Color(192, 192, 192));
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setForeground(new Color(192, 192, 192));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1-1", "1-2", "2-1"}));
		comboBox_1.setBounds(166, 161, 219, 33);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(192, 192, 192));
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(166, 67, 219, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtFillUpThe = new JTextField();
		txtFillUpThe.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFillUpThe.setEditable(false);
		txtFillUpThe.setForeground(new Color(192, 192, 192));
		txtFillUpThe.setBackground(new Color(178, 34, 34));
		txtFillUpThe.setHorizontalAlignment(SwingConstants.CENTER);
		txtFillUpThe.setText("STUDENT INFORMATION");
		txtFillUpThe.setBounds(-11, 0, 463, 43);
		contentPane.add(txtFillUpThe);
		txtFillUpThe.setColumns(10);
	}
}
