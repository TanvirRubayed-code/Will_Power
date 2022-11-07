package com.example.willpower;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SelectedAddictionDetails extends AppCompatActivity {
    TextView addictionName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_addiction_details);

        addictionName = findViewById(R.id.selected_addiction);

        SharedPreferences sharedPreferences = getSharedPreferences("startTime",MODE_PRIVATE);
        String addiction = sharedPreferences.getString("addiction","");

        addictionName.setText(addiction);


        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Selected addiction");
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