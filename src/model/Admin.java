package model;

public class Admin extends User {

    public Admin(int userId, String username, String fullName, String email) {
        super(userId, username, fullName, email);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}