# ✈ Travel Booking Platform
### Java Swing • JDBC • MySQL • OOP • Multithreading • Collections

A fully GUI-based *Travel Booking System* where *Admins* can manage travel listings  
(Flights/Hotels/Cars) and *Customers* can search, view, and book travel services.  
This project is developed using *Java Swing + JDBC + MySQL*, following clean OOP and MVC/DAO patterns.
This project includes *OOP, JDBC CRUD, Collections,Generics, Multithreading, Database Connectivity and Transaction 
Management* as per review requirements.

## 🌟 Features

### 👨‍💼 Admin Features
- Add new listings (Flights / Hotels / Cars)
- View all available listings
- Delete listings
- Manage system data through GUI
- View logs, update listings

### 👤 Customer Features
- Login with username & password
- Search listings by type & location
- View matching results in a table
- View available listings
- Book listings (with date & amount)
- User-friendly GUI dashboard

## 🏗 Project Structure
src/
├── dao/
│     ├── BookingDAO.java
│     ├── DBConnection.java
│     ├── GenericDAO.java
│     ├── ListingDAO.java
│     └── UserDAO.java
│
├── exceptions/
│     ├── BookingException.java
│     └── InsufficientSeatsException.java
│
├── model/
│     ├── User.java
│     ├── Admin.java
│     ├── Customer.java
│     ├── TravelListing.java
│     ├── CarListing.java
│     ├── FlightListing.java
│     ├── HotelListing.java
│     ├── Booking.java   (interface)
│     ├── CarBooking.java
│     ├── FlightBooking.java
│     └── HotelBooking.java
│
├── ui/
│     ├── LoginWindow.java
│     ├── AdminDashboard.java
│     ├── CustomerDashboard.java
│     ├── AddListingPanel.java
│     ├── ViewListingsPanel.java
│     ├── DeleteListingPanel.java
│     ├── SearchPanel.java
│     ├── MyBookingsPanel.java
│     ├── BookingWindow.java
│     └── BackgroundSearchWorker.java
│
├── util/
│     ├── BookingManager.java
│     ├── CollectionUtils.java
│     ├── ListingCache.java
│     ├── LogMonitor.java   (thread)
│     └── SearchResults.java
│
├── tests/
│     ├── DBTest.java
│     ├── TestBooking.java
│     ├── TestBookingTransaction.java
│     └── TestThread.java
│
├── Main.java
├── Main1.java
├── Main2.java
└──README.md 

## 🗄 Database Schema (MySQL)
### *Users Table*
```sql
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  full_name VARCHAR(100),
  email VARCHAR(100),
  role ENUM('ADMIN','CUSTOMER') NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

### *Listings Table*

CREATE TABLE listings (
  listing_id INT AUTO_INCREMENT PRIMARY KEY,
  type ENUM('FLIGHT','HOTEL','CAR') NOT NULL,
  title VARCHAR(150),
  location VARCHAR(100),
  price DECIMAL(10,2),
  availability INT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
### *Bookings Table*

CREATE TABLE bookings (
  booking_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  listing_id INT,
  booking_type VARCHAR(20),
  status ENUM('CONFIRMED','CANCELLED') DEFAULT 'CONFIRMED',
  start_date DATE,
  end_date DATE,
  total_amount DECIMAL(10,2),
  booked_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

🔑 Sample Users

Admin User
username: admin
password: admin123

Customer User
username: customer1
password: cust123

🔄 How to Run the Project

Step 1 — Install Requirements
Java JDK (17+)
MySQL
IntelliJ
Step 2 — Import Project
Open the project folder in your IDE.
Step 3 — Create Database
Run all SQL files (users, listings, bookings) in MySQL.
Step 4 — Update DBConnection.java
private static final String URL = "jdbc:mysql://localhost:3306/travel_app";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
Step 5 — Run Main.java
public class Main {
    public static void main(String[] args) {
        new LoginWindow();
    }
}
✔ Login window will open
✔ Use admin/customer login credentials
✔ Enjoy the full Travel Booking Platform

🎓 Technologies Used

Java Swing – GUI
MySQL – Database
JDBC – Database Connectivity
OOP Concepts – Inheritance, Polymorphism, Abstraction,Interface
Exception Handling
Collections Framework – List, Map, Set
Multithreading – SwingWorker, Thread
Transaction Management – Commit & Rollback
DAO Design Pattern
