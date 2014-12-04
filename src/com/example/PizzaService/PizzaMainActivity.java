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
    private View pizzamain;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        pizzamain = inflater.inflate(R.layout.pizzamain,null);
        ViewGroup changingMain = (ViewGroup) findViewById(R.id.changingMain);
        changingMain.addView(pizzamain);
        showPizzaList();
    }

    public void showPizzaList()
    {

        GridView gridView = (GridView) findViewById(R.id.pizzaView);

        String[] pizzen = getResources().getStringArray(R.array.pizzen);
        PizzaViewAdapter adapter = new PizzaViewAdapter(pizzamain.getContext(), pizzen);

        gridView.setAdapter(adapter);


    }
}
