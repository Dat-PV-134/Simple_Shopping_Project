package com.android45.btvnbuoi5;

public class Food {
    int img;
    String foodName;
    int price;

    public Food(int img, String foodName, int price) {
        this.img = img;
        this.foodName = foodName;
        this.price = price;
    }

    public Food() {}

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
