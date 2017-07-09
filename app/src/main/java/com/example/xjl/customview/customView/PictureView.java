package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 这次我们了解的Picture和上文中的录像功能是类似的，只不过我们Picture录的是Canvas中绘制的内容。
 *  我们把Canvas绘制点，线，矩形等诸多操作用Picture录制下来，下次需要的时候拿来就能用，使用Picture相比于再次调用绘图API，开销是比较小的，也就是说对于重复的操作可以更加省时省力。
 *   PS：你可以把Picture看作是一个录制Canvas操作的录像机。
 */
public class PictureView extends View {
    private int mWidth,mHeight;

    // 1.创建Picture
    private Picture mPicture = new Picture();

    //2.录制内容的方法
    private void recording(){
        //开始录制(接收返回值Canvas)
        Canvas canvas=mPicture.beginRecording(mWidth,mHeight);
        //创建画笔
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);



        //在canvas中具体操作
        //位移
        canvas.translate(mWidth/2,mHeight/2);
        //绘制一个圆
        canvas.drawCircle(0,0,mWidth>mHeight?mHeight/2:mWidth/2,paint);
        //结束录制
        mPicture.endRecording();

    }

    public PictureView(Context context) {
        super(context);
    }

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        recording();


        // 将Picture中的内容绘制在Canvas上
//        这种方法在比较低版本的系统上绘制后可能会影响Canvas状态，所以这种方法一般不会使用
//        mPicture.draw(canvas);

//        使用Canvas提供的drawPicture方法绘制和使用Picture的draw方法不同，Canvas的drawPicture不会影响Canvas状态
//        canvas.drawPicture(mPicture);
//        canvas.drawPicture(mPicture,new RectF(0,0,mPicture.getWidth()/2,mPicture.getHeight()/2));

        //包装成drawble
        PictureDrawable drawable=new PictureDrawable(mPicture);
        //设置绘制区域,注意此处所绘制的内容不会缩放
        drawable.setBounds(0,0,mPicture.getWidth()/2,mPicture.getHeight()/2);
        //绘制
        drawable.draw(canvas);
    }
}
