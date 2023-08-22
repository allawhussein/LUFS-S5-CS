package com.example.notesdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> notes = new ArrayList<String>();
    //String notesAsString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addToHistoryButton = (Button) findViewById(R.id.addToHistoryButton);
        Button checkHistoryButton = (Button) findViewById(R.id.checkHistoryButton);
        EditText noteField = (EditText) findViewById(R.id.noteTextField);

        addToHistoryButton.setOnClickListener(
            view -> {
                String entry = noteField.getText().toString();
                noteField.setText("");
                if (entry.isEmpty()) return;
                //notesAsString += "\n" + entry;
                notes.add(entry);
            }
        );

        checkHistoryButton.setOnClickListener(
            view -> {
                Intent showHistoryIntent = new Intent(this, History.class);
                showHistoryIntent.putStringArrayListExtra("history", notes);
                //showHistoryIntent.putExtra("bulk_history", notesAsString);
                startActivity(showHistoryIntent);
            }
        );
    }
}