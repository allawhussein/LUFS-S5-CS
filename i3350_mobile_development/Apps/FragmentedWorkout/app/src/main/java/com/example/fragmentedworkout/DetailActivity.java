package com.example.fragmentedworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_WORKOUT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment frag = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int workout = getIntent().getIntExtra(EXTRA_WORKOUT_ID, -1);

        if (frag != null) {
            if (workout != -1) frag.setWorkout(workout);
            else Toast.makeText(this, "Workout Selection Error", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Fragment not found", Toast.LENGTH_SHORT).show();
        }
    }
}