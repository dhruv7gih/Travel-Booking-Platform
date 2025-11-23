package ui;

import dao.ListingDAO;
import model.TravelListing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewListingsPanel extends JPanel {

    public ViewListingsPanel() {

        setLayout(new BorderLayout());

        String[] columns = {"ID", "Type", "Title", "Location", "Price", "Availability"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        try {
            ListingDAO dao = new ListingDAO();
            List<TravelListing> list = dao.getAllListings();

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

        } catch (Exception e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}