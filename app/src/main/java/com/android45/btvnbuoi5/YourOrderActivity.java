package com.android45.btvnbuoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class YourOrderActivity extends AppCompatActivity {
    ListView lvYourOrder;
    List<FoodOrder> foodList;
    TextView tvCost;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);

        foodList = new ArrayList<>();

        lvYourOrder = findViewById(R.id.lvYourOrder);
        view = findViewById(R.id.vBack);
        tvCost = findViewById(R.id.tvCost);

        foodList = UtilityClass.getInstance().getList();

        AdapterFoodOrder adapterFoodOrder = new AdapterFoodOrder(foodList);
        lvYourOrder.setAdapter(adapterFoodOrder);

        if (!foodList.isEmpty()) {
            tvCost.setText(tinhCost() + "$");
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    int tinhCost() {
        int cost = 0;
        for(FoodOrder food : foodList) {
            cost += food.getSoLuong() * food.getPrice();
        }
        return cost;
    }
}