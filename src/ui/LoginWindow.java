package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {

    public LoginWindow() {
        setTitle("Travel Booking Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("Travel Booking Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        add(title);
        add(new JLabel("Username:", SwingConstants.CENTER));
        add(usernameField);
        add(new JLabel("Password:", SwingConstants.CENTER));
        add(passwordField);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            try {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                UserDAO dao = new UserDAO();
                User user = dao.login(username, password);

                if (user == null) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid username/password!",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(this,
                        "Login Successful as " + user.getRole());

                dispose();  // close login window

                // NAVIGATE TO ADMIN OR CUSTOMER DASHBOARD
                if (user.getRole().equals("ADMIN")) {
                    new AdminDashboard();
                } else {
                    new CustomerDashboard(user.getUserId());
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}