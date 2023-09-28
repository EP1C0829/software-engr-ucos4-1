package lab03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInfo{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel courseLabel = new JLabel("Course:");
        String[] courses = {"Computer Science", "Computer Engineering"};
        JComboBox<String> courseDropdown = new JComboBox<>(courses);

        JLabel sectionLabel = new JLabel("Section:");
        String[] sectionsCS = {"UCOS 1-1", "UCOS 2-1", "UCOS 3-1", "UCOS 4-1"};
        String[] sectionsCE = {"TCPE 1-1", "TCPE 2-1", "TCPE 3-1", "TCPE 4-1"};
        JComboBox<String> sectionDropdown = new JComboBox<>(sectionsCS);

        courseDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseDropdown.getSelectedItem();
                if (selectedCourse.equals("Computer Engineering")) {
                    sectionDropdown.setModel(new DefaultComboBoxModel<>(sectionsCE));
                } else {
                    sectionDropdown.setModel(new DefaultComboBoxModel<>(sectionsCS));
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(courseLabel);
        panel.add(courseDropdown);
        panel.add(sectionLabel);
        panel.add(sectionDropdown);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String course = (String) courseDropdown.getSelectedItem();
                String section = (String) sectionDropdown.getSelectedItem();

                if (name.isEmpty() || course == null || section == null) {
                    JOptionPane.showMessageDialog(frame, "Fill up all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Form submitted!\nName: " + name + "\nCourse: " + course + "\nSection: " + section);
                }
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(submitButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}