package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-7-11.
 */

public class PathMeasureView extends View{
    private Paint mPaint;
    private int width,height;

    private void init(){
        mPaint=new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
    }
    public PathMeasureView(Context context) {
        super(context);
        init();
    }

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);
        mPaint.setStrokeWidth(4);
        canvas.drawLine(-width/2,0,width/2,0,mPaint);
        canvas.drawLine(0,-height/2,0,height/2,mPaint);

        mPaint.setStrokeWidth(10);
        Path path=new Path();
        path.addRect(-200,-200,200,200, Path.Direction.CW);

        Path dst=new Path();              // 创建用于存储截取后内容的 Path
//        dst.lineTo(-300, -300);

        PathMeasure pathMeasure=new PathMeasure(path,true);   // 将 Path 与 PathMeasure 关联

        pathMeasure.getSegment(200,600,dst,false);

        canvas.drawPath(dst,mPaint);

    }
}
