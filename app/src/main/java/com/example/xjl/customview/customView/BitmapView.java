package com.example.xjl.customview.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.xjl.customview.R;

/**
 * Created by xjl on 17-7-9.
 */

public class BitmapView extends View{
    private Context mContext;

    public BitmapView(Context context) {
        super(context);
        mContext=context;
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap= BitmapFactory.decodeResource(mContext.getResources(), R.drawable.account);

        canvas.drawBitmap(bitmap,new Matrix(),new Paint());
    }
}
