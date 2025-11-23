package util;

public class BookingManager {

    private static int seats = 10;  // example

    public synchronized static boolean bookSeat() {
        if (seats > 0) {
            seats--;
            System.out.println("Seat booked! Remaining: " + seats);
            return true;
        } else {
            System.out.println("No seats available!");
            return false;
        }
    }
}