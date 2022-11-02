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
import android.widget.RadioGroup;
import android.widget.Toast;

public class GameAddictionCheck extends AppCompatActivity {

    RadioButton Rd1,Rd2,Rd3,Rd4,Rd5,Rd6,Rd7,Rd8,RdNO1,RdNO2,RdNO3,RdNO4,RdNO5,RdNO6,RdNO7,RdNO8;
    Button gameQuerySubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_addiction_check);

        Rd1 = findViewById(R.id.gameRd1);
        Rd2 = findViewById(R.id.gameRd2);
        Rd3 = findViewById(R.id.gameRd3);
        Rd4 = findViewById(R.id.gameRd4);
        Rd5 = findViewById(R.id.gameRd5);
        Rd6 = findViewById(R.id.gameRd6);
        Rd7 = findViewById(R.id.gameRd7);
        Rd8 = findViewById(R.id.gameRd8);
        RdNO1 = findViewById(R.id.notSelect1);
        RdNO2 = findViewById(R.id.notSelect2);
        RdNO3 = findViewById(R.id.notSelect3);
        RdNO4 = findViewById(R.id.notSelect4);
        RdNO5 = findViewById(R.id.notSelect5);
        RdNO6 = findViewById(R.id.notSelect6);
        RdNO7 = findViewById(R.id.notSelect7);
        RdNO8 = findViewById(R.id.notSelect8);

        gameQuerySubmit = findViewById(R.id.gameQuerySubmit);



        gameQuerySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int counterGameAddict=0 , selectedNo =0 ;

                if(Rd1.isChecked()){
                    counterGameAddict++;
                }if(Rd2.isChecked()){
                    counterGameAddict++;
                }if(Rd3.isChecked()){
                    counterGameAddict++;
                }if(Rd4.isChecked()){
                    counterGameAddict++;
                }if(Rd5.isChecked()){
                    counterGameAddict++;
                }if(Rd6.isChecked()){
                    counterGameAddict++;
                }if(Rd7.isChecked()){
                    counterGameAddict++;
                }if(Rd8.isChecked()){
                    counterGameAddict++;
                }
                //select No
                if(RdNO1.isChecked()){
                    selectedNo++;
                }if(RdNO2.isChecked()){
                    selectedNo++;
                }if(RdNO3.isChecked()){
                    selectedNo++;
                }if(RdNO4.isChecked()){
                    selectedNo++;
                }if(RdNO5.isChecked()){
                    selectedNo++;
                }if(RdNO6.isChecked()){
                    selectedNo++;
                }if(RdNO7.isChecked()){
                    selectedNo++;
                }if(RdNO8.isChecked()){
                    selectedNo++;
                }
                if((counterGameAddict+selectedNo)<8){
                    Toast.makeText(getApplicationContext(),"Select all the options",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(counterGameAddict>4){
                        Intent intent = new Intent(GameAddictionCheck.this, MainTimePage.class);
                        startActivity(intent);

                    }
                    else {
                        Intent intent = new Intent(GameAddictionCheck.this, GameAddCongrats.class);
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