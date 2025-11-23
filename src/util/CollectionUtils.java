package util;

import java.util.List;

public class CollectionUtils {

    // Generic method for printing list
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }
}