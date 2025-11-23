package model;

public class CarListing extends TravelListing {

    private String company;

    public CarListing(int listingId, String title, String location, double price, int availability, String company) {
        super(listingId, "CAR", title, location, price, availability);
        this.company = company;
    }

    public String getCompany() { return company;}
}