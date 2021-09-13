package com.example.mushroomapp.environmental;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;


public class EMSSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_m_s_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), EMSDashboard.class);
                startActivity(i);
            }
        },4000);
    }
}