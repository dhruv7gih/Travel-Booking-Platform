package ui;

import dao.ListingDAO;

import javax.swing.*;
import java.awt.*;

public class DeleteListingPanel extends JPanel {

    public DeleteListingPanel() {
        setLayout(new FlowLayout());

        JTextField idField = new JTextField(10);
        JButton deleteBtn = new JButton("Delete Listing");

        add(new JLabel("Enter Listing ID to Delete:"));
        add(idField);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                ListingDAO dao = new ListingDAO();

                boolean success = dao.deleteListing(id);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Listing Deleted Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Listing Not Found!");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
    }
}