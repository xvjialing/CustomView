package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xjl on 17-7-10.
 */

public class Bezier2 extends View{
    private Paint mainPaint;
    private Paint secondPaint;
    private int centerX,centerY;

    private PointF start,end,control1,control2;
    private boolean mode=true;

    private void initPaint(){
        mainPaint=new Paint();
        mainPaint.setColor(Color.GRAY);
        mainPaint.setStyle(Paint.Style.STROKE);
        mainPaint.setStrokeWidth(20);
        secondPaint=new Paint();
        mainPaint.setColor(Color.RED);
        mainPaint.setStyle(Paint.Style.STROKE);
        mainPaint.setStrokeWidth(8);

        start=new PointF(0,0);
        end=new PointF(0,0);
        control1=new PointF(0,0);
        control2=new PointF(0,0);
    }

    public Bezier2(Context context) {
        super(context);
        initPaint();
    }

    public Bezier2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX=w/2;
        centerY=h/2;

        //初始化数据点与控制点的位置
        start.x=centerX-200;
        start.y=centerY;
        end.x=centerX+200;
        end.y=centerY;
        control1.x=centerX;
        control1.y=centerY+100;
        control2.x=centerX;
        control2.y=centerY-100;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 根据触摸位置更新控制点，并提示重绘
        if (mode) {
            control1.x = event.getX();
            control1.y = event.getY();
        } else {
            control2.x = event.getX();
            control2.y = event.getY();
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制控制点与数据点
        canvas.drawPoint(start.x,start.y,mainPaint);
        canvas.drawPoint(end.x,end.y,mainPaint);
        canvas.drawPoint(control1.x,control1.y,mainPaint);
        canvas.drawPoint(control2.x,control2.y,mainPaint);

        //绘制辅助线
        mainPaint.setStrokeWidth(4);
        canvas.drawLine(start.x,start.y,control1.x,control1.y,mainPaint);
        canvas.drawLine(control1.x,control1.y,control2.x,control2.y,mainPaint);
        canvas.drawLine(control2.x,control2.y,end.x,end.y,mainPaint);

        //绘制贝赛尔曲线
        Path path=new Path();
        path.moveTo(start.x,start.y);
        path.cubicTo(control1.x,control1.y,control2.x,control2.y,end.x,end.y);
        canvas.drawPath(path,secondPaint);
    }
}
