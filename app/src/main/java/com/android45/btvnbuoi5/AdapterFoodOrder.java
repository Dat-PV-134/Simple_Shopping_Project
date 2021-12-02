package com.android45.btvnbuoi5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterFoodOrder extends BaseAdapter {
    List<FoodOrder> foodList;

    public AdapterFoodOrder(List<FoodOrder> foodList) {
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.icon_food_order, parent, false);

        ImageView imgFood = view.findViewById(R.id.imgFood);
        TextView tvFoodName = view.findViewById(R.id.tvFoodName);
        TextView tvPrice = view.findViewById(R.id.tvPrice);
        TextView tvSoLuong = view.findViewById(R.id.tvAmount);

        FoodOrder food = foodList.get(position);

        imgFood.setImageResource(food.getImg());
        tvFoodName.setText(food.getFoodName());
        tvPrice.setText(String.valueOf(food.getPrice()) + "$");
        tvSoLuong.setText("Số lượng: " + String.valueOf(food.getSoLuong()));

        return view;
    }
}
