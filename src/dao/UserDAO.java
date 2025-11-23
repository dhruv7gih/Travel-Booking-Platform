package dao;

import model.Admin;
import model.Customer;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public User login(String username, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE username=? AND password_hash=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password); // if later you add hashing, change here

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("user_id");
                String full = rs.getString("full_name");
                String email = rs.getString("email");
                String role = rs.getString("role");

                if (role.equals("ADMIN"))
                    return new Admin(id, username, full, email);
                else
                    return new Customer(id, username, full, email);
            }
        }
        return null;
    }
}