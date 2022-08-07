package com.example.willpower;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences ;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pin);


        final String PREF_NAME = "mypref";
        final String PIN_key = "pin";


        final Button pinButton = findViewById(R.id.pin);
        final EditText editText = findViewById(R.id.pinEditText);


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);


        String setPIN = sharedPreferences.getString(PIN_key,null);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(setPIN != null ){
            Intent intent = new Intent(MainActivity.this, SetPIN.class);
            startActivity(intent);
        }

        pinButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String pinString = editText.getText().toString();

                if(pinString.length()>4){

                    editor.putString(PIN_key,pinString);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, SetPIN.class);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "PIN created successfully",Toast.LENGTH_SHORT ).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Set a PIN more than 4 numbers",Toast.LENGTH_SHORT ).show();
                }



            }
        });
//button style




//        button style end




        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }



}