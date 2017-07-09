package com.example.xjl.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xjl.customview.PieView.PieData;
import com.example.xjl.customview.PieView.PieView;

import java.util.ArrayList;

public class PieviewActivityActivity extends AppCompatActivity {

    ArrayList<PieData> mData=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieview_activity);

        PieData pieData1=new PieData("first",20);
        PieData pieData2=new PieData("second",50);
        PieData pieData3=new PieData("third",43);
        PieData pieData4=new PieData("furth",87);
        PieData pieData5=new PieData("fifth",63);
        PieData pieData6=new PieData("six",54);
        PieData pieData7=new PieData("seven",36);

        mData.add(pieData1);
        mData.add(pieData2);
        mData.add(pieData3);
        mData.add(pieData4);
        mData.add(pieData5);
        mData.add(pieData6);
        mData.add(pieData7);

        PieView pieView = (PieView) findViewById(R.id.pieView);

        pieView.setData(mData);
    }
}
