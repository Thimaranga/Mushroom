package com.example.mushroomapp.yield;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class YPDashboard extends AppCompatActivity {

    ImageButton btnTemp;
    ImageButton btnHum;
    ImageButton btnCo2;
    ImageButton btnDisease;
    ImageButton btnHarvest;
    ImageButton btnYield;

    ImageButton btnNext;
    ImageButton btnHome;

//    String itemStr;
//    String itemTemp;
//    String itemHum;
//    String itemCo2;
//    String itemDisease;
//    String itemHarvest;
//
//    String temp1 = 20 +" "+ (char) 0x00B0+"C";
//    String temp2 = 40 +" "+ (char) 0x00B0+"C";
//    String temp3 = 60 +" "+ (char) 0x00B0+"C";
//    String temp4 = 80 +" "+ (char) 0x00B0+"C";
//    String temp5 = 100 +" "+ (char) 0x00B0+"C";
//
//    String hum1 = 20+" "+ (char) 0x0025;
//    String hum2 = 40+" "+ (char) 0x0025;
//    String hum3 = 40+" "+ (char) 0x0025;
//    String hum4 = 40+" "+ (char) 0x0025;
//    String hum5 = 100+" "+ (char) 0x0025;
//
//    String co2_1 = 1000 + " ppm";
//    String co2_2 = 2000 + " ppm";
//    String co2_3 = 3500 + " ppm";
//    String co2_4 = 2500 + " ppm";
//    String co2_5 = 5000 + " ppm";
//
//    String yield1 = 200 + " Kg";
//    String yield2 = 240 + " Kg";
//    String yield3 = 150 + " Kg";
//    String yield4 = 320 + " Kg";
//    String yield5 = 540 + " Kg";


    //create a list of items for 6 spinners.
    // Insert real values here
//    String[] tempItems = new String[]{"Average Temperature "+ (char) 0x00B0+"C","20","40","60","80","100"};
//    String[] humItems = new String[]{"Average Humidity  "+ (char) 0x0025,"20","40","60","80","100"};
//    String[] co2Items = new String[]{"Average CO2 level  "+ "ppm","450","500","1500","3000","2000"};
//    String[] diseasedItems = new String[]{"Diseased Average","Yes","No"};
//    String[] havesItems = new String[]{"Right Harvesting Time Average","Yes","No"};
//    String[] yieldItems = new String[]{"Yield per day (Kg)","100","200","300","400","500"};


    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    EditText popup_d1,popup_d2,popup_d3,popup_d4,popup_d5;
    Button popup_cancel,popup_ok;
    TextView popup_title;

    String popup_title_text;
    int popupID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypdashboard);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnTemp = findViewById(R.id.spinnerTemp);
        btnHum = findViewById(R.id.spinnerHumidity);
        btnCo2 = findViewById(R.id.spinnerCo2);
        btnDisease = findViewById(R.id.spinnerDisease);
        btnHarvest = findViewById(R.id.spinnerHarvest);
        btnYield = findViewById(R.id.spinnerYield);

        btnNext = findViewById(R.id.btnYPNew);
        btnHome = findViewById(R.id.btnYPHome);

//        setDataSpinners();
//
//        getDataSpinners();

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });
        btnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "Temperature "+ (char) 0x00B0+"C";
                popupID = 1;
                createNewContactDialog(popup_title_text,popupID);

            }
        });
        btnHum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "Humidity  "+ (char) 0x0025;
                popupID = 2;
                createNewContactDialog(popup_title_text,popupID);

            }
        });
        btnCo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "CO2 level  "+ "ppm";
                popupID = 2;
                createNewContactDialog(popup_title_text,popupID);

            }
        });
        btnDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "Diseased (Yes/No)";
                popupID = 3;
                createNewContactDialog(popup_title_text,popupID);

            }
        });
        btnHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "Harvested in Time (Yes/";
                popupID = 4;
                createNewContactDialog(popup_title_text,popupID);

            }
        });
        btnYield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_title_text = "Yield per day (Kg)";
                popupID = 5;
                createNewContactDialog(popup_title_text,popupID);

            }
        });




    }
//    private void setDataSpinners(){
//
//        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
//        //There are multiple variations of this, but this is the basic variant.
//        ArrayAdapter<String> adapterTemp = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tempItems);
//        ArrayAdapter<String> adapterHum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, humItems);
//        ArrayAdapter<String> adapterCo2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, co2Items);
//        ArrayAdapter<String> adapterDisease = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, diseasedItems);
//        ArrayAdapter<String> adapterHarves = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, havesItems);
//        ArrayAdapter<String> adapterYield = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, yieldItems);
//
//        //set the spinners adapter to the previously created one.
//        tempSpinner.setAdapter(adapterTemp);
//        humSpinner.setAdapter(adapterHum);
//        co2Spinner.setAdapter(adapterCo2);
//        diseasedSpinner.setAdapter(adapterDisease);
//        harvesSpinner.setAdapter(adapterHarves);
//        yieldSpinner.setAdapter(adapterYield);
//    }
//
//    private void getDataSpinners(){
//
//        //get selected value here (spinner selected value)
////        itemStr = yieldSpinner.getSelectedItem().toString();
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(yieldSpinner.getSelectedItem().toString() != "Yield per day (Kg)") {
//
//                    if(tempSpinner.getSelectedItem().toString() != "Average Temperature "+ (char) 0x00B0+"C")
//                    {
//                        itemTemp = tempSpinner.getSelectedItem().toString();
//                    }
//                    if(humSpinner.getSelectedItem().toString() != "Average Humidity  "+ (char) 0x0025){
//                        itemHum = humSpinner.getSelectedItem().toString();
//                    }
//                    if(co2Spinner.getSelectedItem().toString() != "Average CO2 level  "+ "ppm"){
//                        itemCo2 = co2Spinner.getSelectedItem().toString();
//                    }
//                    if(diseasedSpinner.getSelectedItem().toString() != "Diseased Average"){
//                        itemDisease = diseasedSpinner.getSelectedItem().toString();
//                    }
//                    if(harvesSpinner.getSelectedItem().toString() != "Right Harvesting Time Average"){
//                        itemHarvest = harvesSpinner.getSelectedItem().toString();
//                    }
//
//                    itemStr = yieldSpinner.getSelectedItem().toString();
//
//                    if(itemTemp != null && itemHum != null && itemDisease != null && itemHarvest != null){
//
//                        //put selected vale and start new activity
//                        Intent mIntent = new Intent(YPDashboard.this, YPRecommendation.class);
//                        mIntent.putExtra("data", itemStr);
//                        startActivity(mIntent);
//
//                    }else{
//                        Toast.makeText(getApplicationContext(),"Please select values",Toast.LENGTH_SHORT).show();
//                    }
//
//                }else{
//
//                    Toast.makeText(getApplicationContext(),"Please select values",Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//
//    }

    private void createNewContactDialog(String title,int id){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popup,null);
        popup_d1 = contactPopupView.findViewById(R.id.popup_d1);
        popup_d2 = contactPopupView.findViewById(R.id.popup_d2);
        popup_d3 = contactPopupView.findViewById(R.id.popup_d3);
        popup_d4 = contactPopupView.findViewById(R.id.popup_d4);
        popup_d5 = contactPopupView.findViewById(R.id.popup_d5);

        popup_cancel = contactPopupView.findViewById(R.id.btnCancel);
        popup_ok = contactPopupView.findViewById(R.id.btnOk);

        popup_title = contactPopupView.findViewById(R.id.btnValue);
        popup_title.setText(title);

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();

        popup_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        popup_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}