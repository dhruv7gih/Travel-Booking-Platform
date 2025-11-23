package model;

public class TravelListing {
    protected int listingId;
    protected String type;      // FLIGHT / HOTEL / CAR
    protected String title;
    protected String location;
    protected double price;
    protected int availability;

    public TravelListing(int listingId, String type, String title, String location, double price, int availability) {
        this.listingId = listingId;
        this.type = type;
        this.title = title;
        this.location = location;
        this.price = price;
        this.availability = availability;
    }

    public int getListingId() { return listingId; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public double getPrice() { return price; }
    public int getAvailability() { return availability;}
}