package ui;

import dao.BookingDAO;
import model.TravelListing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.DBConnection;

public class MyBookingsPanel extends JPanel {

    public MyBookingsPanel(int userId) {
        setLayout(new BorderLayout());

        String[] cols = {"Booking ID", "Listing ID", "Type", "Start Date", "End Date", "Amount"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        try {
            String sql = "SELECT * FROM bookings WHERE user_id=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("booking_id"),
                        rs.getInt("listing_id"),
                        rs.getString("booking_type"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getDouble("total_amount")
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}