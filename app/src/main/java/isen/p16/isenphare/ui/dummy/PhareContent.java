package isen.p16.isenphare.ui.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PhareContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PhareItem> ITEMS = new ArrayList<PhareItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PhareItem> ITEM_MAP = new HashMap<String, PhareItem>();

    private static final int COUNT = 25;
/*
    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }*/

    /*Creation de tous les phares*/
    public static void createContent () {
        addItem(new PhareItem("1","Le Planier","Sud","1789"));
        addItem(new PhareItem("2","La Jumment","Bretagne","1890"));
        addItem(new PhareItem("3","Ar Men","Bretagne","1998"));
    }
    
    
    private static void addItem(PhareItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
/*
    private static PhareItem createDummyItem(int position) {
        return new PhareItem(String.valueOf(position), "Item " + position, makeDetails(position),String.valueOf(position));
    }
   */

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PhareItem {
        public final String id;
        public final String name;
        public final String region;
        public final String date;

        public PhareItem(String id, String name, String region, String date) {
            this.id = id;
            this.name = name;
            this.region = region;
            this.date = date;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
