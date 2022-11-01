package com.example.willpower;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ThemedSpinnerAdapter;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private  int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progress);


        Thread thread = new Thread(){
            public void  run(){
                try {
                    for (progress = 1;progress<=100;progress+=1) {
                        sleep(10);
                        progressBar.setProgress(progress);
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


    }
}