package model;

public abstract class User {
    protected int userId;
    protected String username;
    protected String fullName;
    protected String email;

    public User(int userId, String username, String fullName, String email) {
        this.userId = userId;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }

    public abstract String getRole();

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email;}
}