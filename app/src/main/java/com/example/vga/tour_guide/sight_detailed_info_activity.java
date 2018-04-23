package com.example.vga.tour_guide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class sight_detailed_info_activity extends AppCompatActivity {

    int position;
    TextView sightTitle;
    ImageView sightImage;
    TextView sightDesc;
    ArrayList<Sight> sightsList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sightsList = getIntent().getParcelableArrayListExtra("sights");
        position = getIntent().getIntExtra("sightToDisplay", 0);
        setContentView(R.layout.activity_sight_detailed_info_activity);
        sightTitle= findViewById(R.id.sightTitle);
        sightImage =findViewById(R.id.sightImage);
        sightDesc=findViewById(R.id.sightDesc);
        setData();

    }

    public void setData(){

        sightTitle.setText(sightsList.get(position).getSightTitle());
        sightImage.setImageResource(sightsList.get(position).getSightImage());
        sightDesc.setText(sightsList.get(position).getSightDesc());


    }
}
