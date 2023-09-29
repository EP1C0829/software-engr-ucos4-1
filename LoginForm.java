import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LoginForm extends JFrame implements ActionListener {
   private JPanel loginPanel;
   private JLabel userLabel, passwordLabel, message;
   private JTextField userNameText;
   private JPasswordField passwordText;
   private JButton submit, cancel;
   private int loginAttempts;

   private JPanel formPanel;
   private JLabel nameLabel, courseLabel, sectionLabel;
   private JTextField nameText;
   private JComboBox<String> courseComboBox, sectionComboBox;
   private JButton addButton;

   private JPanel tablePanel;
   private JTable dataTable;
   private DefaultTableModel tableModel;

   public LoginForm() {
      // Login Panel
      loginPanel = new JPanel(new GridLayout(3, 2));

      userLabel = new JLabel();
      userLabel.setText("User Name :");
      userNameText = new JTextField();

      passwordLabel = new JLabel();
      passwordLabel.setText("Password :");
      passwordText = new JPasswordField();

      submit = new JButton("SUBMIT");
      cancel = new JButton("CANCEL");

      message = new JLabel();

      loginPanel.add(userLabel);
      loginPanel.add(userNameText);
      loginPanel.add(passwordLabel);
      loginPanel.add(passwordText);
      loginPanel.add(message);
      loginPanel.add(submit);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      submit.addActionListener(this);
      add(loginPanel, BorderLayout.CENTER);
      setTitle("Please Login Here !");
      setSize(450, 350);
      setVisible(true);

      // Form Panel
      formPanel = new JPanel(new GridLayout(4, 2));

      nameLabel = new JLabel();
      nameLabel.setText("Name:");
      nameText = new JTextField();

      courseLabel = new JLabel();
      courseLabel.setText("Course:");
      courseComboBox = new JComboBox<>(new String[]{"Computer Engineering", "Computer Science", "Civil Engineering"});

      sectionLabel = new JLabel();
      sectionLabel.setText("Section:");
      sectionComboBox = new JComboBox<>(new String[]{"1-1", "2-2", "2-1"});
      sectionComboBox = new JComboBox<>(new String[]{"1-1", "1-2", "1-3"});
      sectionComboBox = new JComboBox<>(new String[]{"2-1", "2-2", "2-3"});
      addButton = new JButton("Add");

      formPanel.add(nameLabel);
      formPanel.add(nameText);
      formPanel.add(courseLabel);
      formPanel.add(courseComboBox);
      formPanel.add(sectionLabel);
      formPanel.add(sectionComboBox);
      formPanel.add(addButton);

      addButton.addActionListener(this);

      
      tablePanel = new JPanel(new BorderLayout());
      tableModel = new DefaultTableModel(new Object[]{"Name", "Course", "Section"}, 0);
      dataTable = new JTable(tableModel);
      tablePanel.add(new JScrollPane(dataTable), BorderLayout.CENTER);

     
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add(loginPanel, BorderLayout.CENTER);
      setTitle("Please Login Here !");
      setSize(450, 350);
      setVisible(true);
   }

   public static void main(String[] args) {
      new LoginForm();
   }

   
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == submit) {
         String userName = userNameText.getText();
         String password = new String(passwordText.getPassword());

         if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            message.setText("Hello " + userName + "");
            loginAttempts = 0;
            remove(loginPanel);
            add(formPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
         } else {
            loginAttempts++;
            message.setText("Invalid user.. (" + loginAttempts + " attempts)");
            if (loginAttempts >= 3) {
               JOptionPane.showMessageDialog(this, "Too many login attempts. Application will be terminated.",
                     "Login Failed", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
            }
         }
      } else if (ae.getSource() == addButton) {
         String name = nameText.getText();
         String course = (String) courseComboBox.getSelectedItem();
         String section = (String) sectionComboBox.getSelectedItem();

         if (name.isEmpty() || course.isEmpty() || section.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill up all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
         } else {
            tableModel.addRow(new Object[]{name, course, section});
            nameText.setText("");
            courseComboBox.setSelectedIndex(0);
            sectionComboBox.setSelectedIndex(0);
         }
      }
   }
}