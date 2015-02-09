package com.example.PizzaService;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import beans.Pizza;

import java.util.LinkedList;

/**
 * Created by user on 04.12.2014.
 */
public class PizzaViewAdapter extends BaseAdapter {

    private  final Context context;
    private LinkedList<Pizza> pizzaList;
    private NumberPicker[] numberPickers;

    public PizzaViewAdapter(Context context, LinkedList<Pizza> pizzaList) {
        this.context= context;
        this.pizzaList = pizzaList;
        numberPickers = new NumberPicker[pizzaList.size()];
       /* for(int i=0;i<pizzaList.size();i++)
        {
            numberPickers[i] = new NumberPicker(context);
            numberPickers[i].setMaxValue(10);
            numberPickers[i].setMinValue(0);
        }*/
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
        return position;
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
            gridView = convertView;
        }

        if(position%2==0)
        {
            gridView.setBackgroundColor(Color.rgb(229,200,133));
        }else
        {
            gridView.setBackgroundColor(Color.rgb(230,132,84));
        }


        ImageView bild = (ImageView) gridView.findViewById(R.id.pizzaBild);
        TextView nameTV = (TextView) gridView.findViewById(R.id.pizzaItemName);
        TextView preisTV = (TextView) gridView.findViewById(R.id.pizzaItemPreis);
        ViewGroup linlay = (ViewGroup) gridView.findViewById(R.id.numberPickerLayout);
        Pizza aktPizza = pizzaList.get(position);
        linlay.removeAllViews();
        System.out.println("pos = "+position);

        linlay.addView(new NumberPicker(context));

        Resources res = gridView.getResources();
        int resID = res.getIdentifier(aktPizza.getBild() , "drawable", "com.example.PizzaService");
        Drawable drawable = res.getDrawable(resID);
        bild.setImageDrawable(drawable);



        nameTV.setText(aktPizza.getName());
        preisTV.setText(String.format("%5.2f€",aktPizza.getPreis()));
        return gridView;
    }

    public NumberPicker getNumberPicker(int position)
    {
        return numberPickers[position];
    }

    public LinkedList<Pizza> getPizzen()
    {
        return pizzaList;
    }
}
