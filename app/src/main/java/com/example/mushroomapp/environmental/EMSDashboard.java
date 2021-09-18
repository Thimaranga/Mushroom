package com.example.mushroomapp.environmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.example.mushroomapp.models.EMSData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EMSDashboard extends AppCompatActivity {

    ProgressBar barTemp;
    ProgressBar barHumidity;
    ProgressBar barCo2;

    TextView txtTemp;
    TextView txtHumidity;
    TextView txtCo2;

    ImageButton button;
    ImageButton btnGraph;
    ImageButton btnRefresh;

    double incomingTemp = 88.5;
    int setTemp = (int) incomingTemp;

    double incomingHumidity = 60.8;
    int setHumidity = (int) incomingHumidity;

    double incomingCo2 = 25.5;
    int setCo2= (int) incomingCo2;

    int temp1,hum1,co21;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_m_s_dashboard);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        barTemp = findViewById(R.id.proBarTemp);
        barHumidity = findViewById(R.id.proBarHumidity);
        barCo2 = findViewById(R.id.proBarCo2);

        txtTemp = findViewById(R.id.txtTemp);
        txtHumidity = findViewById(R.id.txtHumidity);
        txtCo2 = findViewById(R.id.txtCo2);

        button=findViewById(R.id.btnYPHome);
        btnGraph=findViewById(R.id.btnEMSHistoryGraph);
        btnRefresh=findViewById(R.id.btnHTDHistoryBack);

        db = FirebaseDatabase.getInstance().getReference().child("SensorData");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                insertData();
                startActivity(i);
            }
        });
        btnGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EMSGraph.class);
                insertData();
                startActivity(i);
            }
        });
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startProgressTemp();
                startProgressHumidity();
                startProgressCo2();
            }
        });
        thread.start();
    }
    public void startProgressTemp(){
        try {
            Thread.sleep(50);
            barTemp.setProgress(setTemp);
            txtTemp.setText(incomingTemp +" "+ (char) 0x00B0+"C");
            temp1=setTemp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void startProgressHumidity(){
        try {
            Thread.sleep(50);
            barHumidity.setProgress(setHumidity);
            txtHumidity.setText(incomingHumidity +" "+ (char) 0x0025);
            hum1=setHumidity;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void startProgressCo2(){
        try {
            Thread.sleep(50);
            barCo2.setProgress(setCo2);
            txtCo2.setText(incomingCo2 +" PPM");
            co21=setCo2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void insertData() {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdfDate.format(new Date());

        SimpleDateFormat sdtTime = new SimpleDateFormat("h:mm a");
        String currentTime = sdtTime.format(new Date());

        String inputTemp=String.valueOf(temp1);
        String inputHum=String.valueOf(hum1);
        String inputCo2=String.valueOf(co21);

        EMSData emsData = new EMSData(inputTemp,inputHum,inputCo2,currentDate,currentTime);

        db.push().setValue(emsData);
        Toast.makeText(getApplicationContext(),"Data Inserted!",Toast.LENGTH_SHORT).show();
    }
}