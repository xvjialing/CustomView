package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-7-10.
 */

public class InfoWindowView extends View{
    private Paint bgPaint;
    private Paint textPaint;
    private int mWidth,mHeight;

    private void initPaint(){
        bgPaint=new Paint();
        bgPaint.setColor(Color.argb(0xAA,0xFF,0xFF,0xFF));
        bgPaint.setStyle(Paint.Style.FILL);
        textPaint=new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStrokeWidth(5);
        textPaint.setStyle(Paint.Style.STROKE);
    }

    public InfoWindowView(Context context) {
        super(context);
        initPaint();
    }

    public InfoWindowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight=h;
        mWidth=w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth/2,mHeight/2);


    }
}
