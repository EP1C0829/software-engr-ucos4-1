package lab03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login1 extends JFrame {
    private String username = "admin";
    private String password = "password";
    private int maxAttempts = 3;
    private int attempts = 0;
    private boolean locked = false;

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login1() {
        setTitle("Login Window");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = usernameField.getText();
                String inputPassword = new String(passwordField.getPassword());
                login(inputUsername, inputPassword);
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
    }

    public void login(String inputUsername, String inputPassword) {
        if (locked) {
            JOptionPane.showMessageDialog(this, "Login system is locked. Please contact support.");
            return;
        }

        if (attempts < maxAttempts) {
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                attempts = 0;
            } else {
                attempts++;
                if (attempts == maxAttempts) {
                    JOptionPane.showMessageDialog(this, "Too many incorrect attempts. Login system is now locked.");
                    locked = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect username or password. Attempts left: " + (maxAttempts - attempts));
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Login system is locked. Please contact support.");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Login loginWindow = new Login();
            loginWindow.setVisible(true);
        });
    }
}