package com.android.masiro.proj091;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by haeyoung on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter{

    ArrayList<Fruit> data;
    Context context;
    TextView tv2;
    Boolean isDataChanged = false;
    Boolean isSelected = false;
    ArrayList<String> cart = new ArrayList<String>();

    public GridAdapter(ArrayList<Fruit> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item,null);
        final TextView tv = (TextView)convertView.findViewById(R.id.tvname);
        tv2 = (TextView)convertView.findViewById(R.id.tvname2);
        final ImageView img = (ImageView)convertView.findViewById(R.id.imageview);
        final CheckBox cb = (CheckBox)convertView.findViewById(R.id.checkBox2);

        Fruit fruit = data.get(position);
        if(isDataChanged) tv2.setVisibility(TextView.VISIBLE);
        else tv2.setVisibility(TextView.GONE);
        if(isSelected) cb.setVisibility(CheckBox.VISIBLE);
        else cb.setVisibility(CheckBox.GONE);
        if(cb.isChecked()) cart.add(fruit.getName());
        tv.setText(fruit.getName());
        tv2.setText(fruit.getPrice());
        img.setImageResource(Fruit.imglist[fruit.getImgno()]);

        return convertView;
    }

    public void setVisible(Boolean isVisible){
        isDataChanged = isVisible;
        notifyDataSetChanged();
    }

    public void setSelectVisible(Boolean isVisible){
        cart.clear();
        isDataChanged = isVisible;
        isSelected = isVisible;
        notifyDataSetChanged();
    }

    public void addFruit(Fruit one){
        data.add(one);
        notifyDataSetChanged();
    }

    public void ModifiedFruit(Fruit one, int position){
        Fruit fruitdata = data.get(position);
        fruitdata.setName(one.getName());
        fruitdata.setImgno(one.getImgno());
        fruitdata.setPrice(one.getPrice());
        notifyDataSetChanged();
    }

    public void toastMsg(){
        String msg = "";
        for(int i =0 ; i<cart.size();i++)
        msg += "," + cart.get(i);
        Toast.makeText(context,"카트에 " + msg.substring(1)+ "가 담겨있습니다",Toast.LENGTH_SHORT).show();
    }
}
