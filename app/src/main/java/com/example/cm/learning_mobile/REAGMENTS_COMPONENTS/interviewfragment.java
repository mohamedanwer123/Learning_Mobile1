package com.example.cm.learning_mobile.REAGMENTS_COMPONENTS;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cm.learning_mobile.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class interviewfragment extends Fragment {


    TextView textView;
    int x=0;
    public interviewfragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        x = getArguments().getInt("key2");
        View view = inflater.inflate(R.layout.fragment_interviewfragment, container, false);
       textView = view.findViewById(R.id.ques);

       put2(x);
        return view;
    }

    public  void put2(int i)
    {
     String s="";

        try {
            InputStream inputStream = getActivity().getAssets().open("interview"+x+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String word=null;
            while ((word=bufferedReader.readLine())!=null)
            {
                s+=word+"\n";
            }
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView.setText(s);

    }

}
