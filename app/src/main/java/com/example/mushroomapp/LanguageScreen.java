package com.example.mushroomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LanguageScreen extends AppCompatActivity {

    ImageButton btnEnglish;
    ImageButton btnSinhala;
    ImageButton btnTamil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnEnglish = findViewById(R.id.btnEnglish);
        btnSinhala = findViewById(R.id.btnSinhala);
        btnTamil = findViewById(R.id.btnTamil);

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),IntroActivity.class);
                startActivity(i);
            }
        });
    }
}