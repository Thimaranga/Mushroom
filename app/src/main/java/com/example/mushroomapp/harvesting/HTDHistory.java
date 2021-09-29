package com.example.mushroomapp.harvesting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

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

//        TableRow tr1 = new TableRow(this);
//        tr1.setLayoutParams(new LinearLayout.LayoutParams( TableLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//
//        TextView textview = new TextView(this);
//        textview.setText("Hello");
//
//        TextView textview2 = new TextView(this);
//        textview2.setText("World");

        //textview.getTextColors(R.color.)
//        textview.setTextColor(Color.YELLOW);
//        tr1.addView(textview);
//        tl.addView(tr1, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

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

        //Read data from database
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("HarvestDetails");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                collectData((Map<String,Object>) snapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void collectData(Map<String, Object> users) {

        ArrayList<String> ImageUrl = new ArrayList<>();
        ArrayList<String> dTime = new ArrayList<>();
        ArrayList<String> Edate = new ArrayList<>();
        ArrayList<String> hStatus = new ArrayList<>();

        int cnt = 0;

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){
            cnt=cnt+1;
        }
        String [][] arry2=new String[cnt][4];

        //arry=new String[][]{{"Hello","World","25","Male"},{"asd","sdsd","dasdsa","asddas"}};

        int tempCount=0;
        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();

//            arry2[tempCount][0]=String.valueOf((Long) singleUser.get("Age"));
            arry2[tempCount][0]=(String) singleUser.get("imgDetails");
            arry2[tempCount][1]=(String) singleUser.get("hTime");
            arry2[tempCount][2]=(String) singleUser.get("hDate");
            arry2[tempCount][3]=(String) singleUser.get("hStatus");

            tempCount=tempCount+1;


        }
        showTableLayout(arry2);
        String te = String.valueOf(cnt);

        Log.d("Hell",te);
    }

    public  void showTableLayout(String [][] arry){

        tl.setStretchAllColumns(true);
        tl.bringToFront();

        TableRow th =  new TableRow(this);
        th.layout(10,10,10,10);


        TextView txtGenericMain1 = new TextView(this);
        //txtGeneric.setTextSize(24);
        txtGenericMain1.setText("Image");
        txtGenericMain1.setBackgroundColor(Color.LTGRAY);
        txtGenericMain1.setGravity(Gravity.CENTER_HORIZONTAL);
        th.addView(txtGenericMain1);
        txtGenericMain1.setTextColor(Color.BLACK);

        TextView txtGenericMain2 = new TextView(this);
        //txtGeneric.setTextSize(24);
        txtGenericMain2.setText("Detected Time");
        txtGenericMain2.setBackgroundColor(Color.LTGRAY);
        txtGenericMain2.setGravity(Gravity.CENTER_HORIZONTAL);
        th.addView(txtGenericMain2);
        txtGenericMain2.setTextColor(Color.BLACK);

        TextView txtGenericMain3 = new TextView(this);
        //txtGeneric.setTextSize(24);
        txtGenericMain3.setText("Expiry Date");
        txtGenericMain3.setBackgroundColor(Color.LTGRAY);
        txtGenericMain3.setGravity(Gravity.CENTER_HORIZONTAL);
        th.addView(txtGenericMain3);
        txtGenericMain3.setTextColor(Color.BLACK);

        TextView txtGenericMain4 = new TextView(this);
        //txtGeneric.setTextSize(24);
        txtGenericMain4.setText("Harvest Status");
        txtGenericMain4.setBackgroundColor(Color.LTGRAY);
        txtGenericMain4.setGravity(Gravity.CENTER_HORIZONTAL);
        th.addView(txtGenericMain4);
        txtGenericMain4.setTextColor(Color.BLACK);


        tl.addView(th);

        for(int i = 0; i < arry.length; i++){

            TableRow tr =  new TableRow(this);
            tr.layout(0,40,0,40);
            for(int j = 0; j < arry[0].length; j++)
            {

                TextView txtGeneric = new TextView(this);
                //txtGeneric.setTextSize(24);
                txtGeneric.setText(arry[i][j]);
                tr.addView(txtGeneric);
                //txtGeneric.setHeight(30);
                txtGeneric.setGravity(Gravity.CENTER_HORIZONTAL);
                txtGeneric.setTextColor(Color.BLACK);
                if(i%2==0){
                    txtGeneric.setBackgroundColor(Color.LTGRAY);
                }else{
                    txtGeneric.setBackgroundColor(Color.GRAY);
                }

            }
            tl.addView(tr);
        }
    }

}