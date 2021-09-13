package com.example.mushroomapp.yield;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class YPRecommendation extends AppCompatActivity {

    TextView txtYield;
    TextView txtRecommand;

    ImageButton btnNew;
    ImageButton btnHome;

    String pushStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yprecommendation);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        txtYield = findViewById(R.id.txtYieldVal);
        txtRecommand=findViewById(R.id.txtRecommendField);
        btnNew=findViewById(R.id.btnYPNew);
        btnHome=findViewById(R.id.btnHTDHistoryHome);

        Bundle bdl = getIntent().getExtras();
        String yieldValue = bdl.getString("data");

        //this yield value recieved from previous screen
        int val = Integer.parseInt(yieldValue);
        val=(val/5)*30;

        String forSet = String.valueOf(val);
        txtYield.setText(forSet);

        if(yieldValue!=null){
            if(val>400){
               txtRecommand.setText("Most Suitable data value for mushroom farming");
            }
            else if(val>=250){
                txtRecommand.setText("Average data values for mushroom farming");
            }
            else if(val<250){
                txtRecommand.setText("Theses values are not suitable for mushroom farming");
            }
        }

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushStr="New";
                //put selected vale and start new activity
                Intent mIntent = new Intent(getApplicationContext(), YPDashboard.class);
                mIntent.putExtra("data", pushStr);
                startActivity(mIntent);

            }
        });
    }
}