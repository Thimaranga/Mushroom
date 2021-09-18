package com.example.mushroomapp.yield;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class YPDashboard extends AppCompatActivity {

    Spinner tempSpinner;
    Spinner humSpinner;
    Spinner co2Spinner;
    Spinner diseasedSpinner;
    Spinner harvesSpinner;
    Spinner yieldSpinner;

    ImageButton btnNext;
    ImageButton btnHome;

    String itemStr;
    String itemTemp;
    String itemHum;
    String itemCo2;
    String itemDisease;
    String itemHarvest;



    String temp1 = 20 +" "+ (char) 0x00B0+"C";
    String temp2 = 40 +" "+ (char) 0x00B0+"C";
    String temp3 = 60 +" "+ (char) 0x00B0+"C";
    String temp4 = 80 +" "+ (char) 0x00B0+"C";
    String temp5 = 100 +" "+ (char) 0x00B0+"C";

    String hum1 = 20+" "+ (char) 0x0025;
    String hum2 = 40+" "+ (char) 0x0025;
    String hum3 = 40+" "+ (char) 0x0025;
    String hum4 = 40+" "+ (char) 0x0025;
    String hum5 = 100+" "+ (char) 0x0025;

    String co2_1 = 1000 + " ppm";
    String co2_2 = 2000 + " ppm";
    String co2_3 = 3500 + " ppm";
    String co2_4 = 2500 + " ppm";
    String co2_5 = 5000 + " ppm";

    String yield1 = 200 + " Kg";
    String yield2 = 240 + " Kg";
    String yield3 = 150 + " Kg";
    String yield4 = 320 + " Kg";
    String yield5 = 540 + " Kg";


    //create a list of items for 6 spinners.
    // Insert real values here
    String[] tempItems = new String[]{"Average Temperature "+ (char) 0x00B0+"C","20","40","60","80","100"};
    String[] humItems = new String[]{"Average Humidity  "+ (char) 0x0025,"20","40","60","80","100"};
    String[] co2Items = new String[]{"Average CO2 level  "+ "ppm","450","500","1500","3000","2000"};
    String[] diseasedItems = new String[]{"Diseased Average","Yes","No"};
    String[] havesItems = new String[]{"Right Harvesting Time Average","Yes","No"};
    String[] yieldItems = new String[]{"Yield per day (Kg)","100","200","300","400","500"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypdashboard);

        String mytest = "Hello World";

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        tempSpinner = findViewById(R.id.spinnerTemp);
        humSpinner = findViewById(R.id.spinnerHumidity);
        co2Spinner = findViewById(R.id.spinnerCo2);
        diseasedSpinner = findViewById(R.id.spinnerDisease);
        harvesSpinner = findViewById(R.id.spinnerHarvest);
        yieldSpinner = findViewById(R.id.spinnerYield);

        btnNext = findViewById(R.id.btnYPNew);
        btnHome = findViewById(R.id.btnYPHome);

        setDataSpinners();

        getDataSpinners();

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });




    }
    private void setDataSpinners(){

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterTemp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tempItems);
        ArrayAdapter<String> adapterHum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, humItems);
        ArrayAdapter<String> adapterCo2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, co2Items);
        ArrayAdapter<String> adapterDisease = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, diseasedItems);
        ArrayAdapter<String> adapterHarves = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, havesItems);
        ArrayAdapter<String> adapterYield = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, yieldItems);

        //set the spinners adapter to the previously created one.
        tempSpinner.setAdapter(adapterTemp);
        humSpinner.setAdapter(adapterHum);
        co2Spinner.setAdapter(adapterCo2);
        diseasedSpinner.setAdapter(adapterDisease);
        harvesSpinner.setAdapter(adapterHarves);
        yieldSpinner.setAdapter(adapterYield);
    }

    private void getDataSpinners(){

        //get selected value here (spinner selected value)
//        itemStr = yieldSpinner.getSelectedItem().toString();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(yieldSpinner.getSelectedItem().toString() != "Yield per day (Kg)") {

                    if(tempSpinner.getSelectedItem().toString() != "Average Temperature "+ (char) 0x00B0+"C")
                    {
                        itemTemp = tempSpinner.getSelectedItem().toString();
                    }
                    if(humSpinner.getSelectedItem().toString() != "Average Humidity  "+ (char) 0x0025){
                        itemHum = humSpinner.getSelectedItem().toString();
                    }
                    if(co2Spinner.getSelectedItem().toString() != "Average CO2 level  "+ "ppm"){
                        itemCo2 = co2Spinner.getSelectedItem().toString();
                    }
                    if(diseasedSpinner.getSelectedItem().toString() != "Diseased Average"){
                        itemDisease = diseasedSpinner.getSelectedItem().toString();
                    }
                    if(harvesSpinner.getSelectedItem().toString() != "Right Harvesting Time Average"){
                        itemHarvest = harvesSpinner.getSelectedItem().toString();
                    }

                    itemStr = yieldSpinner.getSelectedItem().toString();

                    if(itemTemp != null && itemHum != null && itemDisease != null && itemHarvest != null){

                        //put selected vale and start new activity
                        Intent mIntent = new Intent(YPDashboard.this, YPRecommendation.class);
                        mIntent.putExtra("data", itemStr);
                        startActivity(mIntent);

                    }else{
                        Toast.makeText(getApplicationContext(),"Please select values",Toast.LENGTH_SHORT).show();
                    }

                }else{

                    Toast.makeText(getApplicationContext(),"Please select values",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}