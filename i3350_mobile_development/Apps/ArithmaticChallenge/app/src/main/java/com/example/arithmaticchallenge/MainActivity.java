package com.example.arithmaticchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int leftNumber;
    private int rightNumber;
    private String operation = "+";
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void populateTextViews(){
        TextView leftNumberTextView = (TextView) findViewById(R.id.leftNumber);
        TextView rightNumberTextView = (TextView) findViewById(R.id.rightNumber);
        TextView operatorTextView= (TextView) findViewById(R.id.operator);
        TextView scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        EditText userAnswer = (EditText) findViewById(R.id.userAnswer);

        leftNumber = (int) (100 * Math.random());
        rightNumber = (int) (100 * Math.random());

        leftNumberTextView.setText(String.valueOf(leftNumber));
        rightNumberTextView.setText(String.valueOf(rightNumber));
        operatorTextView.setText(operation);
        scoreTextView.setText(String.format("Score: %d", score));
        userAnswer.setText("");
    }

    public void checkAnswer(View submitButton){
        EditText userInput = (EditText) findViewById(R.id.userAnswer);
        int answer = Integer.parseInt(userInput.getText().toString());
        if (operation == "+"){
            if (answer == leftNumber + rightNumber) score++;
            else score--;
            populateTextViews();
        }
        else if (operation == "-"){
            if (answer == leftNumber - rightNumber) score++;
            else score--;
            populateTextViews();
        }
        else if (operation == "*"){
            if (answer == leftNumber * rightNumber) score++;
            else score--;
            populateTextViews();
        }
        else if (operation == "/"){
            if (answer == leftNumber / rightNumber) score++;
            else score--;
            populateTextViews();
            refreshNumbers(findViewById(R.id.divRadio));
        }

    }

    public void refreshNumbers(View view) {
        TextView leftNumberTextView = (TextView) findViewById(R.id.leftNumber);
        TextView rightNumberTextView = (TextView) findViewById(R.id.rightNumber);
        TextView operatorTextView= (TextView) findViewById(R.id.operator);

        rightNumber = (int) (10 * Math.random());
        leftNumber = (int) (10 * Math.random()) * leftNumber;

        leftNumberTextView.setText(String.valueOf(leftNumber));
        rightNumberTextView.setText(String.valueOf(rightNumber));
    }

    public void refreshOperator(View view){
        TextView operatorTextView= (TextView) findViewById(R.id.operator);
        if (view.getId() == R.id.addRadio) operatorTextView.setText("+");
        else if (view.getId() == R.id.subRadio) operatorTextView.setText("-");
        else if (view.getId() == R.id.mulRadio) operatorTextView.setText("*");
    }
}