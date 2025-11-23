package ui;

import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public CustomerDashboard(int userId) {   // userId so customer bookings track ho sake
        setTitle("Customer Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // LEFT MENU
        JPanel menu = new JPanel(new GridLayout(5, 1, 10, 10));
        menu.setBackground(new Color(40, 40, 40));
        menu.setPreferredSize(new Dimension(200, 600));

        JButton searchBtn = new JButton("Search");
        JButton myBookingsBtn = new JButton("My Bookings");
        JButton logoutBtn = new JButton("Logout");

        menu.add(searchBtn);
        menu.add(myBookingsBtn);
        menu.add(logoutBtn);

        // MAIN PANEL (CardLayout)
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new SearchPanel(userId), "SEARCH");
        mainPanel.add(new MyBookingsPanel(userId), "MYBOOKINGS");

        // BUTTON ACTIONS
        searchBtn.addActionListener(e -> cardLayout.show(mainPanel, "SEARCH"));
        myBookingsBtn.addActionListener(e -> cardLayout.show(mainPanel, "MYBOOKINGS"));
        logoutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logged Out!");
            dispose();
        });

        add(menu, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}