package com.example.mushroomapp.harvesting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.example.mushroomapp.models.HTDData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HarvestingResults extends AppCompatActivity {

    ImageView getResult;

    ImageButton btnHistory;
    ImageButton btnHome;

    TextView timeHTD,dateHTD,recommendHTD;

    //set prediction values here
    String harvestTime= "Harvest Past 02 Days";
    String expDate;
    boolean status = true;

    Uri imgRes;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvesting_results);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        db = FirebaseDatabase.getInstance().getReference().child("HarvestDetails");

        getResult = findViewById(R.id.imgResult);

        btnHistory = findViewById(R.id.btnHTDHistory);
        btnHome = findViewById(R.id.btnYPHome);

        timeHTD = findViewById(R.id.txtHTDTime);
        dateHTD = findViewById(R.id.txtHTDDate);
        recommendHTD = findViewById(R.id.txtHTDRecommend);


        imgRes = getIntent().getExtras().getParcelable("data");
        getResult.setImageURI(imgRes);

        timeHTD.setText("Hello");
        recommendHTD.setText("This is a dummy for testing");

        if(harvestTime.equals("Harvest in 10 Hours")){
            expDate="3 days (lesser productivity)";
            dateHTD.setText(expDate);
        }
        else if(harvestTime.equals("Harvest in 5 Hours")){
            expDate="3 days (lesser productivity)";
            dateHTD.setText(expDate);
        }
        else if(harvestTime.equals("Harvest Now")){
            expDate="2 days";
            dateHTD.setText(expDate);
        }
        else if(harvestTime.equals("Harvest Past 01 Day")){
            expDate="1 day";
            dateHTD.setText(expDate);
        }
        else if(harvestTime.equals("Harvest Past 02 Days")){
            expDate="Not suitable for consumption";
            dateHTD.setText(expDate);
        }

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
        insertData();

    }
    private void insertData() {

        String imageDetail = String.valueOf(imgRes);
        String hTime = harvestTime;
        String expiryDate=expDate;
        String hStatus;
        if(status){
            hStatus = "Harvested";
        }
        else{
            hStatus = "Not Harvested";
        }



        HTDData htdData = new HTDData(imageDetail,hTime,expiryDate,hStatus);

        db.push().setValue(htdData);
        Toast.makeText(getApplicationContext(),"Data Inserted!",Toast.LENGTH_SHORT).show();
    }
}