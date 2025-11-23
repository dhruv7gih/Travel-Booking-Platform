package model;

public class HotelListing extends TravelListing {

    private int stars;

    public HotelListing(int listingId, String title, String location, double price, int availability, int stars) {
        super(listingId, "HOTEL", title, location, price, availability);
        this.stars = stars;
    }

    public int getStars() { return stars;}
}