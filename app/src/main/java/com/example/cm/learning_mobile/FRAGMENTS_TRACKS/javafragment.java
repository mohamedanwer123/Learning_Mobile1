package com.example.cm.learning_mobile.FRAGMENTS_TRACKS;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cm.learning_mobile.R;
import com.example.cm.learning_mobile.REAGMENTS_COMPONENTS.datafragment;
import com.example.cm.learning_mobile.REAGMENTS_COMPONENTS.interviewfragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class javafragment extends Fragment {

    TextView beginner,intermediate,advanced,interview;
    public javafragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_javafragment, container, false);

        beginner = view.findViewById(R.id.java_beginner);
        intermediate = view.findViewById(R.id.java_Intermediate);
        advanced = view.findViewById(R.id.java_Advanced);
        interview = view.findViewById(R.id.java_interview);




        beginner.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                gotofragment(1);
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotofragment(2);
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotofragment(3);
            }
        });

        interview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotointerviewfragment(10);
            }
        });

        return view;
    }

    public void gotofragment(int key )
    {

        Fragment fragment = new datafragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key",key);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        // fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    public void gotointerviewfragment(int key )
    {

        Fragment fragment = new interviewfragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key2",key);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        // fragmentManager.popBackStack();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

}
