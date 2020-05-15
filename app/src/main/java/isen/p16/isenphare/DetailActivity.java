package isen.p16.isenphare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import isen.p16.isenphare.ui.dummy.PhareContent;

public class DetailActivity extends AppCompatActivity {

    private final static String TAG = "AppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent it = getIntent();
        String id = it.getStringExtra(MainActivity.ID);
        ImageView img= (ImageView) findViewById(R.id.MainImage);

        Log.d(TAG,"Id="+id);

        setContentView(R.layout.activity_detail);

        PhareContent.PhareItem phare = PhareContent.ITEMS.get(Integer.valueOf(id)-1);

        ((TextView)findViewById(R.id.titleDetail)).setText("Nom : " + phare.name);
        ((TextView)findViewById(R.id.regionDetail)).setText("Région : " + phare.region);
        ((TextView)findViewById(R.id.dateDetail)).setText("Date : " + phare.date);
        ((TextView)findViewById(R.id.porteeDetail)).setText("Portée : " + String.valueOf(phare.portee));
        ((TextView)findViewById(R.id.hauteurDetail)).setText("Hauteur : "+ String.valueOf(phare.hauteur)+" m");

        ((ImageView)findViewById(R.id.MainImage)).setImageResource(MainActivity.getContext().getResources().getIdentifier(phare.filename,"drawable",MainActivity.getContext().getPackageName()));






    }
}
