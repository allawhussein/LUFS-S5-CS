package com.example.photogallerywithspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // https://developer.android.com/develop/ui/views/components/spinner
    // a very useful documentation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        // create an ArrayAdapter using figher aircraft string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.figher_aircraft,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // link spinner to the event handler?
        spinner.setOnItemSelectedListener(new SpinnerActivity(findViewById(R.id.imageView)));
    }
}