package ui;

import dao.BookingDAO;

import javax.swing.*;
import java.awt.*;

public class BookingWindow extends JFrame {

    public BookingWindow(int userId, int listingId, String type) {
        setTitle("Booking Window");
        setSize(400, 300);

        setLayout(new GridLayout(5, 2, 10, 10));

        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JTextField amountField = new JTextField();

        JButton bookBtn = new JButton("Confirm Booking");

        add(new JLabel("Start Date (YYYY-MM-DD):"));
        add(startField);

        add(new JLabel("End Date (YYYY-MM-DD):"));
        add(endField);

        add(new JLabel("Amount:"));
        add(amountField);

        add(bookBtn);

        bookBtn.addActionListener(e -> {
            try {
                BookingDAO dao = new BookingDAO();

                dao.createBooking(
                        userId,
                        listingId,
                        type,
                        startField.getText(),
                        endField.getText(),
                        Double.parseDouble(amountField.getText())
                );

                JOptionPane.showMessageDialog(this, "Booking Successful!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Booking Failed: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}