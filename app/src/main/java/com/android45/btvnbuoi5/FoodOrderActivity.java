package com.android45.btvnbuoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodOrderActivity extends AppCompatActivity {
    TextView tvWelcome, tvCount, tvMoney;
    View vShop;
    String process;
    int count;
    ListView lvFood;
    List<Food> foodList;
    ArrayList<FoodOrder> foodListTG;
    Food food01, food02, food03, food04, food05;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_order);

        foodList = new ArrayList<>();
        foodListTG = new ArrayList<>();

        tvWelcome = findViewById(R.id.tvWelcome);
        lvFood = findViewById(R.id.lvFood);
        tvCount = findViewById(R.id.tvCount);
        tvMoney = findViewById(R.id.tvMoney);
        btnOrder = findViewById(R.id.btnOrder);
        vShop = findViewById(R.id.vShop);

        Intent intent = getIntent();
        String user = intent.getExtras().getString("User");
        process = tvWelcome.getText().toString();
        tvWelcome.setText(process + " " + user);

        food01 = new Food(R.drawable.food01, getString(R.string.food01), 10);
        food02 = new Food(R.drawable.food04, getString(R.string.food02), 20);
        food03 = new Food(R.drawable.food03, getString(R.string.food03), 30);
        food04 = new Food(R.drawable.food02, getString(R.string.food04), 40);
        food05 = new Food(R.drawable.food05, getString(R.string.food05), 50);

        foodList.add(food01);
        foodList.add(food02);
        foodList.add(food03);
        foodList.add(food04);
        foodList.add(food05);

        AdapterFood adapterFood = new AdapterFood(foodList);
        lvFood.setAdapter(adapterFood);

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                process = tvCount.getText().toString();
                count = Integer.parseInt(process);
                count++;
                tvCount.setText(String.valueOf(count));

                Food food = foodList.get(position);
                process = tvMoney.getText().toString();
                process = removeLast(process);
                count = Integer.parseInt(process);
                count += food.getPrice();
                tvMoney.setText(count + "$");

                int img = food.getImg();
                String foodName = food.getFoodName();
                int price = food.getPrice();

                FoodOrder foodOrder = new FoodOrder(img, foodName, price, 1);
                if (findFood(foodOrder.getFoodName())) {
                    fixSoLuong(foodOrder.getFoodName());
                } else {
                    foodListTG.add(foodOrder);
                }
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvCount.setText(R.string.start_quantity);
                tvMoney.setText(R.string.first_cost);
                foodListTG.clear();
            }
        });

        vShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent02 = new Intent(getBaseContext(), YourOrderActivity.class);
                UtilityClass.getInstance().setList(foodListTG);
                startActivity(intent02);
            }
        });
    }

    public String removeLast(String str) {
        str = str.substring(0, str.length() - 1);
        return str;
    }

    boolean findFood(String foodName) {
        for(FoodOrder food : foodListTG) {
            if(food.getFoodName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    void fixSoLuong(String foodName) {
        for(FoodOrder food : foodListTG) {
            if(food.getFoodName().equals(foodName)) {
                int i = food.getSoLuong();
                food.setSoLuong(i + 1);
            }
        }
    }
}