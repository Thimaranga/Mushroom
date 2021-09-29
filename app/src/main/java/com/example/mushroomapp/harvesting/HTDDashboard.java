package com.example.mushroomapp.harvesting;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;

public class HTDDashboard extends AppCompatActivity {

    Button btnCam;
    Button btnAnlyze;
    ImageButton btnReset;
    ImageView imgGet;
    ImageButton btnHome;
    ImageButton btnHistory;

    //Firebase Storage.
    FirebaseStorage storage;
    StorageReference storageReference;

    Uri mimgUri;
    Uri secondUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htddashboard);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        btnCam = findViewById(R.id.btnAdd);
        imgGet = findViewById(R.id.imgGetImage);
        btnAnlyze = findViewById(R.id.btnAnalyze);

        btnReset = findViewById(R.id.btnHTDHistoryBack);
        btnHome = findViewById(R.id.btnYPHome);
        btnHistory = findViewById(R.id.btnYPNew);

        imgGet.setImageResource(R.drawable.dummy);


        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChooseFile(imgGet);
            }
        });
        btnAnlyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
                Intent i = new Intent(getApplicationContext(),HarvestingResults.class);
                i.putExtra("data", mimgUri);
                startActivity(i);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgGet.setImageResource(R.drawable.dummy);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HTDHistory.class);
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

        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if(resultCode==RESULT_OK){
                mimgUri=result.getUri();
                String url3 = result.getUri().toString();
                Log.d("CheckURL",url3);
                imgGet.setImageURI(mimgUri);
            }
            else if(resultCode==CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception e = result.getError();
                Toast.makeText(this,"Possible error is : "+e,Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getFileExtension(Uri imgUri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imgUri));
    }

    public void uploadImage(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();

        String url = mimgUri.toString();
        Log.d("CheckURL",url);

        if(mimgUri != null){
            StorageReference fileRef = FirebaseStorage.getInstance().getReference().child("Uploads");

            fileRef.putFile(mimgUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String url2 = uri.toString();
                            Log.d("downloadURL",url2);
                            pd.dismiss();
                            Toast.makeText(getApplicationContext(),"Image Upload Successfully",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }
}