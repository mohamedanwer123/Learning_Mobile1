package com.example.cm.learning_mobile.LISTENER;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cm.learning_mobile.MODEL.data;
import com.example.cm.learning_mobile.R;

import java.util.ArrayList;

/**
 * Created by cm on 27/11/2017.
 */

public class Adapter  extends ArrayAdapter {

    ArrayList<data> arrayList;
    Context context;
    int res;


    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<data> arrayList) {
        super(context, resource, arrayList);
        this.arrayList = arrayList;
        this.res = resource;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(res,parent,false);
        TextView textView = convertView.findViewById(R.id.tv);
        TextView number = convertView.findViewById(R.id.number);
        textView.setText(arrayList.get(position).getTitle());
        number.setText(arrayList.get(position).getNumber());
        return convertView;
    }
}
