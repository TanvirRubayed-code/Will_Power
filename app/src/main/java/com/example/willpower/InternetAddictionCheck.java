package com.example.willpower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class InternetAddictionCheck extends AppCompatActivity {

    RadioButton internetAddict1,internetAddict2,internetAddict3,
            internetAddict4,internetAddict5,internetAddict6,internetAddict7,internetAddict8, internetNotAddict1,
            internetNotAddict2,internetNotAddict3,internetNotAddict4,internetNotAddict5,internetNotAddict6,
            internetNotAddict7,internetNotAddict8;
    Button internetAddictcheck ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_addiction_check);


        internetAddict1 = findViewById(R.id.int_addict1);
        internetAddict2 = findViewById(R.id.int_addict2);
        internetAddict3 = findViewById(R.id.int_addict3);
        internetAddict4 = findViewById(R.id.int_addict4);
        internetAddict5 = findViewById(R.id.int_addict5);
        internetAddict6 = findViewById(R.id.int_addict6);
        internetAddict7 = findViewById(R.id.int_addict7);
        internetAddict8 = findViewById(R.id.int_addict8);
        internetNotAddict1 = findViewById(R.id.int_not_addict1);
        internetNotAddict2 = findViewById(R.id.int_not_addict2);
        internetNotAddict3 = findViewById(R.id.int_not_addict3);
        internetNotAddict4 = findViewById(R.id.int_not_addict4);
        internetNotAddict5 = findViewById(R.id.int_not_addict5);
        internetNotAddict6 = findViewById(R.id.int_not_addict6);
        internetNotAddict7 = findViewById(R.id.int_not_addict7);
        internetNotAddict8 = findViewById(R.id.int_not_addict8);

        internetAddictcheck = findViewById(R.id.internet_addict_check);

        internetAddictcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int internetAddicted=0 , internetNotAddicted =0 ;

                if(internetAddict1.isChecked()){
                    internetAddicted++;
                } if(internetAddict2.isChecked()){
                    internetAddicted++;
                }if(internetAddict3.isChecked()){
                    internetAddicted++;
                }if(internetAddict4.isChecked()){
                    internetAddicted++;
                }if(internetAddict5.isChecked()){
                    internetAddicted++;
                }if(internetAddict6.isChecked()){
                    internetAddicted++;
                }if(internetAddict7.isChecked()){
                    internetAddicted++;
                }if(internetAddict8.isChecked()){
                    internetAddicted++;
                }

                if(internetNotAddict1.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict2.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict3.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict4.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict5.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict6.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict7.isChecked()){
                    internetNotAddicted++;
                }if(internetNotAddict8.isChecked()){
                    internetNotAddicted++;
                }

                if((internetAddicted+internetNotAddicted)<8){
                    Toast.makeText(getApplicationContext(),"Select all the options",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(internetAddicted>4){
                        Intent intent = new Intent(InternetAddictionCheck.this, RiskWarning.class);
                        intent.putExtra("addiction","Internet");
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Intent intent = new Intent(InternetAddictionCheck.this, GameAddCongrats.class);
                        intent.putExtra("addiction","Internet");
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });


        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Some Queries for you");
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#3b5998"));
        actionBar.setBackgroundDrawable(colorDrawable);


        //change status bar color
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.questionStatusBar));
        }
    }
}