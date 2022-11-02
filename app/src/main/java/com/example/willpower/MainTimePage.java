package com.example.willpower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainTimePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_time_page);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.meny_items,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.settingsId){
            Toast.makeText(this, "Setting menu", Toast.LENGTH_SHORT).show();
            return true;
        }   if(item.getItemId()==R.id.psychiatristAboutId){
            Intent intent = new Intent(MainTimePage.this, PsychiatristInfo.class);
            startActivity(intent);
            return true;
        }   if(item.getItemId()==R.id.aboutUsID){
            Toast.makeText(this, "About us menu", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}