package com.example.mushroomapp.harvesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class HTDHistory extends AppCompatActivity {

    TableLayout tl;

    ImageButton home,history,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htdhistory);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        home=findViewById(R.id.btnYPHome);
        back=findViewById(R.id.btnHTDHistoryBack);
        history=findViewById(R.id.btnHTDHistoryRefresh);

        tl = findViewById(R.id.tlMainHTD);

        TableRow tr1 = new TableRow(this);
        tr1.setLayoutParams(new LinearLayout.LayoutParams( TableLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView textview = new TextView(this);
        textview.setText("Hello");

        TextView textview2 = new TextView(this);
        textview2.setText("World");

        //textview.getTextColors(R.color.)
        textview.setTextColor(Color.YELLOW);
        tr1.addView(textview);
        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HTDDashboard.class);
                startActivity(i);
            }
        });
    }
}