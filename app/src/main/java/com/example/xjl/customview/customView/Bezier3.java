package com.example.xjl.customview.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-7-10.
 */

public class Bezier3 extends View{
    private static final float C = 0.551915024494f;     // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置


    public Bezier3(Context context) {
        super(context);
    }

    public Bezier3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
