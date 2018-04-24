package com.example.vga.tour_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class LandmarksFragment extends Fragment {

    public LandmarksFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.drawable.acropolis, R.string.acropolis_title, R.string.acropolis_short_desc,R.string.cat_landmark, R.string.acropolis_desc, R.string.acropolis_lat, R.string.acropolis_long));
        sights.add(new Sight(R.drawable.soldier, R.string.soldier_title, R.string.soldier_short_desc,R.string.cat_landmark, R.string.soldier_desc, R.string.soldier_lat, R.string.soldier_long));
        sights.add(new Sight(R.drawable.stadium, R.string.stadium_title, R.string.stadium_short_desc,R.string.cat_landmark, R.string.stadium_desc, R.string.stadium_lat, R.string.stadium_long));
        sights.add(new Sight(R.drawable.plaka, R.string.plaka_title, R.string.plaka_short_desc,R.string.cat_landmark, R.string.plaka_desc, R.string.plaka_lat, R.string.plaka_long));
        sights.add(new Sight(R.drawable.irodio, R.string.theater_title, R.string.theater_short_desc,R.string.cat_landmark, R.string.theater_desc, R.string.theater_lat, R.string.theater_long));





        SightAdapter adapter = new SightAdapter(getActivity(), sights);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Sight sight = sights.get(position);
                Intent sightSend = new Intent(getActivity().getApplication(), sight_detailed_info_activity.class);
                sightSend.putExtra("sights",sights);
                sightSend.putExtra("sightToDisplay", position);
                startActivity(sightSend);


            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}



// 37.9716591,23.7246549