package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int pizzaSize = 0;
    private float price = 0;
    ArrayList<String> cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setPizzaSize(View radioButton){
        if (radioButton.getId() == R.id.smallRadio) pizzaSize = 1;
        else if (radioButton.getId() == R.id.mediumRadio) pizzaSize = 2;
        else if (radioButton.getId() == R.id.largeRadio) pizzaSize = 3;
        else pizzaSize = 0;
    }

    public void computePrice(View computePriceButton){
        TextView viewOrderPrice = (TextView) findViewById(R.id.viewOrderPrice);
        price = 0;

        // calculating base price based on pizza size
        if (pizzaSize == 0){
            viewOrderPrice.setText("Choose Your Order!");
        }
        else if (pizzaSize == 1){
            price = 200000;
        }
        else if (pizzaSize == 2){
            price = 300000;
        }
        else if (pizzaSize == 3){
            price = 400000;
        }
        else{
            Toast.makeText(this, "Internal error while calculating pizza size", Toast.LENGTH_SHORT).show();
            return;
        }
        // adding addons price
        CheckBox addon = (CheckBox) findViewById(R.id.addon_item_1);
        if (addon.isChecked()) price += 50000;
        addon = (CheckBox) findViewById(R.id.addon_item_2);
        if (addon.isChecked()) price += 50000;
        addon = (CheckBox) findViewById(R.id.addon_item_3);
        if (addon.isChecked()) price += 50000;
        addon = (CheckBox) findViewById(R.id.addon_item_4);
        if (addon.isChecked()) price += 50000;

        viewOrderPrice.setText("Your Order Price is " + String.valueOf(price));
    }

    public void addtoCart(View addtoCartButton){
        // add items into an ArrayList<Pizza>
        // where class pizza is to be created later on
    }

    public void checkout(View checkOutButton){
        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);
    }
}