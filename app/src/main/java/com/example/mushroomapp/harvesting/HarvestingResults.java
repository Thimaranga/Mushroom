package com.example.mushroomapp.harvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class HarvestingResults extends AppCompatActivity {

    ImageView getResult;
    ImageButton btnHistory;
    ImageButton btnHome;

    Uri imgRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvesting_results);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        getResult = findViewById(R.id.imgResult);
        btnHistory = findViewById(R.id.btnHTDHistory);
        btnHome = findViewById(R.id.btnHTDHistoryHome);

        imgRes = getIntent().getExtras().getParcelable("data");
        getResult.setImageURI(imgRes);

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),HTDHistory.class);
                startActivity(i);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });

    }
}