package com.example.mushroomapp.environmental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class EMSHistory extends AppCompatActivity {


    TableLayout table;
    //String arry[][]= {{"Hello","World","25","Male"},{"asd","sdsd","dasdsa","asddas"}};
    int x=1;
//    String [][] arry=new String[x][4];

    ImageButton home;
    ImageButton back;
    ImageButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emshistory);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        home=findViewById(R.id.btnYPHome);
        back=findViewById(R.id.btnEMSBack);
        refresh=findViewById(R.id.btnEMSRefresh);

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
                Intent i = new Intent(getApplicationContext(), EMSGraph.class);
                startActivity(i);
            }
        });

        table = findViewById(R.id.tblEMSlayout);
        //showTableLayout();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("SensorData");
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

        ArrayList<String> Temp = new ArrayList<>();
        ArrayList<String> Hum = new ArrayList<>();
        ArrayList<String> Co2 = new ArrayList<>();
        ArrayList<String> Date = new ArrayList<>();
        ArrayList<String> Time = new ArrayList<>();



        int cnt = 0;

        //iterate through each user, ignoring their UID
        for (Map.Entry<String, Object> entry : users.entrySet()){
            cnt=cnt+1;
        }
        //arry=new String[cnt][4];
        String [][] arry2=new String[cnt][5];

        //arry=new String[][]{{"Hello","World","25","Male"},{"asd","sdsd","dasdsa","asddas"}};



        int tempCount=0;
        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list

//            Date.add((String) singleUser.get("sendDate"));
//            Time.add((String) singleUser.get("sendTime"));
//            Temp.add((Long) singleUser.get("sendTemp"));
//            Hum.add((Long) singleUser.get("sendHum"));
//            Co2.add((Long) singleUser.get("sendCo2"));

//            arry2[tempCount][0]=String.valueOf((Long) singleUser.get("Age"));
            arry2[tempCount][0]=(String) singleUser.get("sendDate");
            arry2[tempCount][1]=(String) singleUser.get("sendTime");
            arry2[tempCount][2]=(String) singleUser.get("sendTemp");
            arry2[tempCount][3]=(String) singleUser.get("sendHum");
            arry2[tempCount][4]=(String) singleUser.get("sendCo2");

            tempCount=tempCount+1;


        }
        showTableLayout(arry2);
        String te = String.valueOf(cnt);

        Log.d("Hell",te);
    }

    public  void showTableLayout(String [][] arry){
        int rows = 2;
        int colums  = 4;


        table.setStretchAllColumns(true);
        table.bringToFront();

        TableRow th =  new TableRow(this);
        th.layout(10,10,10,10);
        for(int i =0;i<arry[i].length;i++){
            TextView txtGenericMain = new TextView(this);
            //txtGeneric.setTextSize(24);
            txtGenericMain.setText("Check");
            txtGenericMain.setBackgroundColor(Color.LTGRAY);
            th.addView(txtGenericMain);
            txtGenericMain.setTextColor(Color.BLACK);
        }
        table.addView(th);

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
                txtGeneric.setTextColor(Color.BLACK);
                if(i%2==0){
                    txtGeneric.setBackgroundColor(Color.LTGRAY);
                }else{
                    txtGeneric.setBackgroundColor(Color.GRAY);
                }

            }
            table.addView(tr);
        }
    }

}