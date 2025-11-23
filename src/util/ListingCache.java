package util;

import model.TravelListing;
import java.util.*;

public class ListingCache {

    // Map<Integer, TravelListing> → Generic Map use
    private static Map<Integer, TravelListing> listingMap =
            new HashMap<>();

    // List<TravelListing> → Generic List use
    private static List<TravelListing> listingList =
            new ArrayList<>();

    // Set<String> → Unique locations store karne ke liye
    private static Set<String> uniqueLocations =
            new HashSet<>();


    public static void addListing(TravelListing t) {
        listingMap.put(t.getListingId(), t);
        listingList.add(t);
        uniqueLocations.add(t.getLocation());
    }

    public static TravelListing getListingById(int id) {
        return listingMap.get(id);
    }

    public static List<TravelListing> getAllListings() {
        return listingList;
    }

    public static Set<String> getUniqueLocations() {
        return uniqueLocations;
    }
}