package model;

public class Customer extends User {

    public Customer(int userId, String username, String fullName, String email) {
        super(userId, username, fullName, email);
    }

    @Override
    public String getRole() {
        return "CUSTOMER";
    }
}