package com.example.cm.learning_mobile.REAGMENTS_COMPONENTS;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cm.learning_mobile.LISTENER.Adapter;
import com.example.cm.learning_mobile.FRAGMENTS_DETAILSandEXPLAINS.detailsfragments;
import com.example.cm.learning_mobile.MODEL.data;
import com.example.cm.learning_mobile.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class datafragment extends Fragment {

    ListView listView;
    ArrayList<data> arrayList;
    Adapter adapter;


    public datafragment() {
        // Required empty public constructor
    }

    int x=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        arrayList = new ArrayList<>();
        x = getArguments().getInt("key");

        View view =  inflater.inflate(R.layout.fragment_datafragment, container, false);

        listView = view.findViewById(R.id.lv);

            put(x);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Fragment fragment = new detailsfragments();
                    Bundle bundle = new Bundle();
                    String data = arrayList.get(i).getTitle().toString();
                    bundle.putString("data",data);
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout,fragment);
                    fragmentTransaction.commit();
                }
            });

        return view;
    }


    public  void put(int i)
    {

        arrayList.clear();

        try {
            InputStream inputStream = getActivity().getAssets().open("f"+x+".txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String word=null;
            while ((word=bufferedReader.readLine())!=null)
            {
                String arr[]=word.split("/");
                arrayList.add(new data(arr[0],arr[1]));
            }
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new Adapter(getActivity(),R.layout.items,arrayList);
        listView.setAdapter(adapter);
    }






}
