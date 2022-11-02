package com.example.willpower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class GameAddCongrats extends AppCompatActivity {

    ImageButton gameAddictionOpenapps, gameAddictionToPsychiatrist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_add_congrats);

        gameAddictionOpenapps = findViewById(R.id.gameAddictionCheckOpenAppsButton);
        gameAddictionToPsychiatrist = findViewById(R.id.game_congrats_to_psy);



        gameAddictionOpenapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameAddCongrats.this, MainTimePage.class);
                startActivity(intent);
            }
        });

        gameAddictionToPsychiatrist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameAddCongrats.this, PsychiatristInfo.class);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

    }
}