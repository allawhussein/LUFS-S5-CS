package com.example.tipscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){

        }
    }

    private View.OnClickListener anonymousClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    private double getBillAmount(EditText billAmount){
        String billAmountString = billAmount.getText().toString();
//        if (billAmountString.isEmpty()) {
//            throw new Exception("Empty Field");
//        }
        double billAmountValue = Double.parseDouble(billAmountString);
        return billAmountValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText billAmount = (EditText) findViewById(R.id.billAmount);
        MainActivity myActivity = this;
        Button buttonTenPercent = (Button) findViewById(R.id.button_10_percent);
        buttonTenPercent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            Double billAmountValue = getBillAmount(billAmount) * 0.1;
                            Toast myToast = Toast.makeText(myActivity, "The Answer is " + billAmountValue.toString(), Toast.LENGTH_SHORT);
                            myToast.show();
                        } catch (Exception exception) {
                            Toast myToast = Toast.makeText(myActivity, "Check Your Input!", Toast.LENGTH_SHORT);
                            myToast.show();
                        }

                    }
                }
        );
        Button buttonTwentyPercent = (Button) findViewById(R.id.button_20_percent);
        buttonTwentyPercent.setOnClickListener(
                view -> {
                    Toast myToast = Toast.makeText(this, "I'm button 20!", Toast.LENGTH_SHORT);
                    myToast.show();

                }
        );

    }
}