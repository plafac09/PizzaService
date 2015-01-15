package com.example.PizzaService;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.NumberPicker;
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

        if(convertView == null)
        {
            gridView = inflater.inflate(R.layout.pizzaitem,null);
        }else
        {
            gridView= convertView;
        }

        if(position%2==0)
        {
            gridView.setBackgroundColor(Color.rgb(229,200,133));
        }else
        {
            gridView.setBackgroundColor(Color.rgb(230,132,84));
        }
        TextView nameTV = (TextView) gridView.findViewById(R.id.pizzaItemName);
        TextView preisTV = (TextView) gridView.findViewById(R.id.pizzaItemPreis);
        NumberPicker anzNP = (NumberPicker) gridView.findViewById(R.id.pizzaItemNP);
        Pizza aktPizza = pizzaList.get(position);
        anzNP.setMaxValue(10);
        anzNP.setMinValue(0);
        nameTV.setText(aktPizza.getName());
        preisTV.setText(String.format("%5.2f€",aktPizza.getPreis()));
        return gridView;
    }
}
