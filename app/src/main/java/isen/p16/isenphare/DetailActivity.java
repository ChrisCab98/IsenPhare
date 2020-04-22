package isen.p16.isenphare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import isen.p16.isenphare.ui.dummy.PhareContent;

public class DetailActivity extends AppCompatActivity {

    private final static String TAG = "AppCompatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent it = getIntent();
        String id = it.getStringExtra(MainActivity.ID);

        Log.d(TAG,"Id="+id);

        setContentView(R.layout.activity_detail);

        PhareContent.PhareItem phare = PhareContent.ITEMS.get(Integer.valueOf(id)-1);

        //TextView title_view = (TextView) findViewById(R.id.titleDetail);

        ((TextView)findViewById(R.id.titleDetail)).setText(phare.name);
        ((TextView)findViewById(R.id.regionDetail)).setText(phare.region);
        ((TextView)findViewById(R.id.dateDetail)).setText(phare.date);


    }
}
