package ui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Left Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setBackground(new Color(40, 40, 40));
        sidebar.setPreferredSize(new Dimension(200, 600));

        JButton addBtn = new JButton("Add Listing");
        JButton viewBtn = new JButton("View Listings");
        JButton deleteBtn = new JButton("Delete Listing");
        JButton logoutBtn = new JButton("Logout");

        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(deleteBtn);
        sidebar.add(logoutBtn);

        // Main Panel (CardLayout)
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add all screens
        mainPanel.add(new AddListingPanel(), "ADD");
        mainPanel.add(new ViewListingsPanel(), "VIEW");
        mainPanel.add(new DeleteListingPanel(), "DELETE");

        // Add Action Listeners
        addBtn.addActionListener(e -> cardLayout.show(mainPanel, "ADD"));
        viewBtn.addActionListener(e -> cardLayout.show(mainPanel, "VIEW"));
        deleteBtn.addActionListener(e -> cardLayout.show(mainPanel, "DELETE"));
        logoutBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logged Out!");
            dispose();
        });

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}