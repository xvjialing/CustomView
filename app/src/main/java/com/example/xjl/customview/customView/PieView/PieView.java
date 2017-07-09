package com.example.xjl.customview.customView.PieView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by xjl on 17-5-24.
 */

public class PieView extends View {

    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    //饼状图初始绘制角度
    private float mStartAngle=0;

    //数据
    private ArrayList<PieData> mData;

    //宽高
    private int mWidth,mHeight;

    //画笔
    private Paint mPaint=new Paint();

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
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
        if (mData==null)
            return;
        float curruntAngle=mStartAngle;    //当前起始角度
        canvas.translate(mWidth/2,mHeight/2);  //将画布坐标原点移动到中心位置
        float r= (float) (Math.min(mWidth,mHeight)/2*0.8);
        RectF rectF=new RectF(-r,-r,r,r);

        for (PieData data:mData){
            mPaint.setColor(data.getColor());
            canvas.drawArc(rectF,curruntAngle,data.getAngle(),true,mPaint);
            curruntAngle+=data.getAngle();
        }
    }

    //设置起始角度
    public void setStartAngle(int startAngle){
        this.mStartAngle=startAngle;
        invalidate();  //刷新
    }

    //设置数据
    public void setData(ArrayList<PieData> mData){
        this.mData=mData;
        initData(mData);
        invalidate();  //刷新
    }

    // 初始化数据
    private void initData(ArrayList<PieData> mData){
        if (mData==null||mData.size()==0)
            return;

        float sumValue=0;

        int size=mData.size();
        for (int i=0;i<size;i++){
            PieData pieData = mData.get(i);

            sumValue+=pieData.getValue();  //计算数值和
            int j=i%mColors.length;   //设置颜色
            pieData.setColor(mColors[j]);

        }

        float sumAngle=0;

        for (PieData data:mData){
            float percentage=data.getValue()/sumValue;   //百分比
            float angle =percentage*360;

            data.setPercentage(percentage);     //记录百分比
            data.setAngle(angle);    //记录角度大小
            sumAngle+=angle;

            Log.d("angle",""+data.getAngle());
        }
    }
}
