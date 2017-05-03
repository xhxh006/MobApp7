package com.ma.mj.hw7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KimMinJung on 2017-04-30.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<Data> dataList = new ArrayList<>();
    TextView t;
    boolean isChecked;

    public CustomAdapter(Context context, ArrayList<Data> arrayList){
        this.context = context;
        this.dataList = arrayList;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gridview_layout,null);
        }
        t = (TextView)convertView.findViewById(R.id.show_t);
        final ImageView i = (ImageView)convertView.findViewById(R.id.show_i);

        checkedText(isChecked,position);
        i.setImageResource(dataList.get(position).no);

        return convertView;
    }
    public void checkedText(boolean ischecked, int position){
        if(ischecked){
            t.setText(dataList.get(position).name + " " +dataList.get(position).price+"원");
        }
        else{
            t.setText(dataList.get(position).name);
        }
    }
    public void getcheck (boolean ischecked){
        this.isChecked = ischecked;
    }
}
