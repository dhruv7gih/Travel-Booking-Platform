package ui;

import model.TravelListing;
import java.util.List;

public class SearchResults {

    private List<TravelListing> results;

    public SearchResults(List<TravelListing> results) {
        this.results = results;
    }

    public void display() {
        for (TravelListing t : results) {
            System.out.println(t.getTitle() + " - " + t.getLocation());
        }
    }
}