package com.example.willpower;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainTimePage extends AppCompatActivity {

    ProgressBar timerProgressBar, daysProgressBar;
    TextView dayTimeCoundown, daysCoundown, demoTextview;


    long startedLocalTime;
    int level;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_page);


        daysCoundown = findViewById(R.id.days_countdown_timer);
        dayTimeCoundown = findViewById(R.id.time_coundown);
        timerProgressBar = findViewById(R.id.timer_progress_id);
        daysProgressBar = findViewById(R.id.days_progress_id);
        demoTextview = findViewById(R.id.demoTextviewid);

        SharedPreferences sharedPreferences = getSharedPreferences("startTime", MODE_PRIVATE);

        // stored start time fetched from storage
        if (sharedPreferences.contains("start")) {
            String Strtime = sharedPreferences.getString("start", "");
            startedLocalTime = Long.parseLong(Strtime);
        }


        // timer start to show the watch countdown
        Timer timer = new Timer();
        timerProgressBar.setMax(24 * 60 * 60);
        daysProgressBar.setMax( 21 * 24 * 60 * 60);


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long newTime = currentTimeInSec() ;

                if(newTime-startedLocalTime<0){
                    newTime = startedLocalTime + (86400-startedLocalTime) + newTime;
                }

                if(newTime-startedLocalTime==86399){
                    SharedPreferences sharedPreferences = getSharedPreferences("startTime",MODE_PRIVATE);
                    int day = sharedPreferences.getInt("days",0);
                    day++;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("days",day);
                    editor.commit();
                }

                // second minute hour calculation
                long second = ((newTime - startedLocalTime)) % (60);
                String secondStr = String.valueOf(second);
                if (secondStr.length() < 2) {
                    secondStr = '0' + secondStr;
                }

                long minute = (((newTime - startedLocalTime) / 60) % (60));
                String minuteStr = String.valueOf(minute);
                if (minuteStr.length() < 2) {
                    minuteStr = '0' + minuteStr;
                }

                long hour = ((newTime - startedLocalTime) / ( 60 * 60)) % 24;
                String hourStr = String.valueOf(hour);
                if (hourStr.length() < 2) {
                    hourStr = '0' + hourStr;
                }

                onTick(secondStr, minuteStr, hourStr, newTime);

                // set hour progress bar
                int timeToProgress = (int) (second + (minute * 60) + (hour * 60 * 60));
                timerProgressBar.setProgress(timeToProgress);

                // calculate days progress bar percentage using
                SharedPreferences sharedPreferences = getSharedPreferences("startTime",MODE_PRIVATE);
                int day = sharedPreferences.getInt("days",0);
                daysProgressBar.setProgress((int) ((day * 24 * 60 * 60 ) + (newTime - startedLocalTime)));
            }
        }, 1000, 1000);


        SharedPreferences sp = getSharedPreferences("glevel",MODE_PRIVATE);
        if (sp.contains("level")) {
            level = sp.getInt("level",0);
            level++;
        }



        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Your level: " + level);
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
            }


        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public long currentTimeInSec() {
        Calendar rightNow = Calendar.getInstance();
        long offset = rightNow.get(Calendar.ZONE_OFFSET) + rightNow.get(Calendar.DST_OFFSET);
        long msSinceMidnight = (rightNow.getTimeInMillis() + offset) % (24 * 60 * 60 * 1000);
        return msSinceMidnight / 1000;
    }


    private void onTick(String seconds, String minute, String hour, long t) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String time = hour + ":" + minute + ":" + seconds;
                dayTimeCoundown.setText(time);
                demoTextview.setText(String.valueOf(t-startedLocalTime));

                // handle days counter
                SharedPreferences sharedPreferences = getSharedPreferences("startTime",MODE_PRIVATE);
                int days = sharedPreferences.getInt("days",0);
                int remains = 21-days;
                String dayStr = String.valueOf(remains);
                daysCoundown.setText(""+dayStr+" days left");
            }
        });
    }


    // Option Menu ____________________
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.meny_items, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settingsId) {
            Toast.makeText(this, "Setting menu", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.psychiatristAboutId) {
            Intent intent = new Intent(MainTimePage.this, PsychiatristInfo.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.aboutUsID) {
            Toast.makeText(this, "About us menu", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.otherAddiction) {

            //update level when cancel
            SharedPreferences sp = getSharedPreferences("glevel",MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();

            int level = sp.getInt("level",0);
            level--;

            edit.putInt("level",level);
            edit.commit();


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Do you want to change this addiction?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {

                    SharedPreferences preferences = getSharedPreferences("startTime", MODE_PRIVATE);
                    preferences.edit().clear().commit();

                    Intent intent = new Intent(MainTimePage.this, QueryActivity.class);
                    startActivity(intent);

                }


            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    //if user select "No", just cancel this dialog and continue with app
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();


            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}