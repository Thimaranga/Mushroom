package com.example.mushroomapp.harvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mushroomapp.R;
import com.example.mushroomapp.environmental.EMSDashboard;

public class HTDSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htdsplash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), HTDDashboard.class);
                startActivity(i);
            }
        },4000);


    }
}