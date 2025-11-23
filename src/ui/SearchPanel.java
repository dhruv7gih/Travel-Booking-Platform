package ui;

import dao.ListingDAO;
import model.TravelListing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SearchPanel extends JPanel {

    private int userId;

    public SearchPanel(int userId) {
        this.userId = userId;

        setLayout(new BorderLayout());

        // TOP FILTERS
        JPanel top = new JPanel(new FlowLayout());

        String[] types = {"FLIGHT", "HOTEL", "CAR"};
        JComboBox<String> typeBox = new JComboBox<>(types);

        JTextField locationField = new JTextField(12);
        JButton searchBtn = new JButton("Search");

        top.add(new JLabel("Type:"));
        top.add(typeBox);
        top.add(new JLabel("Location:"));
        top.add(locationField);
        top.add(searchBtn);

        // TABLE
        String[] cols = {"ID", "Type", "Title", "Location", "Price", "Availability"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        // BOOK BUTTON
        JButton bookBtn = new JButton("Book Selected");

        // SEARCH ACTION
        searchBtn.addActionListener(e -> {
            try {
                String type = typeBox.getSelectedItem().toString();
                String location = locationField.getText();

                ListingDAO dao = new ListingDAO();
                List<TravelListing> list = dao.getAllListings();

                model.setRowCount(0);

                for (TravelListing t : list) {
                    model.addRow(new Object[]{
                            t.getListingId(),
                            t.getType(),
                            t.getTitle(),
                            t.getLocation(),
                            t.getPrice(),
                            t.getAvailability()
                    });
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // BOOK ACTION
        bookBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a listing first.");
                return;
            }

            int listingId = (int) model.getValueAt(row, 0);
            String type = (String) model.getValueAt(row, 1);

            new BookingWindow(userId, listingId, type);
        });

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bookBtn, BorderLayout.SOUTH);
    }
}