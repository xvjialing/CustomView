package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-5-23.
 */

public class CustomView extends View {

    //搜狗拼音
    private Paint mPaint=new Paint();

    private int mWidth,mHeight;

    public CustomView(Context context) {
        super(context);

        initPaint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
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
        //绘制颜色是填充整个画布，常用于绘制底色。
//        canvas.drawColor(Color.BLUE); //绘制蓝色


//        绘制点：
//        可以绘制一个点，也可以绘制一组点，如下：
        canvas.drawPoint(200,200,mPaint);
        canvas.drawPoints(new float[]{500,500,500,600},mPaint);


//        绘制直线：
//        绘制直线需要两个点，初始点和结束点，同样绘制直线也可以绘制一条或者绘制一组：
//        canvas.drawLine(300,300,500,600,mPaint);    // 在坐标(300,300)(500,600)之间绘制一条直线
//        canvas.drawLines(new float[]{               // 绘制一组线 每四数字(两个点的坐标)确定一条线
//                100,200,200,200,
//                100,300,200,300
//        },mPaint);




//        绘制矩形：
//        确定一个矩形最少需要四个数据，就是对角线的两个点的坐标值，这里一般采用左上角和右下角的两个点的坐标。
//
//        关于绘制矩形，Canvas提供了三种重载方法，第一种就是提供四个数值(矩形左上角和右下角两个点的坐标)来确定一个矩形进行绘制。
//        其余两种是先将矩形封装为Rect或RectF(实际上仍然是用两个坐标点来确定的矩形)，然后传递给Canvas绘制，如下：
        // 第一种
//        canvas.drawRect(100,100,800,400,mPaint);

        // 第二种
//        Rect rect = new Rect(100,100,800,400);
//        canvas.drawRect(rect,mPaint);

        // 第三种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRect(rectF,mPaint);

//        Rect和RectF两者最大的区别就是精度不同，Rect是int(整形)的，而RectF是float(单精度浮点型)的。
//        除了精度不同，两种提供的方法也稍微存在差别

//        绘制圆角矩形：
//        绘制圆角矩形也提供了两种重载方式，如下：

        // 第一种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRoundRect(rectF,30,30,mPaint);

        // 第二种
//        canvas.drawRoundRect(100,100,800,400,30,30,mPaint);

        // 矩形
//        RectF rectF = new RectF(100,100,800,400);

        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF,mPaint);

        // 绘制圆角矩形
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRoundRect(rectF,700,400,mPaint);

//        绘制椭圆：
//        相对于绘制圆角矩形，绘制椭圆就简单的多了，因为他只需要一个矩形作为参数:

        // 第一种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawOval(rectF,mPaint);

        // 第二种
//        canvas.drawOval(100,100,800,400,mPaint);

//        绘制圆：
//        绘制圆形也比较简单, 如下：

//        canvas.drawCircle(500,500,400,mPaint);  // 绘制一个圆心坐标在(500,500)，半径为400 的圆。
//        绘制圆形有四个参数，前两个是圆心坐标，第三个是半径，最后一个是画笔。

//        canvas.drawCircle(mWidth/2,mHeight/2,300,mPaint);

//        绘制圆弧：
//        绘制圆弧就比较神奇一点了，为了理解这个比较神奇的东西，我们先看一下它需要的几个参数：

        // 第一种
//        public void drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter, @NonNull Paint paint){}

        // 第二种
//        public void drawArc(float left, float top, float right, float bottom, float startAngle,
//        float sweepAngle, boolean useCenter, @NonNull Paint paint) {}
//        从上面可以看出，相比于绘制椭圆，绘制圆弧还多了三个参数：

//        startAngle  // 开始角度
//        sweepAngle  // 扫过角度
//        useCenter   // 是否使用中心

//        RectF rectF = new RectF(100,100,800,400);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF,0,90,false,mPaint);
//
//        //-------------------------------------
//
//        RectF rectF2 = new RectF(100,600,800,900);
//        // 绘制背景矩形
//        mPaint.setColor(Color.GRAY);
//        canvas.drawRect(rectF2,mPaint);
//
//        // 绘制圆弧
//        mPaint.setColor(Color.BLUE);
//        canvas.drawArc(rectF2,0,90,true,mPaint);

//        简要介绍Paint
//        看了上面这么多，相信有一部分人会产生一个疑问，如果我想绘制一个圆，只要边不要里面的颜色怎么办？
//        很简单，绘制的基本形状由Canvas确定，但绘制出来的颜色,具体效果则由Paint确定。
//        如果你注意到了的话，在一开始我们设置画笔样式的时候是这样的：

//        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
//        为了展示方便，容易看出效果，之前使用的模式一直为填充模式，实际上画笔有三种模式，如下：

//        STROKE                //描边
//        FILL                  //填充
//        FILL_AND_STROKE       //描边加填充
//        为了区分三者效果我们做如下实验：

//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setStrokeWidth(40);     //为了实验效果明显，特地设置描边宽度非常大
//
//        // 描边
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(200,200,100,paint);
//
//        // 填充
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(200,500,100,paint);
//
//        // 描边加填充
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawCircle(200, 800, 100, paint);
    }

    //初始化画笔
    private void initPaint(){
        mPaint.setColor(Color.BLACK);  //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);  //设置画笔宽度为10px
    }
}
