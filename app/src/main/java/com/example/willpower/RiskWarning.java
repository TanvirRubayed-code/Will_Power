package com.example.willpower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class RiskWarning extends AppCompatActivity {

    Button highRiskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_warning);

        //update level from warning page
        SharedPreferences sp = getSharedPreferences("glevel", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        int level = sp.getInt("level", 0);
        level++;

        edit.putInt("level", level);
        edit.commit();


        // receive data from putExtra method
        Bundle bundle = getIntent().getExtras();
        String addiction = "";
        if (bundle != null) {
            addiction = bundle.getString("addiction");
        }


        highRiskButton = findViewById(R.id.high_risk_button);

        String finalAddiction = addiction;

        highRiskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set local started time to sharedpreferences
                long startedLocalTime;
                MainTimePage mainTimePage = new MainTimePage();
                startedLocalTime = mainTimePage.currentTimeInSec();

                SharedPreferences sharedPreferences = getSharedPreferences("startTime", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("start", String.valueOf(startedLocalTime));
                editor.putInt("days", 0);
                editor.putString("addiction", finalAddiction);
                editor.commit();


                Intent intent = new Intent(RiskWarning.this, MainTimePage.class);
                startActivity(intent);
                finish();
            }
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
}