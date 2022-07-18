package com.example.willpower;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SetPIN extends AppCompatActivity {


    EditText editText;
    Button unlock;

    final String PIN_key = "pin";
    final String PREF_NAME = "mypref";
    SharedPreferences sharedPreferences ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.passCheck);
        unlock = findViewById(R.id.unlockButton);

        unlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String submittedPIN = editText.getText().toString();


                sharedPreferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
                String setPIN = sharedPreferences.getString(PIN_key,null);



                if(submittedPIN == setPIN){
                    Toast.makeText(SetPIN.this, submittedPIN,Toast.LENGTH_SHORT ).show();
                }


                else {
                    Intent intent = new Intent(SetPIN.this, QueryActivity.class);
                    startActivity(intent);
                }

            }
        });

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
}