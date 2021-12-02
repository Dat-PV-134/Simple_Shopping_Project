package com.android45.btvnbuoi5;

public class FoodOrder extends Food {
    int soLuong;

    public FoodOrder(int img, String foodName, int price, int soLuong) {
        super(img, foodName, price);
        this.soLuong = soLuong;
    }

    public FoodOrder(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
