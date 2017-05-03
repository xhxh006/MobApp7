package com.ma.mj.hw7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Data> arrayList = new ArrayList<>();

    GridView gridView;
    CustomAdapter adapter;
    AddFruit addFruit;
    ShowElse showElse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.grid);
        adapter = new CustomAdapter(this, arrayList);
        gridView.setAdapter(adapter);

        addFruit = (AddFruit)findViewById(R.id.adding);
        showElse = (ShowElse)findViewById(R.id.showing);

        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int num, int price) {
                arrayList.add(new Data(name, num, price));
                adapter.notifyDataSetChanged();
            }
        });
        showElse.setOnCartClickListener(new ShowElse.OnCartClickListener() {
            @Override
            public void onCartClick() {
                Toast.makeText(getApplicationContext(),"카트에",Toast.LENGTH_SHORT).show();
            }
        });
        showElse.setOnPriceCheckedListener(new ShowElse.OnPriceCheckedListener() {
            @Override
            public void onPriceChecked(boolean isChecked) {
                if(isChecked){
                    showElse.cb.setChecked(false);
                    adapter.getcheck(isChecked);
                }
            }
        });
    }
}
