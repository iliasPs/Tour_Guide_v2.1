package com.example.vga.tour_guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class sight_detailed_info_activity extends AppCompatActivity implements OnMapReadyCallback {

    int position;
    TextView sightTitle;
    ImageView sightImage;
    TextView sightDesc;
    ArrayList<Sight> sightsList = new ArrayList<>();
    MapView mapView;
    GoogleMap map;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sightsList = getIntent().getParcelableArrayListExtra("sights");
        position = getIntent().getIntExtra("sightToDisplay", 0);
        setContentView(R.layout.activity_sight_detailed_info_activity);
        sightTitle= findViewById(R.id.sightTitle);
        sightImage =findViewById(R.id.sightImage);
        sightDesc=findViewById(R.id.sightDesc);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        setData();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMyLocationButtonEnabled(false);
       /*
       //in old Api Needs to call MapsInitializer before doing any CameraUpdateFactory call
        try {
            MapsInitializer.initialize(this.getActivity());
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
       */

        // Updates the location and zoom of the MapView
        /*CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
        map.animateCamera(cameraUpdate);*/
        LatLng sightLatLng = new LatLng(Double.parseDouble(getString(sightsList.get(position).getmSightLat())),Double.parseDouble(getString(sightsList.get(position).getmSightLat())));
        map.moveCamera(CameraUpdateFactory.newLatLng(sightLatLng));

    }

    public void setData(){

        sightTitle.setText(sightsList.get(position).getSightTitle());
        sightImage.setImageResource(sightsList.get(position).getSightImage());
        sightDesc.setText(sightsList.get(position).getSightDesc());


    }
}
