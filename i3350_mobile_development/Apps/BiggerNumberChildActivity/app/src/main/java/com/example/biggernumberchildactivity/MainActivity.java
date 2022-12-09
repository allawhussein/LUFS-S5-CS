package com.example.biggernumberchildactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button leftBtn, rightBtn;
    TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn = findViewById(R.id.l_btn);
        rightBtn = findViewById(R.id.r_btn);
        points = findViewById(R.id.point_field);
        points.setText("Points: 0/0");
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
}