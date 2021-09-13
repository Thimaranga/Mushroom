package com.example.mushroomapp.environmental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mushroomapp.IntroActivity;
import com.example.mushroomapp.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class EMSGraph extends AppCompatActivity {

    private static final String TAG = "EMSGraphActivity";

    private LineChart mChart;

    ImageButton home;
    ImageButton history;
    ImageButton refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_e_m_s_graph);

        home=findViewById(R.id.btnHTDHistoryHome);
        history=findViewById(R.id.btnEMSHistoryGraph);
        refresh=findViewById(R.id.btnHTDHistoryBack);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                startActivity(i);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EMSHistory.class);
                startActivity(i);
            }
        });

        mChart = (LineChart)findViewById(R.id.lineChart);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        ArrayList<Entry> yValuesTemp = new ArrayList<>();
        ArrayList<Entry> yValuesHumidity = new ArrayList<>();
        ArrayList<Entry> yValuesCo2 = new ArrayList<>();

        yValuesTemp.add(new Entry(0,60f));
        yValuesTemp.add(new Entry(1,50f));
        yValuesTemp.add(new Entry(2,70f));
        yValuesTemp.add(new Entry(3,30f));
        yValuesTemp.add(new Entry(4,50f));
        yValuesTemp.add(new Entry(5,60f));
        yValuesTemp.add(new Entry(6,65f));

        yValuesHumidity.add(new Entry(0,10f));
        yValuesHumidity.add(new Entry(1,60f));
        yValuesHumidity.add(new Entry(2,40f));
        yValuesHumidity.add(new Entry(3,50f));
        yValuesHumidity.add(new Entry(4,55f));
        yValuesHumidity.add(new Entry(5,75f));
        yValuesHumidity.add(new Entry(6,35f));

        yValuesCo2.add(new Entry(0,25f));
        yValuesCo2.add(new Entry(1,30f));
        yValuesCo2.add(new Entry(2,10f));
        yValuesCo2.add(new Entry(3,60f));
        yValuesCo2.add(new Entry(4,45f));
        yValuesCo2.add(new Entry(5,55f));
        yValuesCo2.add(new Entry(6,68f));

        LineDataSet setTemp = new LineDataSet(yValuesTemp,"Temperature");
        LineDataSet setHumidity = new LineDataSet(yValuesHumidity,"Humidity");
        LineDataSet setCo2 = new LineDataSet(yValuesCo2,"CO2");

        setTemp.setFillAlpha(110);
        setTemp.setColor(Color.RED);
        setTemp.setLineWidth(3f);
        setTemp.setValueTextSize(14f);

        setHumidity.setFillAlpha(60);
        setHumidity.setColor(Color.BLUE);
        setHumidity.setLineWidth(3f);
        setHumidity.setValueTextSize(14f);

        setCo2.setFillAlpha(110);
        setCo2.setColor(Color.GREEN);
        setCo2.setLineWidth(3f);
        setCo2.setValueTextSize(14f);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setTemp);
        dataSets.add(setHumidity);
        dataSets.add(setCo2);

        LineData data = new LineData(dataSets);

        mChart.setData(data);
        mChart.invalidate();

        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisLeft().setDrawLabels(false);
        mChart.getAxisLeft().setDrawAxisLine(false);

        mChart.getXAxis().setDrawGridLines(false);
        mChart.getXAxis().setDrawLabels(false);
        mChart.getXAxis().setDrawAxisLine(false);

        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getAxisRight().setDrawLabels(false);
        mChart.getAxisRight().setDrawAxisLine(false);

        mChart.getDescription().setEnabled(false);

        mChart.setDrawBorders(true);
    }
}