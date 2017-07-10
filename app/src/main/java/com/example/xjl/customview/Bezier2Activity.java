package com.example.xjl.customview;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xjl.customview.customView.Bezier2;

public class Bezier2Activity extends AppCompatActivity {
    private RadioButton rb_control1;
    private RadioButton rb_control2;
    private RadioGroup rg_mode;
    private Bezier2 bezier2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier2);

        initView();
    }

    private void initView() {
        bezier2 = (Bezier2) findViewById(R.id.bezier2);
        rb_control1 = (RadioButton) findViewById(R.id.rb_control1);
        rb_control2 = (RadioButton) findViewById(R.id.rb_control2);
        rg_mode = (RadioGroup) findViewById(R.id.rg_mode);
        rg_mode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rb_control1:
                        bezier2.setMode(true);
                        break;
                    case R.id.rb_control2:
                        bezier2.setMode(false);
                        break;
                }
            }
        });
    }
}
