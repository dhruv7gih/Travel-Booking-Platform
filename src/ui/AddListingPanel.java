package ui;

import dao.ListingDAO;
import model.TravelListing;

import javax.swing.*;
import java.awt.*;

public class AddListingPanel extends JPanel {

    public AddListingPanel() {
        setLayout(new GridLayout(6, 2));

        JTextField typeField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField locField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField availField = new JTextField();

        JButton addBtn = new JButton("Add Listing");

        add(new JLabel("Type (FLIGHT/HOTEL/CAR):"));
        add(typeField);

        add(new JLabel("Title:"));
        add(titleField);

        add(new JLabel("Location:"));
        add(locField);

        add(new JLabel("Price:"));
        add(priceField);

        add(new JLabel("Availability:"));
        add(availField);

        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                ListingDAO dao = new ListingDAO();

                TravelListing t = new TravelListing(
                        0,
                        typeField.getText(),
                        titleField.getText(),
                        locField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(availField.getText())
                );

                boolean saved = dao.addListing(t);

                if (saved) {
                    JOptionPane.showMessageDialog(this, "Listing Added Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Add Listing");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}