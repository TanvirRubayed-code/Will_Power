package com.example.willpower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class PsychiatristInfo extends AppCompatActivity implements View.OnClickListener {

    ImageButton psyCall1, psyCall2,psyCall3,psyCall4,psyCall5,psyCall6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychiatrist_info);

        psyCall1 = findViewById(R.id.psy_call1);
        psyCall2 = findViewById(R.id.psy_call2);
        psyCall3 = findViewById(R.id.psy_call3);
        psyCall4 = findViewById(R.id.psy_call4);
        psyCall5 = findViewById(R.id.psy_call5);
        psyCall6 = findViewById(R.id.psy_call6);



        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Psychiatrist contacts");
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

        psyCall1.setOnClickListener(this);
        psyCall2.setOnClickListener(this);
        psyCall3.setOnClickListener(this);
        psyCall4.setOnClickListener(this);
        psyCall5.setOnClickListener(this);
        psyCall6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.psy_call1){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+8801611216232"));
            startActivity(intent);
        }
        else if(view.getId()==R.id.psy_call2){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:10606"));
            startActivity(intent);
        } else if(view.getId()==R.id.psy_call3){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+8809610010615"));
            startActivity(intent);
        } else if(view.getId()==R.id.psy_call4){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+8809613787801"));
            startActivity(intent);
        } else if(view.getId()==R.id.psy_call5){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:10616"));
            startActivity(intent);
        } else if(view.getId()==R.id.psy_call6){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+8809613787803"));
            startActivity(intent);
        }
    }
}