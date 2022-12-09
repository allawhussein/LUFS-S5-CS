package com.example.biggernumberchildactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button leftBtn, rightBtn;
    TextView points;
    int correct = 0, total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn = findViewById(R.id.l_btn);
        rightBtn = findViewById(R.id.r_btn);
        points = findViewById(R.id.point_field);
        points.setText("Points: 0/0");
        generateNumber();
    }
    private void generateNumber() {
        int leftNumber = (int) (Math.random() * 100);
        int rightNumber = (int) (Math.random() * 100);
        while (leftNumber == rightNumber){
            rightNumber = (int) (Math.random() * 100);
        }

        leftBtn.setText(""+leftNumber);
        rightBtn.setText(""+rightNumber);
    }

    public void greater(View v) {
        int leftNumber = Integer.parseInt(leftBtn.getText().toString());
        int rightNumber = Integer.parseInt(rightBtn.getText().toString());
        if (v.getId() == R.id.l_btn){
            if (leftNumber > rightNumber){
                correct++;
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(this, "Wrong Answer", Toast.LENGTH_LONG).show();
        }
        else {
            if (rightNumber > leftNumber){
                correct++;
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_LONG).show();
            }
            else Toast.makeText(this, "Wrong Answer", Toast.LENGTH_LONG).show();
        }
        total++;
        points.setText("Points "+correct+"/"+total);
        generateNumber();
    }
}