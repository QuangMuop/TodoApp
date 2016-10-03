package com.android.simpletodo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.android.simpletodo.R;

import java.util.ArrayList;

import static com.android.simpletodo.R.id.etNewItem;

/**
 * Created by Administrator on 10/3/2016.
 */

public class TaskItem extends ArrayAdapter<String> {
    Context context;
    int myLayout;
    ArrayList<String> list;

    public TaskItem(Context context, int resource, ArrayList<String> list) {
        super(context, resource, list);
        this.context = context;
        this.myLayout = resource;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(myLayout, parent, false);
        EditText edt = (EditText) rowView.findViewById(etNewItem);
        Button btn = (Button) rowView.findViewById(R.id.btnAddItem);
        edt.setText(list.get(position));
        return rowView;
    }
}
