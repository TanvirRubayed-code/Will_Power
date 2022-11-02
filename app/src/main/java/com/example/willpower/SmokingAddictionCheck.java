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

public class SmokingAddictionCheck<set> extends AppCompatActivity {

    RadioButton smokingAddict1,smokingAddict2,smokingAddict3,smokingAddict4,smokingAddict5,smokingAddict6,smokingNotAddict1,
            smokingNotAddict2,smokingNotAddict3,smokingNotAddict4,smokingNotAddict5,smokingNotAddict6 ;
    Button smokingAddictSubmit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoking_addiction_check);

        smokingAddict1 = findViewById(R.id.smoking_addict1);
        smokingAddict2 = findViewById(R.id.smoking_addict2);
        smokingAddict3 = findViewById(R.id.smoking_addict3);
        smokingAddict4 = findViewById(R.id.smoking_addict4);
        smokingAddict5 = findViewById(R.id.smoking_addict5);
        smokingAddict6 = findViewById(R.id.smoking_addict6);
        smokingNotAddict1 = findViewById(R.id.smoking_not_addict1);
        smokingNotAddict2 = findViewById(R.id.smoking_not_addict2);
        smokingNotAddict3 = findViewById(R.id.smoking_not_addict3);
        smokingNotAddict4 = findViewById(R.id.smoking_not_addict4);
        smokingNotAddict5 = findViewById(R.id.smoking_not_addict5);
        smokingNotAddict6 = findViewById(R.id.smoking_not_addict6);

        smokingAddictSubmit = findViewById(R.id.smoking_addict_submit);

        smokingAddictSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int smokingAddict=0 , smokingNotAddict =0 ;

                if(smokingAddict1.isChecked()){
                    smokingAddict++;
                }if(smokingAddict2.isChecked()){
                    smokingAddict++;
                }if(smokingAddict3.isChecked()){
                    smokingAddict++;
                }if(smokingAddict4.isChecked()){
                    smokingAddict++;
                }if(smokingAddict5.isChecked()){
                    smokingAddict++;
                }if(smokingAddict6.isChecked()){
                    smokingAddict++;
                }

                if(smokingNotAddict1.isChecked()){
                    smokingNotAddict++;
                }if(smokingNotAddict2.isChecked()){
                    smokingNotAddict++;
                }if(smokingNotAddict3.isChecked()){
                    smokingNotAddict++;
                }if(smokingNotAddict4.isChecked()){
                    smokingNotAddict++;
                }if(smokingNotAddict5.isChecked()){
                    smokingNotAddict++;
                }if(smokingNotAddict6.isChecked()){
                    smokingNotAddict++;
                }

                if((smokingAddict+smokingNotAddict)<6){
                    Toast.makeText(getApplicationContext(),"Select all the options",Toast.LENGTH_SHORT).show();
                }else {
                    if(smokingAddict>=3){
                        Intent intent = new Intent(SmokingAddictionCheck.this, MainTimePage.class);
                        startActivity(intent);

                    }
                    else {
                        Intent intent = new Intent(SmokingAddictionCheck.this, GameAddCongrats.class);
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