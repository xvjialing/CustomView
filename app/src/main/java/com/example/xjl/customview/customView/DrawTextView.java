package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-7-9.
 */

public class DrawTextView extends View{
    private Paint mPaint=new Paint();

    private int mWidth,mHeight;

    //初始化画笔
    private void initPaint(){
        mPaint.setColor(Color.BLACK);  //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setTextSize(50);
    }


    public DrawTextView(Context context) {
        super(context);
        initPaint();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String str="bvwbeweboweiwo";

        //参数分别是(文本 基线X 基线Y 画笔)
        canvas.drawText(str,100,200,mPaint);
    }


}
