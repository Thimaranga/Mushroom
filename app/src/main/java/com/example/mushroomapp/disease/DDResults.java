package com.example.mushroomapp.disease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;

public class DDResults extends AppCompatActivity {

    Uri imgDDRes;
    ImageView imgMain;
    ImageButton btnHome;

    TextView txtLocalName,txtScienceName,txtDisc,txtPrevent;

    String localName = "Hello",scienceName = "World",description = "Add Description Here",prevent = "Add Prevention Here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddresults);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        imgMain = findViewById(R.id.imageView9);

        btnHome = findViewById(R.id.btnHTDHistoryHome);

        imgDDRes = getIntent().getExtras().getParcelable("data");
        imgMain.setImageURI(imgDDRes);

        txtLocalName = findViewById(R.id.txtLocalName);
        txtScienceName = findViewById(R.id.txtLocalName2);
        txtDisc = findViewById(R.id.txtDDAddDiscription);
        txtPrevent = findViewById(R.id.txtDDAddPrevent);

        txtLocalName.setText(localName);
        txtScienceName.setText(scienceName);
        txtDisc.setText(description);
        txtPrevent.setText(prevent);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });
    }
}