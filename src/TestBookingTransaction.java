import dao.BookingDAO;

public class TestBookingTransaction {
    public static void main(String[] args) {

        BookingDAO dao = new BookingDAO();

        try {
            dao.createBooking(
                    1,              // user id
                    1,              // listing id
                    "FLIGHT",       // type
                    "2025-02-10",   // start date
                    "2025-02-20",   // end date
                    5000.00         // amount
            );
        } catch (Exception e) {
            System.out.println("Booking Failed: " + e.getMessage());
        }
    }
}