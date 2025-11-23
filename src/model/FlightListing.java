package model;

public class FlightListing extends TravelListing {

    private String airline;

    public FlightListing(int listingId, String title, String location, double price, int availability, String airline) {
        super(listingId, "FLIGHT", title, location, price, availability);
        this.airline = airline;
    }

    public String getAirline() { return airline;}
}