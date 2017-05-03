package com.ma.mj.hw7;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by KimMinJung on 2017-04-27.
 */

public class ShowElse extends LinearLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    CheckBox cb;
    Button cart;
    public ShowElse(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.price,this);

        cb = (CheckBox)findViewById(R.id.price_cb);
        cart = (Button)findViewById(R.id.cart_b);

        cb.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);
        cart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onCartClickListener.onCartClick();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        onPriceCheckedListener.onPriceChecked(isChecked);
    }

    interface OnCartClickListener{
        void onCartClick();
    }
    public OnCartClickListener onCartClickListener;

    public void setOnCartClickListener(OnCartClickListener onCartClickListener){
        this.onCartClickListener = onCartClickListener;
    }

    interface OnPriceCheckedListener{
        void onPriceChecked(boolean isChecked);
    }
    public OnPriceCheckedListener onPriceCheckedListener;

    public void setOnPriceCheckedListener(OnPriceCheckedListener onPriceCheckedListener){
        this.onPriceCheckedListener = onPriceCheckedListener;
    }
}
