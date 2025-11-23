package dao;

import exceptions.InsufficientSeatsException;
import model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {

    public void createBooking(int userId, int listingId, String type,
                              String startDate, String endDate, double amount)
            throws Exception {

        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);  // 🚀 TRANSACTION START

            // STEP 1 → Check availability
            String sql1 = "SELECT availability FROM listings WHERE listing_id=? FOR UPDATE";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, listingId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                throw new Exception("Listing not found");
            }

            int availability = rs.getInt("availability");

            if (availability <= 0) {
                throw new InsufficientSeatsException("No seats/rooms/cars available!");
            }

            // STEP 2 → Decrease availability
            String sql2 = "UPDATE listings SET availability = availability - 1 WHERE listing_id=?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, listingId);
            ps2.executeUpdate();

            // STEP 3 → Insert booking
            String sql3 = "INSERT INTO bookings(user_id, listing_id, booking_type, start_date, end_date, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, userId);
            ps3.setInt(2, listingId);
            ps3.setString(3, type);
            ps3.setString(4, startDate);
            ps3.setString(5, endDate);
            ps3.setDouble(6, amount);
            ps3.executeUpdate();

            // EVERYTHING SUCCESS → COMMIT
            con.commit();
            System.out.println("Booking Successful!!!");

        } catch (Exception e) {

            if (con != null) {
                con.rollback();  // ❌ ERROR → ROLLBACK
            }
            throw e;

        } finally {
            if (con != null) {
                con.setAutoCommit(true);  // Auto-commit back to normal
                con.close();
            }
        }
    }
}