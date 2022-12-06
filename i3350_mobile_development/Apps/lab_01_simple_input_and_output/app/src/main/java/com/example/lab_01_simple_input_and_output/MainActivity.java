package com.example.lab_01_simple_input_and_output;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab_01_simple_input_and_output.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // any added code should be added here, as after the above instruction the widgets in activity_main.xml are added to application screen
    }

    /*
    public void updateGreeting(android.view.View submit_btn) {
        textView = (TextView) findViewById(R.id.greeting_text);
        inputField = (EditText) findViewById(R.id.main_input_id);
        textView.setText(inputField.getText());


    }
    */

}