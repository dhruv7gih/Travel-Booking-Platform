package dao;

import model.TravelListing;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {

    // INSERT LISTING
    public boolean addListing(TravelListing t) throws SQLException {
        String sql = "INSERT INTO listings(type, title, location, price, availability) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getType());
            ps.setString(2, t.getTitle());
            ps.setString(3, t.getLocation());
            ps.setDouble(4, t.getPrice());
            ps.setInt(5, t.getAvailability());

            return ps.executeUpdate() > 0;
        }
    }

    // FETCH ALL LISTINGS
    public List<model.TravelListing> getAllListings() throws SQLException {
        List<model.TravelListing> list = new ArrayList<>();

        String sql = "SELECT * FROM listings";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new model.TravelListing(
                        rs.getInt("listing_id"),
                        rs.getString("type"),
                        rs.getString("title"),
                        rs.getString("location"),
                        rs.getDouble("price"),
                        rs.getInt("availability")
                ));
            }
        }
        return list;
    }
    // DELETE LISTING
    public boolean deleteListing(int id) throws SQLException {
        String sql = "DELETE FROM listings WHERE listing_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}