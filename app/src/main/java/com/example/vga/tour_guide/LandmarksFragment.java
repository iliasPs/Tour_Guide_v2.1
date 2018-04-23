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
        sights.add(new Sight(R.drawable.acropolis, R.string.acropolis_title, R.string.acropolis_short_desc,R.string.cat_landmark,R.string.acropolis_location, R.string.acropolis_desc));
        sights.add(new Sight(R.drawable.soldier, R.string.soldier_title, R.string.soldier_short_desc,R.string.cat_landmark,R.string.soldier_location, R.string.soldier_desc));
        sights.add(new Sight(R.drawable.stadium, R.string.stadium_title, R.string.stadium_short_desc,R.string.cat_landmark,R.string.stadium_location, R.string.stadium_desc));
        sights.add(new Sight(R.drawable.plaka, R.string.plaka_title, R.string.plaka_short_desc,R.string.cat_landmark,R.string.plaka_location, R.string.plaka_desc));
        sights.add(new Sight(R.drawable.irodio, R.string.theater_title, R.string.theater_short_desc,R.string.cat_landmark,R.string.theater_location, R.string.theater_desc));





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
