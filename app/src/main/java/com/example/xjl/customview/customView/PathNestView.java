package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xjl on 17-7-10.
 */

public class PathNestView extends View{
    private int count = 6;                //数据个数
    private float angle = (float) (Math.PI*2/count);
    private float radius;                   //网格最大半径
    private int centerX;                  //中心X
    private int centerY;                  //中心Y
    private String[] titles = {"a","b","c","d","e","f"};
    private double[] data = {100,60,60,60,100,50,10,20}; //各维度分值
    private float maxValue = 100;             //数据最大值
    private Paint mainPaint=new Paint();                //雷达区画笔
    private Paint valuePaint=new Paint();               //数据区画笔
    private Paint textPaint=new Paint();                //文本画笔

    private void initPaint(){
        mainPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mainPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mainPaint.setStrokeWidth(1);              // 边框宽度 - 10
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(20);
        valuePaint.setColor(Color.BLUE);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public PathNestView(Context context) {
        super(context);
        initPaint();
    }

    public PathNestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(h, w)/2*0.9f;
        //中心坐标
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 绘制多边形
     * @param canvas
     */
    private void drawPolygon(Canvas canvas){
        Path path=new Path();
        float r=radius/(count-1);//r是蜘蛛丝之间的距离
        for (int i=1;i<count;i++){//中心点不用绘制
            float currentR=r*i; //当前半径
            path.reset();
            for (int j=0;j<count;j++){
                if (j==0){
                    path.moveTo(centerX+currentR,centerY);
                }else {
                    //根据半径,计算蜘蛛丝上每个点的坐标
                    float x=(float)(centerX+currentR*Math.cos(angle*j));
                    float y= (float) (centerY+currentR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            path.close();
            canvas.drawPath(path,mainPaint);
        }
    }

    //绘制直线
    private void drawLines(Canvas canvas){
        Path path=new Path();
        for (int i=0;i<count;i++){
            path.reset();
            path.moveTo(centerX,centerY);
            float x= (float) (centerX+radius*Math.cos(angle*i));
            float y= (float) (centerY+radius*Math.sin(angle*i));
            path.lineTo(x,y);
            canvas.drawPath(path,mainPaint);
        }
    }

    /**
     * 绘制文字
     * @param canvas
     */
    private void drawText(Canvas canvas){
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for(int i=0;i<count;i++){
            float x = (float) (centerX+(radius+fontHeight/2)*Math.cos(angle*i));
            float y = (float) (centerY+(radius+fontHeight/2)*Math.sin(angle*i));
            if(angle*i>=0&&angle*i<=Math.PI/2){//第4象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>=3*Math.PI/2&&angle*i<=Math.PI*2){//第3象限
                canvas.drawText(titles[i], x,y,textPaint);
            }else if(angle*i>Math.PI/2&&angle*i<=Math.PI){//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }else if(angle*i>=Math.PI&&angle*i<3*Math.PI/2){//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x-dis,y,textPaint);
            }
        }
    }

    /**
     * 绘制区域
     * @param canvas
     */
    private void drawRegion(Canvas canvas){
        Path path = new Path();
        valuePaint.setAlpha(255);
        for(int i=0;i<count;i++){
            double percent = data[i]/maxValue;
            float x = (float) (centerX+radius*Math.cos(angle*i)*percent);
            float y = (float) (centerY+radius*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x, centerY);
            }else{
                path.lineTo(x,y);
            }
            //绘制小圆点
            canvas.drawCircle(x,y,10,valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPolygon(canvas);
        drawLines(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    //设置标题
    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    //设置数值
    public void setData(double[] data) {
        this.data = data;
    }

    //设置最大数值
    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    //设置蜘蛛网颜色
    public void setMainPaintColor(int color){
        mainPaint.setColor(color);
    }

    //设置标题颜色
    public void setTextPaintColor(int color){
        textPaint.setColor(color);
    }

    //设置覆盖局域颜色
    public void setValuePaintColor(int color){
        valuePaint.setColor(color);
    }
}
