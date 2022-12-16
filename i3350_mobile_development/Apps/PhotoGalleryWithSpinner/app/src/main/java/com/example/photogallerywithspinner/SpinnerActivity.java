package com.example.photogallerywithspinner;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SpinnerActivity implements AdapterView.OnItemSelectedListener {
    ImageView image;

    public SpinnerActivity(ImageView image){
        this.image = image;
    }
    public void onItemSelected(AdapterView<?> spin, View view, int pos, long id) {
        //TextView result = (TextView) findViewById(R.id.spinner_result);
        // The above is not possible as this class is not an activity and can't envoke findViewById method
        String choice = spin.getSelectedItem().toString();
        if (choice.equals("F14 Tomcat"))
            image.setImageResource(R.drawable.f14);
        else if (choice.equals("F15 Eagle"))
            image.setImageResource(R.drawable.f15);
        else if (choice.equals("F18 Hornet"))
            image.setImageResource(R.drawable.f18);
        else image.setImageResource(R.drawable.f22);
    }

    public void onNothingSelected(AdapterView<?> spin) {
        // empty
    }
}
