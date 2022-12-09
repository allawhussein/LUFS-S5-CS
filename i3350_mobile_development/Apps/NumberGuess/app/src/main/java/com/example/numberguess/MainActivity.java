package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView guessTextView;
    TextView guessCtr;
    Button submitButton;
    Button rstBtn;
    EditText guessInput;
    int randInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guessTextView = findViewById(R.id.guess_text);
        submitButton = findViewById(R.id.entr_btn);
        rstBtn = findViewById(R.id.rst_btn);
        guessCtr = findViewById(R.id.guess_ctr);
        guessCtr.setText("0");
        guessInput = findViewById(R.id.guess_field);
        randInt = (int)(Math.random() * 100);
    }

    public void checkGuess(View )
}