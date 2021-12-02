package com.android45.btvnbuoi5;

import java.util.ArrayList;

public class UtilityClass {
    private static UtilityClass instance;

    private ArrayList<FoodOrder> list;

    public ArrayList<FoodOrder> getList() {
        return list;
    }

    public void setList(ArrayList<FoodOrder> list) {
        this.list = list;
    }

    private UtilityClass(){}

    public static UtilityClass getInstance(){
        if(instance == null){
            instance = new UtilityClass();
        }
        return instance;
    }
}
