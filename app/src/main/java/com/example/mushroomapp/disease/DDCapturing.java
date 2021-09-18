package com.example.mushroomapp.disease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.theartofdev.edmodo.cropper.CropImage;

public class DDCapturing extends AppCompatActivity {

    ImageButton btnHome;
    ImageView imgGet;
    Button btnUpload;
    Button btnDDAnlyze;

    Boolean setState = true; //this must be true if uploaded image is ok.

    Uri mimgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddcapturing);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        btnHome = findViewById(R.id.btnYPHome);
        imgGet = findViewById(R.id.imgDDUpload);

        btnUpload = findViewById(R.id.btnDDGallery);

        btnDDAnlyze = findViewById(R.id.btnDDAnalyze);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChooseFile(imgGet);
            }
        });

        btnDDAnlyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DDResults.class);
                i.putExtra("data", mimgUri);
                startActivity(i);
            }
        });

    }

    public void onChooseFile(View v){
        CropImage.activity().start(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if(resultCode==RESULT_OK){
                mimgUri=result.getUri();
                if(setState){
                    imgGet.setImageURI(mimgUri);
                }
                else{
                    imgGet.setImageResource(R.drawable.dummy);
                }
            }
            else if(resultCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception e = result.getError();
                Toast.makeText(this,"Possible error is : "+e,Toast.LENGTH_SHORT).show();
            }
        }

    }

}