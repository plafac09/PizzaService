package com.example.PizzaService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import beans.Pizza;

import java.util.LinkedList;

/**
 * Created by user on 04.12.2014.
 */
public class PizzaViewAdapter extends BaseAdapter {

    private  final Context context;
    private LinkedList<Pizza> pizzaList;

    public PizzaViewAdapter(Context context, LinkedList<Pizza> pizzaList) {
        this.context= context;
        this.pizzaList = pizzaList;
    }


    @Override
    public int getCount() {
        return pizzaList.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<ssaa"+position);
        if(convertView == null)
        {
            gridView = inflater.inflate(R.layout.pizzaitem,null);
        }else
        {
            gridView= convertView;
        }
        TextView textview = (TextView) gridView.findViewById(R.id.pizzaitem);

        Pizza aktPizza = pizzaList.get(position);

        textview.setText(aktPizza.toString());

        return gridView;
    }
}
