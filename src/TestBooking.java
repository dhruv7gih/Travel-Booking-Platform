import util.BookingManager;

public class TestBooking {
    public static void main(String[] args) {

        // 🔥 Thread 1 seat book karega
        Thread t1 = new Thread(() -> BookingManager.bookSeat());

        // 🔥 Thread 2 seat book karega
        Thread t2 = new Thread(() -> BookingManager.bookSeat());

        t1.start();
        t2.start();
    }
}