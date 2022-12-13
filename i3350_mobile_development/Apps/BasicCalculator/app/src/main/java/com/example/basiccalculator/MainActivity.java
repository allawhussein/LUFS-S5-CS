package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View submitButton){
        RadioGroup radioButtons = (RadioGroup) findViewById(R.id.operations);
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("");
        EditText number_1_input = (EditText) findViewById(R.id.number_1_edit_view);
        EditText number_2_input = (EditText) findViewById(R.id.number_2_edit_view);

        try{
            int number_1 = Integer.parseInt(number_1_input.getText().toString());
            int number_2 = Integer.parseInt(number_2_input.getText().toString());

            if (radioButtons.getCheckedRadioButtonId() == R.id.add){
                resultTextView.setText(String.valueOf(number_1 + number_2));
            }
            else if (radioButtons.getCheckedRadioButtonId() == R.id.sub){
                resultTextView.setText(String.valueOf(number_1 - number_2));
            }
            else if (radioButtons.getCheckedRadioButtonId() == R.id.mul){
                resultTextView.setText(String.valueOf(number_1 * number_2));
            }
            else if (radioButtons.getCheckedRadioButtonId() == R.id.div){
                resultTextView.setText(String.valueOf((float) number_1 / number_2));
            }
            else {
                Toast.makeText(getApplicationContext(), "Select an operation to perform", Toast.LENGTH_SHORT).show();
            }
        }
        catch (NumberFormatException ex){
            Toast.makeText(getApplicationContext(), "Enter a valid Number", Toast.LENGTH_SHORT).show();
        }
    }
}