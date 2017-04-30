package com.android.masiro.proj091;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by haeyoung on 2017-04-27.
 */

public class CustomWidget extends LinearLayout implements View.OnClickListener{
    CheckBox c;
    Button b,b2;
    int MODE = 0;

    public CustomWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    public void onClick(View v) {
        //버튼 클릭 이벤트
        MODE++;
        if(v == b2) {
            if (MODE % 2 == 1) onButtonListener.OnSetButton();
            else onButtonListener.OnAddItemButton();
        }

        if(v == b) onButtonListener.OnItemMsg();
    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom2,this);
        c = (CheckBox)findViewById(R.id.checkBox);
        b = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b.setOnClickListener(this);
        b2.setOnClickListener(this);

        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckBoxChangedListener.Checked(c.isChecked());
            }
        });
    }

    interface OnCheckBoxChangedListener{
        void Checked(Boolean ischecked);
    }

    public OnCheckBoxChangedListener onCheckBoxChangedListener;

    public void setOnCheckBoxChangedListener(OnCheckBoxChangedListener onCheckBoxChangedListener){
        this.onCheckBoxChangedListener = onCheckBoxChangedListener;
    }

    interface OnButtonListener {
        void OnSetButton();
        void OnAddItemButton();
        void OnItemMsg();
    }

    public OnButtonListener onButtonListener; //핸들러

    public void setOnListener(OnButtonListener onButtonListener) {
        this.onButtonListener = onButtonListener;
    }

}
