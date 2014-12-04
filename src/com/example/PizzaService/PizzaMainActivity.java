package com.example.PizzaService;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
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
    private LinkedList<Pizza> lili = new LinkedList<Pizza>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        GridView gridView = (GridView) findViewById(R.id.pizzaView);

        String[] pizzen = getResources().getStringArray(R.array.pizzen);
        PizzaViewAdapter adapter = new PizzaViewAdapter(pizzamain.getContext(), pizzen);

        gridView.setAdapter(adapter);


    }

    public void loadCSV(AssetManager am) {
        try {
            InputStream is = am.open("data.csv");
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null && !(line = br.readLine()).isEmpty())
            {
                lili.add(new Pizza(line.split(";")[0], line.split(";")[1], Double.parseDouble(line.split(";")[2])));
            }
        } catch (IOException e) {

        }
    }
}
