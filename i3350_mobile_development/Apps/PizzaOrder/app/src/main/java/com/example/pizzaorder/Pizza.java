package com.example.pizzaorder;

import android.text.TextUtils;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Pizza {
    private int size = 0;
    private ArrayList<String> addons;

    public void setPizzaSize(int size){
        this.size = size;
    }
    public int getPizzaSize(){
        return size;
    }
    public String getPizzaSizeString(){
        if (size == 0) return "Undefined";
        else if (size == 1) return "Small";
        else if (size == 2) return "Medium";
        else if (size == 3) return "Large";
        else return "Invalid Pizza Size";
    }
    public void setAddons(ArrayList<String> addons){
        this.addons = addons;
    }
    public ArrayList<String> getAddons(){
        return this.addons;
    }

    @NonNull
    @Override
    public String toString(){
        if (size < 1 || size > 3){
            return "Invalid order";
        }
        else return getPizzaSizeString() + " Pizza with " + TextUtils.join(", ", addons);
        // TextUtils.join(", ", list) is similar to String.join(", ", list);
    }
    public float getPrice(){
        return size * 100000 + 100000 + 50000 * addons.size();
    }
}
