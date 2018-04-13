package com.example.cm.learning_mobile.FRAGMENTS_DETAILSandEXPLAINS;


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
public class detailsfragments extends Fragment {

    TextView textView,title;
    String tit;
    public detailsfragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detailsfragments, container, false);
        textView = view.findViewById(R.id.details);
        title = view.findViewById(R.id.tit);

        tit = getArguments().getString("data");
        title.setText(tit);
        file(tit);
        return  view;
    }

    public void file(String s)
    {
        String txt="";
        try {
            InputStream inputStream = getActivity().getAssets().open(s+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String word=null;
            while ((word=bufferedReader.readLine())!=null)
            {
                txt+=word+"\n";
            }
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView.setText(txt);

    }

}
