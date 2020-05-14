package isen.p16.isenphare.ui.dummy;

import org.json.JSONObject;

import android.util.Log;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import static android.content.ContentValues.TAG;

import isen.p16.isenphare.MainActivity;
import isen.p16.isenphare.R;

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

    private static final int COUNT = 15;
    private static final String TAG = "PhareContent";

    public static void createContent() {


        try {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(MainActivity.getContext().getAssets().open("phares_all.json")));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }

            String str = new String(sb.toString());
            JSONObject jObjConnection = new JSONObject(str);
            JSONObject jsonBix = jObjConnection.getJSONObject("phares");
            JSONArray jsonA = jsonBix.getJSONArray("liste");

            for (int i = 0; i < jsonA.length(); i++) {
                JSONObject obj = (JSONObject) jsonA.get(i);
                String id = obj.getString("id");
                String nom = obj.getString("name");
                String region = obj.getString("region");
                String construction = obj.getString("construction");
                String filename = obj.getString("filename");
                String auteur;
                try {
                    auteur = obj.getString("auteur");
                } catch (JSONException e) {
                    Log.d(TAG, "auteur issue");
                    auteur = "Unknown";
                }
                int hauteur;
                try {
                    hauteur = obj.getInt("hauteur");

                } catch (JSONException e) {
                    Log.d(TAG, "auteur issue");
                    hauteur = 30;
                }
                int eclat;
                try {
                    eclat = obj.getInt("eclat");

                } catch (JSONException e) {
                    Log.d(TAG, "auteur issue");
                    eclat = 30;
                }
                int periode;
                try {
                    periode = obj.getInt("periode");

                } catch (JSONException e) {
                    Log.d(TAG, "auteur issue");
                    periode = 30;

                }
                int porte;
                try {
                    porte = obj.getInt("portee");

                } catch (JSONException e) {
                    Log.d(TAG, "porte issue");
                    porte = 30;

                }
                int automatisation;
                try {
                    automatisation = obj.getInt("automatisation");

                } catch (JSONException e) {
                    Log.d(TAG, "automatisation issue");
                    automatisation = 30;

                }
                double lat;
                try {
                    lat = obj.getDouble("lat");

                } catch (JSONException e) {
                    Log.d(TAG, "lat issue");
                    lat = 30;

                }
                double lon;
                try {
                    lon = obj.getDouble("lon");

                } catch (JSONException e) {
                    Log.d(TAG, "lon issue");
                    lon = 30;

                }

                addItem(new PhareItem(id, nom, region, construction, Integer.parseInt(construction), filename, auteur,
                        hauteur, eclat, periode, porte, automatisation, lat, lon));
            }

        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "first try");

        }
    }

    private static void addItem(PhareItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

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
        public final int construction;
        public final String filename;
        public final String auteur;
        public final int hauteur;
        public final int eclat;
        public final int periode;
        public final int portee;
        public final int automatisation;
        public final double lat;
        public final double lon;
        public final LatLng position;
        //public final MarkerOptions Mop;

        public PhareItem(String id, String content, String details, String date, int construction, String filename,
                         String auteur, int hauteur, int eclat, int periode, int portee, int automatisation, double lat,
                         double lon) {
            this.id = id;
            this.name = content;
            this.region = details;
            this.date = date;
            this.construction = construction;
            this.filename = filename;
            this.auteur = auteur;
            this.hauteur = hauteur;
            this.eclat = eclat;
            this.periode = periode;
            this.portee = portee;
            this.automatisation = automatisation;
            this.lat = lat;
            this.lon = lon;
            this.position = new LatLng(lat,lon);
            //this.Mop = new MarkerOptions().position(position).title(name).snippet("date de construction").icon(BitmapDescriptorFactory.fromResource(R.drawable.lighthouse));

        }

        @Override
        public String toString() {
            return name;
        }
    }
}