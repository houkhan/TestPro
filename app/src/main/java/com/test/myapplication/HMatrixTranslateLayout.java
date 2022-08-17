package com.test.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class HMatrixTranslateLayout extends LinearLayout {
    private static final String TAG = "HMatrixTranslateLayout";
    private int parentWidth = 0;
    private int topOffset = 0;

    public HMatrixTranslateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setParentWidth(int width) {
        parentWidth = width;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        Log.d(TAG, "topOffset1 --" + topOffset);
        if (topOffset == 0) {
            topOffset = getWidth() / 2;
        }
        Log.d(TAG, "topOffset2 --" + topOffset);
        Log.d(TAG, "getLeft --" + getLeft());
        int left = getLeft() + topOffset;
        Log.d(TAG, "left --" + left);
        Log.d(TAG, "parentWidth --" + parentWidth);
        float tran = calculateTranslate(left, parentWidth);

        Log.d(TAG, "calculateTranslate --" + tran);

        Matrix m = canvas.getMatrix();
        m.setTranslate(0, tran);
        canvas.concat(m);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    private float calculateTranslate(int left, int w) {
        float result;
        int hh = w / 2;
        result = Math.abs(left - hh);
        return (float) (result / 3.14);
    }
}
