package com.example.vga.tour_guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.drawable.benaki, R.string.benaki_title, R.string.benaki_short_desc,R.string.cat_museum,R.string.benaki_desc, R.string.benaki_lat, R.string.benaki_long));
        sights.add(new Sight(R.drawable.acrop_museum, R.string.acropolis_museum_title, R.string.acropolis_museum_short_desc,R.string.cat_museum,R.string.acropolis_museum_desc, R.string.acropolis_museum_lat, R.string.acropolis_museumg_long));
        sights.add(new Sight(R.drawable.cycladic, R.string.cycladic_title, R.string.cycladic_short_desc,R.string.cat_museum,R.string.cycladic_desc, R.string.cycladic_lat, R.string.cycladic_long));
        sights.add(new Sight(R.drawable.war, R.string.war_title, R.string.war_short_desc,R.string.cat_museum,R.string.war_desc, R.string.war_lat, R.string.war_long));
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
