package com.nov.openview.demo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.nov.openview.R;
import com.nov.openview.utils.ViewConvertUtil;

import java.util.ArrayList;

/**
 * Created by yangzhicong on 2017/3/2.
 */
public class MyDotView extends View {

    private Paint mCirclePaint;
    private float radial = ViewConvertUtil.dip2px(getContext(), 5);
    private int color = R.color.colorWhite;
    private ArrayList<ValueAnimator> mAnimators;
    int[] alphaInts = new int[]{0, 0, 0};
    int[] xValue = new int[]{0, 50, 100};
    int duration = 1400;
    int width;
    int height;

    public MyDotView(Context context) {
        super(context, null);
        initPaint();
    }

    public MyDotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        mAnimators = onCreateAnimators();
    }

    private void initPaint() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(getResources().getColor(color));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 3; i++) {
            mCirclePaint.setAlpha(alphaInts[i]);
            canvas.drawCircle(width / 4 + xValue[i], height / 2, radial, mCirclePaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        long[] delays = new long[]{0, 160, 320};
        for (int i = 0; i < 3; i++) {
            final int index = i;
            ValueAnimator alphaAnim = ValueAnimator.ofInt(0, 255, 0, 0);
            alphaAnim.setDuration(duration);
            alphaAnim.setRepeatCount(-1);
            alphaAnim.setInterpolator(new LinearInterpolator());
            alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    alphaInts[index] = (int) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            alphaAnim.setStartDelay(delays[i]);
            animators.add(alphaAnim);
        }
        return animators;
    }


    public void startAnimators() {
        for (ValueAnimator animator : onCreateAnimators()) {
            animator.start();
        }
    }

    public void stopAnimators() {
        if (mAnimators != null) {
            for (ValueAnimator animator : mAnimators) {
                if (animator != null && animator.isStarted()) {
                    animator.removeAllUpdateListeners();
                    animator.end();
                }
            }
        }
    }
}