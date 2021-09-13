package com.example.mushroomapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mushroomapp.disease.ddSplash;
import com.example.mushroomapp.environmental.EMSSplash;
import com.example.mushroomapp.harvesting.HTDSplash;
import com.example.mushroomapp.yield.YPSplash;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
                Intent i = new Intent(getApplicationContext(), YPSplash.class);
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


        //Initializing cloud firestore
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //Create new map object to send data to the db
        Map<String, Object> user = new HashMap<>();

        //Add data to this map
        user.put("first","Thushal");
        user.put("last", "Himaranga");
        user.put("district", "Kaluthara");

        //add new doc with auto generated id in firestore
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.wtf("Check","Successfully uploaded");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.wtf("CheckError","Upload failed");
                    }
                });
    }
}