package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private int mCurrentColor = 0;
    private final String sharedPrefFile = "com.example.hellosharedpref.preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button red_btn = (Button) findViewById(R.id.red_btn);
        Button blk_btn = (Button) findViewById(R.id.blk_btn);
        Button blu_btn = (Button) findViewById(R.id.blu_btn);
        Button grn_btn = (Button) findViewById(R.id.grn_btn);
        Button rst_btn = (Button) findViewById(R.id.rst_btn);
        Button inc_btn = (Button) findViewById(R.id.inc_btn);

        TextView mShowCount = (TextView) findViewById(R.id.textView);

        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        if (mPreferences != null) {
            mCount = mPreferences.getInt("count", 1);
            mShowCount.setText(String.format("%s", mCount));
            mCurrentColor = mPreferences.getInt("color", mCurrentColor);
            mShowCount.setBackgroundColor(mCurrentColor);
            mShowCount.setTextColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);;
        SharedPreferences.Editor preferencesEditor =
                mPreferences.edit();
        preferencesEditor.putInt("count", mCount);
        preferencesEditor.putInt("color", mCurrentColor);
        preferencesEditor.apply();
    }

    public void changeColor(View color_btn) {
        TextView mShowCount = (TextView) findViewById(R.id.textView);

        if (color_btn.getId() == R.id.red_btn) mCurrentColor = 0xffff0000;
        else if (color_btn.getId() == R.id.blu_btn) mCurrentColor = 0xff0000ff;
        else if (color_btn.getId() == R.id.blk_btn) mCurrentColor = 0xff000000;
        else if (color_btn.getId() == R.id.grn_btn) mCurrentColor = 0xff00ff00;

        mShowCount.setBackgroundColor(mCurrentColor);
        mShowCount.setTextColor(0xFFFFFFFF);
    }

    public void changeCounter(View counter_btn) {
        TextView mShowCount = (TextView) findViewById(R.id.textView);

        if (counter_btn.getId() == R.id.rst_btn) {
            mCount = 0;
            mShowCount.setTextColor(0xFF000000);
            mShowCount.setBackgroundColor(0);
        }
        else if (counter_btn.getId() == R.id.inc_btn) mCount++;

        mShowCount.setText(String.valueOf(mCount));
    }
}