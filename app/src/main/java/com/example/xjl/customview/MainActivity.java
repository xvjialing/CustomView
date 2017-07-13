package com.example.xjl.customview;

import android.content.Intent;
import android.graphics.PathMeasure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;

    private List<String> colums=new ArrayList<>();
    private CommonAdapter<String> commonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();


    }

    private void initData() {
        colums.add("PieView");
        colums.add("CustomView");
        colums.add("drawPicture");
        colums.add("drawBitmap");
        colums.add("drawText");
        colums.add("drawPath");
        colums.add("nest");
        colums.add("Bezier");
        colums.add("Bezier2");
        colums.add("Bezier3");
        colums.add("PathMeasure");
        colums.add("PathView");
        commonAdapter = new CommonAdapter<String>(this,R.layout.item,colums) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.item_text,s);
            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,PieviewActivityActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,CustomActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,DrawPictureActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,DrawBitmapActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,DrawTextActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this,DrawPathActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this,PathNestActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this,SecondBezierActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this,Bezier2Activity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this,Bezier3Activity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, PathMeasureActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, PathViewActivity.class));
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        rv_main.setAdapter(commonAdapter);
    }

    private void initView() {
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rv_main.setLayoutManager(manager);
    }
}
