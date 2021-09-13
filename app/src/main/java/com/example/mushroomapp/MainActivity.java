package com.example.mushroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.mushroomapp.harvesting.HTDDashboard;
import com.example.mushroomapp.yield.YPDashboard;
import com.example.mushroomapp.yield.YPSplash;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), LanguageScreen.class);
                startActivity(i);
            }
        },5000);

    }

}