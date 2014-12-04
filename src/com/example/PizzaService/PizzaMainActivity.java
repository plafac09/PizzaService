package com.example.PizzaService;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;

public class PizzaMainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View gridView = inflater.inflate(R.layout.pizzamain,null);

        //showPizzaList();
    }

    public void showPizzaList()
    {

        GridView gridView = (GridView) findViewById(R.id.pizzaView);

        String[] pizzen = getResources().getStringArray(R.array.pizzen);
        PizzaViewAdapter adapter = new PizzaViewAdapter(this, pizzen);

        gridView.setAdapter(adapter);


    }
}
