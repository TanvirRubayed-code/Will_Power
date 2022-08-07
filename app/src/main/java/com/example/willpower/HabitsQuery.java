package com.example.willpower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HabitsQuery extends AppCompatActivity {

    TextView habit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habits_query);

        habit = findViewById(R.id.habits);
        SharedPreferences sharedPref = getSharedPreferences("saveHabit", Context.MODE_PRIVATE);
        boolean gameAddict = sharedPref.getBoolean("gameAddiction",false);
        if(gameAddict){
            habit.setText("Game Addicted");
        }
        else {
            Toast.makeText(getApplicationContext(),"Not game addicted",Toast.LENGTH_SHORT).show();
        }

    }
}