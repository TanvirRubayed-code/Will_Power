package com.example.willpower;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity implements View.OnClickListener {


    ActionBar actionBar;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button habitSelectButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        checkBox1 = findViewById(R.id.check1);
        checkBox2 = findViewById(R.id.check2);
        checkBox3 = findViewById(R.id.check3);
        checkBox4 = findViewById(R.id.check4);
        habitSelectButton = findViewById(R.id.habitSelectButton);

        habitSelectButton.setOnClickListener(this);




        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
//                finish();
                finishAffinity();
                System.exit(0);
            }


        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.habitSelectButton){
            saveSelectedHabit();
        }

    }

    private void saveSelectedHabit() {
        boolean game =  checkBox1.isChecked();
        boolean smoking =  checkBox2.isChecked();
        boolean porn =  checkBox3.isChecked();
        boolean internet =  checkBox4.isChecked();


        SharedPreferences sharedPref = getSharedPreferences("saveHabit", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("gameAddiction",game);
        editor.putBoolean("smoking",smoking);
        editor.putBoolean("pornAddiction",porn);
        editor.putBoolean("internetAddiction",internet);
        editor.commit();

        Intent intent = new Intent(QueryActivity.this, HabitsQuery.class);
        startActivity(intent);


    }


}