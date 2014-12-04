package com.example.PizzaService;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by user on 04.12.2014.
 */
public class PizzaViewAdapter extends BaseAdapter {

    private  final Context context;
    private  final String[] stringData;

    public PizzaViewAdapter(Context context, String[] stringData) {
        this.context= context;
        this.stringData = stringData;
    }


    @Override
    public int getCount() {
        return stringData.length;
    }

    @Override
    public Object getItem(int position) {
        return stringData[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
