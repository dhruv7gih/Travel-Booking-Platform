package ui;

import dao.ListingDAO;
import model.TravelListing;

import javax.swing.*;
import java.util.List;

public class BackgroundSearchWorker extends SwingWorker<List<TravelListing>, Void> {

    private String type;
    private String location;

    public BackgroundSearchWorker(String type, String location) {
        this.type = type;
        this.location = location;
    }

    @Override
    protected List<TravelListing> doInBackground() throws Exception {
        // Background thread me chalega (GUI freeze nahi hoga)
        ListingDAO dao = new ListingDAO();
        return dao.getAllListings();
    }

    @Override
    protected void done() {
        try {
            List<TravelListing> list = get();
            System.out.println("Search Completed! Total Results: " + list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}