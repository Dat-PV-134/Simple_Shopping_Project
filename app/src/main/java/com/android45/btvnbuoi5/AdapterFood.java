package com.android45.btvnbuoi5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterFood extends BaseAdapter {
    List<Food> foodlist;

    public AdapterFood(List<Food> foodlist) {
        this.foodlist = foodlist;
    }

    @Override
    public int getCount() {
        return foodlist.size();
    }

    @Override
    public Object getItem(int position) {
        return foodlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.icon_food, parent, false);

        ImageView imgFood = view.findViewById(R.id.imgFood);
        TextView tvFoodName = view.findViewById(R.id.tvFoodName);
        TextView tvPrice = view.findViewById(R.id.tvPrice);

        Food food = foodlist.get(position);

        imgFood.setImageResource(food.getImg());
        tvFoodName.setText(food.getFoodName());
        tvPrice.setText(String.valueOf(food.getPrice()) + "$");

        return view;
    }
}
