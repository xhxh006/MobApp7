package com.ma.mj.hw7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                addFruit.add.setText("Modify");
                addFruit.setOnAddListener(new AddFruit.OnAddListener() {
                    @Override
                    public void onAdd(String name, int num, int price) {
                        arrayList.get(position).name = name;
                        arrayList.get(position).no = num;
                        arrayList.get(position).price = price;
                        addFruit.add.setText("Add");
                    }
                });
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.addCart(position);
                return false;
            }
        });

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
                String cart = "";
                for (int i = 0; i < adapter.cartList.size(); i++){
                    if(!cart.equals("")){
                        cart = cart + ", "+adapter.cartList.get(i);
                    }
                    else{
                        cart = adapter.cartList.get(i);
                    }
                }
                Toast.makeText(getApplicationContext(),"카트에"+cart+"(이)가 담겨있습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        showElse.setOnPriceCheckedListener(new ShowElse.OnPriceCheckedListener() {
            @Override
            public void onPriceChecked(boolean isChecked) {
                if(isChecked){
                    showElse.cb.setChecked(true);
                }
                else{
                    showElse.cb.setChecked(false);
                }
                adapter.getcheck(isChecked);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
