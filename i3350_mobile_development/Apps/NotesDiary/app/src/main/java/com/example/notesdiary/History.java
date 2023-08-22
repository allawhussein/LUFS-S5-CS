package com.example.notesdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    private ArrayList<String> notes;
    //private String notesAsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();

        notes = intent.getStringArrayListExtra("history");
        if (notes == null) {
            Toast
                .makeText(this, "There's no extra string array in intent", Toast.LENGTH_SHORT)
                .show();
            return;
        }
        //notesAsString = savedInstanceState.getString("history_bulk");
        EditText textField = (EditText) findViewById(R.id.target);
        textField.setText(String.join("\n", notes));
        //textField.setText(notesAsString);
    }
}