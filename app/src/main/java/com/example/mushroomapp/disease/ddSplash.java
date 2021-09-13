package com.example.mushroomapp.disease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mushroomapp.R;
import com.example.mushroomapp.environmental.EMSDashboard;

public class ddSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dd_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), DiseaseDetectionDashboard.class);
                startActivity(i);
            }
        },4000);
    }
}