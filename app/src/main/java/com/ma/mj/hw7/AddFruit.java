package com.ma.mj.hw7;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by KimMinJung on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    EditText input_f, intput_p;
    ImageView img;
    Button next, add;

    int imageno = 0;

    public AddFruit(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.add,this);

        input_f = (EditText)findViewById(R.id.userfruit);
        intput_p = (EditText)findViewById(R.id.userprice);
        img = (ImageView)findViewById(R.id.imageView);
        next = (Button)findViewById(R.id.next_b);
        add = (Button)findViewById(R.id.add_b);

        add.setOnClickListener(this);
        next.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == add){
            onAddListener.onAdd(input_f.getText().toString(),
                    Data.imaglist[imageno],
                    Integer.parseInt(intput_p.getText().toString()));
        }
        else{
            if (imageno == Data.imaglist.length - 1) {imageno = -1;}
            img.setImageResource(Data.imaglist[++imageno]);
        }
    }

    interface OnAddListener{
        void onAdd(String name, int num, int price);
    }
    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
}
