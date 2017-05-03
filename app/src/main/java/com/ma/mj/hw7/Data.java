package com.ma.mj.hw7;

import java.util.Date;

/**
 * Created by KimMinJung on 2017-04-27.
 */

public class Data {
    final static int imaglist[] = {R.drawable.abocado,R.drawable.banana,
            R.drawable.cherry,R.drawable.cranberry,R.drawable.grape,
            R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    String name;
    int no, price;

    public Data(String name, int no, int price){
        this.name = name;
        this.no = no;
        this.price = price;

    }

}
