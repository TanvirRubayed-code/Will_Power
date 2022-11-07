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

public class PornAddictionCheck extends AppCompatActivity {

    RadioButton pornAddict1,pornAddict2,pornAddict3,pornAddict4,pornAddict5,pornAddict6,pornAddict7,pornAddict8,pornAddict9,
    pornNotAddict1,pornNotAddict2,pornNotAddict3,pornNotAddict4,pornNotAddict5,pornNotAddict6,pornNotAddict7,pornNotAddict8
            ,pornNotAddict9 ;

    Button pornAddictSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porn_addiction_check);

        pornAddict1 = findViewById(R.id.porn_addict1);
        pornAddict2 = findViewById(R.id.porn_addict2);
        pornAddict3 = findViewById(R.id.porn_addict3);
        pornAddict4 = findViewById(R.id.porn_addict4);
        pornAddict5 = findViewById(R.id.porn_addict5);
        pornAddict6 = findViewById(R.id.porn_addict6);
        pornAddict7= findViewById(R.id.porn_addict7);
        pornAddict8 = findViewById(R.id.porn_addict8);
        pornAddict9 = findViewById(R.id.porn_addict9);
        pornNotAddict1 = findViewById(R.id.porn_not_addict1);
        pornNotAddict2 = findViewById(R.id.porn_not_addict2);
        pornNotAddict3 = findViewById(R.id.porn_not_addict3);
        pornNotAddict4 = findViewById(R.id.porn_not_addict4);
        pornNotAddict5 = findViewById(R.id.porn_not_addict5);
        pornNotAddict6 = findViewById(R.id.porn_not_addict6);
        pornNotAddict7 = findViewById(R.id.porn_not_addict7);
        pornNotAddict8 = findViewById(R.id.porn_not_addict8);
        pornNotAddict9 = findViewById(R.id.porn_not_addict9);

        pornAddictSubmit = findViewById(R.id.porn_addict_submit);

        pornAddictSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pornAddicted=0 , pornNotAddicted =0 ;

                if(pornAddict1.isChecked()){
                    pornAddicted++;
                }if(pornAddict2.isChecked()){
                    pornAddicted++;
                }if(pornAddict3.isChecked()){
                    pornAddicted++;
                }if(pornAddict4.isChecked()){
                    pornAddicted++;
                }if(pornAddict5.isChecked()){
                    pornAddicted++;
                }if(pornAddict6.isChecked()){
                    pornAddicted++;
                }if(pornAddict7.isChecked()){
                    pornAddicted++;
                }if(pornAddict8.isChecked()){
                    pornAddicted++;
                }if(pornAddict9.isChecked()){
                    pornAddicted++;
                }

                if(pornNotAddict1.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict2.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict3.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict4.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict5.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict6.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict7.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict8.isChecked()){
                    pornNotAddicted++;
                }if(pornNotAddict9.isChecked()){
                    pornNotAddicted++;
                }

                if((pornAddicted+pornNotAddicted)<9){
                    Toast.makeText(getApplicationContext(),"Select all the options",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pornAddicted>5){
                        Intent intent = new Intent(PornAddictionCheck.this, RiskWarning.class);
                        intent.putExtra("addiction","Porn");
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Intent intent = new Intent(PornAddictionCheck.this, GameAddCongrats.class);
                        intent.putExtra("addiction","Porn");
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