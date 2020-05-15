package isen.p16.isenphare.ui.gallery;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import isen.p16.isenphare.R;
import isen.p16.isenphare.ui.dummy.PhareContent;



public class GalleryFragment extends Fragment implements OnMapReadyCallback  {
    private GalleryViewModel galleryViewModel;
    private static final String TAG = "PhareContent";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.activity_maps, container, false);
        return root;
    }
    private final static LatLng GARDANNE = new LatLng(43.455669,5.47064899999998);

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportMapFragment supportMapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        supportMapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(GARDANNE), 2000, null);
        //googleMap.addMarker(new MarkerOptions().position(GARDANNE));
        CircleOptions circleOption;



        for (PhareContent.PhareItem a : PhareContent.ITEMS)
        {
            String couleur = a.couleur;

            if (couleur.equals("blanc"))
            {
                googleMap.addMarker(new MarkerOptions().position(a.position).title(a.name) .snippet("Région : " + a.region).alpha(0.8f).icon(BitmapDescriptorFactory.fromResource(R.drawable.buildings2)));
                circleOption = new CircleOptions().center(a.position).fillColor(Color.parseColor("#59FAFAFA")).radius(a.portee*1858).strokeWidth(1);
                googleMap.addCircle(circleOption);
            }

            else if (couleur.equals("rouge"))
            {
                googleMap.addMarker(new MarkerOptions().position(a.position) .title(a.name) .snippet("Région : " + a.region).alpha(0.8f).icon(BitmapDescriptorFactory.fromResource(R.drawable.buildings2)));
                circleOption = new CircleOptions().center(a.position).fillColor(Color.parseColor("#59F44336")).radius(a.portee*1858).strokeWidth(1);
                googleMap.addCircle(circleOption);
            }

            else if (couleur.equals("vert"))
            {
                googleMap.addMarker(new MarkerOptions().position(a.position) .title(a.name) .snippet("Région : " + a.region).alpha(0.8f).icon(BitmapDescriptorFactory.fromResource(R.drawable.buildings2)));
                circleOption = new CircleOptions().center(a.position).fillColor(Color.parseColor("#594CAF50")).radius(a.portee*1858).strokeWidth(1);
                googleMap.addCircle(circleOption);
            }


            //googleMap.addMarker(new MarkerOptions().position(a.position) .title(a.name) .snippet("Région : " + a.region) .alpha(0.7f) .icon(BitmapDescriptorFactory.fromResource(R.drawable.buildings2)));
            //circleOption = new CircleOptions().center(a.position).fillColor(Color.parseColor("#440000DD")).radius(a.portee*1858).strokeWidth(0);
            //googleMap.addCircle(circleOption);
        }

        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        else
            googleMap.setMyLocationEnabled(true);
    }

}