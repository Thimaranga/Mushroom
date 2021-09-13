package com.example.mushroomapp.disease;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class DiseaseDetectionDashboard extends AppCompatActivity {

    ImageButton btnHom;

    ImageButton btnAddNew;

    ImageButton btnRefresh;

    String[] diseaseList = new String[]{"Mite Attack","Thali Makka Attack","Green Mould","Neurospora","Black Mould",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_detection_dashboard);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnHom = findViewById(R.id.btnHTDHistoryHome);

        btnAddNew = findViewById(R.id.btnDDNew);

        btnRefresh = findViewById(R.id.btnHTDHistoryBack);

        setDisBtn();

        btnHom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DDCapturing.class);
                startActivity(i);
            }
        });

    }


    private void setDisBtn() {

        //create disease button according to array size
        for (String s : diseaseList) {
            LinearLayout layout = findViewById(R.id.rootLayout);
            Button newBtn = new Button(this);
            newBtn.setText(s);

            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 76, getResources().getDisplayMetrics());
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);


            params.setMargins(0, 30, 0, 0);


            newBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.animatedmushroom, 0, 0, 0);

            newBtn.setBackgroundColor(0xFF76A35D);

            layout.addView(newBtn,params);

            //for debuging
            String test = String.valueOf(newBtn);
            Log.wtf("hello", test);
        }


    }

}