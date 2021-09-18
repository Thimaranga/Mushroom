package com.example.mushroomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.disease.ddSplash;
import com.example.mushroomapp.environmental.EMSSplash;
import com.example.mushroomapp.harvesting.HTDSplash;
import com.example.mushroomapp.yield.YPSplash;

public class IntroActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        button = findViewById(R.id.btnEMS);
        button2 = findViewById(R.id.btnYD);
        button3 = findViewById(R.id.btnDD);
        button4 = findViewById(R.id.btnHTD);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EMSSplash.class);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),YPSplash.class);
                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ddSplash.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HTDSplash.class);
                startActivity(i);
            }
        });

    }
}