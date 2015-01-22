package com.example.PizzaService;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.*;
import android.widget.GridView;
import android.widget.NumberPicker;
import beans.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class PizzaMainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private View pizzamain;
    private LinkedList<Pizza> pizzaList = new LinkedList<Pizza>();
    private PizzaViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.main);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pizzamain = inflater.inflate(R.layout.pizzamain,null);
        ViewGroup changingMain = (ViewGroup) findViewById(R.id.changingMain);
        changingMain.addView(pizzamain);
        loadCSV(getBaseContext().getApplicationContext().getAssets());
        showPizzaList();
    }


    public void showPizzaList()
    {
        GridView pizzaView = (GridView) findViewById(R.id.pizzaView);
        adapter = new PizzaViewAdapter(pizzamain.getContext(), pizzaList);

        pizzaView.setAdapter(adapter);
    }

    public void loadCSV(AssetManager am) {
        try {
            InputStream is = am.open("pizzaliste.csv");
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null && !(line.isEmpty()))
            {
                pizzaList.add(new Pizza(line.split(";")[0], line.split(";")[1], Double.parseDouble(line.split(";")[2]), line.split(";")[3]));
            }
        } catch (IOException e) {

        }
    }

    public void bestellen(View view)
    {
        LinkedList<Pizza> bestellt = new LinkedList<Pizza>();
        LinkedList<Pizza> pizzen = adapter.getPizzen();
        for(int i = 0; i<pizzen.size();i++)
        {
            NumberPicker aktNumberPicker = adapter.getNumberPicker(i);
            if(aktNumberPicker.getValue()!=0)
            {
                Pizza aktPizza = pizzen.get(i);
                aktPizza.setAnz(aktNumberPicker.getValue());
                System.out.println(aktPizza.toString());
                bestellt.add(aktPizza);
            }

        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<");

    }
}
