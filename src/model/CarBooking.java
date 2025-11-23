package model;

public class CarBooking implements Booking {

    private int bookingId;
    private int userId;
    private int listingId;

    public CarBooking(int bookingId, int userId, int listingId) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.listingId = listingId;
    }

    @Override
    public boolean confirm() {
        return true;
    }

    @Override
    public void cancel() {
        System.out.println("Car booking cancelled");
    }
}