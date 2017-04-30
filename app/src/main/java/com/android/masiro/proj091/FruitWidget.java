package com.android.masiro.proj091;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by haeyoung on 2017-04-27.
 */

public class FruitWidget extends LinearLayout implements View.OnClickListener {

    int imgno = 0;
    int priceno = 0;
    public AutoCompleteTextView et;
    ImageView img;
    Button b_next, b_add;
    public int BUTTON_MODE = 0;
    static int BUTTON_MODE_ADD = 1;
    static int BUTTON_MODE_MODIFIED = 2;


    public FruitWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    void setWidget(String name, int no) {
        imgno = no;
        priceno = no;
        et.setText(name);
        img.setImageResource(Fruit.imglist[imgno]);
        BUTTON_MODE = BUTTON_MODE_MODIFIED;
        b_add.setText("M");
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom, this);
        et = (AutoCompleteTextView)findViewById(R.id.f_name);
        img = (ImageView) findViewById(R.id.image1);
        b_next = (Button) findViewById(R.id.b_next);
        b_add = (Button) findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
        BUTTON_MODE = BUTTON_MODE_ADD;
    }

    @Override
    public void onClick(View v) {
        if (v == b_add) {
            if (BUTTON_MODE == BUTTON_MODE_ADD) {
                onItemListener.OnAdd(et.getText().toString(), imgno
                        , Integer.toString(Fruit.pricelist[priceno]));
                et.setText(null);
            }
            else if(BUTTON_MODE == BUTTON_MODE_MODIFIED){

                onItemListener.OnModified(et.getText().toString(), imgno
                        ,Integer.toString(Fruit.pricelist[priceno]));

                BUTTON_MODE = BUTTON_MODE_ADD;
                b_add.setText("ADD");
                et.setText(null);
        }

        }

        else if (v == b_next) {

            imgno++;
            priceno++;
            if (imgno > 7) {
                imgno = 0;
                priceno = 0;
            }
            img.setImageResource(Fruit.imglist[imgno]);

        }
    }

    interface OnItemListener {
        void OnAdd(String name, int imgno, String price);
        void OnModified(String name, int imgno, String price);
    }

    public OnItemListener onItemListener; //핸들러

    public void setOnListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

}
